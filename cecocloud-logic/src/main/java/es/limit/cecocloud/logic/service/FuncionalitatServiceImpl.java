/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.ActionExecutionResult;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.logic.api.dto.ActionExecutionResult.ActionExecutionState;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecurs;
import es.limit.cecocloud.logic.api.helper.FuncionalitatAcl;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.FuncionalitatService;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;
import es.limit.cecocloud.persist.entity.RecursEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorPerfilRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRecursRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRepository;
import es.limit.cecocloud.persist.repository.RecursRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class FuncionalitatServiceImpl extends AbstractGenericServiceImpl<Funcionalitat, FuncionalitatEntity, Long> implements FuncionalitatService {

	@Autowired
	private FuncionalitatAcl funcionalitatAcl;
	@Autowired
	private FuncionalitatRepository funcionalitatRepository;
	@Autowired
	private FuncionalitatRecursRepository funcionalitatRecursRepository;
	@Autowired
	private FuncionalitatIdentificadorPerfilRepository funcionalitatIdentificadorPerfilRepository;
	@Autowired
	private RecursRepository recursRepository;

	@Override
	public ActionExecutionResult execute(
			String action,
			Long id) {
		if ("sync".equals(action)) {
			List<es.limit.base.boot.logic.api.module.ModuleInfo> modules = Modules.registeredFindAll();
			for (es.limit.base.boot.logic.api.module.ModuleInfo moduleInfo: modules) {
				ModuleInfo cecocloudModuleInfo = (ModuleInfo)moduleInfo;
				log.debug("    Sincronitzant funcionalitats del mòdul " + cecocloudModuleInfo.getModul());
				Collection<FuncionalitatCodiFont> funcionalitats = cecocloudModuleInfo.getFuncionalitats().values();
				// Elimina les funcionalitats no utilitzades
				List<FuncionalitatEntity> funcionalitatEntities = funcionalitatRepository.findByEmbeddedModul(cecocloudModuleInfo.getModul());
				for (FuncionalitatEntity funcionalitatEntity: funcionalitatEntities) {
					boolean trobada = false;
					if (funcionalitats != null) {
						for (FuncionalitatCodiFont funcionalitatCodiFont: funcionalitats) {
							if (funcionalitatCodiFont.getCodi().equals(funcionalitatEntity.getEmbedded().getCodi())) {
								trobada = true;
								break;
							}
						}
					}
					if (!trobada) {
						// Eliminam permisos dels perfils
						List<FuncionalitatIdentificadorPerfilEntity> fips = funcionalitatIdentificadorPerfilRepository.findByFuncionalitatIdentificadorFuncionalitat(funcionalitatEntity);
						funcionalitatIdentificadorPerfilRepository.deleteAll(fips);
						try {
							funcionalitatAcl.updatePermisosFuncionalitatRecurs(funcionalitatEntity.getId());
						} catch (ClassNotFoundException ex) {
							log.error("No s'han pogut actualitzar els permisos de la funcionalitat " + funcionalitatEntity.getEmbedded().getCodi(), ex);
						}
						funcionalitatRepository.delete(funcionalitatEntity);
					}
				}
				// Crea o modifica les demés funcionalitats
				if (funcionalitats != null) {
					for (FuncionalitatCodiFont funcionalitatCodiFont: funcionalitats) {
						Optional<FuncionalitatEntity> funcionalitatEntity = funcionalitatRepository.findByEmbeddedCodiAndEmbeddedModul(
								funcionalitatCodiFont.getCodi(),
								cecocloudModuleInfo.getModul());
						FuncionalitatEntity funcionalitatSaved;
						if (funcionalitatEntity.isPresent()) {
							Funcionalitat funcionalitat = funcionalitatEntity.get().getEmbedded();
							funcionalitat.setTipus(funcionalitatCodiFont.getTipus());
							funcionalitat.setDescripcio(funcionalitatCodiFont.getDescripcio());
							funcionalitatSaved = funcionalitatEntity.get();
						} else {
							log.debug("        Afegint funcionalitat \"" + funcionalitatCodiFont.getDescripcio() + "\" (" + funcionalitatCodiFont.getCodi() + ") del mòdul " + cecocloudModuleInfo.getModul());
							Funcionalitat funcionalitat = new Funcionalitat();
							funcionalitat.setCodi(funcionalitatCodiFont.getCodi());
							funcionalitat.setTipus(funcionalitatCodiFont.getTipus());
							funcionalitat.setDescripcio(funcionalitatCodiFont.getDescripcio());
							funcionalitat.setModul(cecocloudModuleInfo.getModul());
							funcionalitatSaved = funcionalitatRepository.save(
									FuncionalitatEntity.builder().
									embedded(funcionalitat).
									build());
						}
						boolean hiHaCanvisRecursos = false;
						List<FuncionalitatRecursEntity> funcionalitatRecursos = funcionalitatRecursRepository.findByFuncionalitat(funcionalitatSaved);
						// Elimina els recursos de la funcionalitat no utilitzats
						for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatRecursos) {
							boolean trobada = false;
							String recursClassName = funcionalitatRecurs.getRecurs().getEmbedded().getClassName();
							if (recursClassName.equals(funcionalitatCodiFont.getRecursPrincipal().getName())) {
								trobada = true;
							}
							if (!trobada) {
								for (Class<? extends Identificable<?>> recursClass: funcionalitatCodiFont.getRecursosSecundaris()) {
									if (funcionalitatRecurs.getRecursClassName().equals(recursClass.getName())) {
										trobada = true;
										break;
									}
								}
							}
							if (!trobada) {
								log.debug("        Eliminant recurs " + funcionalitatRecurs.getRecursClassName() + " de la funcionalitat \"" + funcionalitatCodiFont.getDescripcio() + "\" (" + funcionalitatCodiFont.getCodi() + ") del mòdul " + cecocloudModuleInfo.getModul());
								funcionalitatRecursRepository.delete(funcionalitatRecurs);
								hiHaCanvisRecursos = true;
							}
						}
						// Refresca els recursos principals de la funcionalitat
						if (refrescarRecursos(
								funcionalitatSaved,
								Arrays.asList(funcionalitatCodiFont.getRecursPrincipal()),
								funcionalitatRecursos,
								true)) {
							hiHaCanvisRecursos = true;
						}
						// Refresca els recursos secundaris de la funcionalitat
						if (refrescarRecursos(
								funcionalitatSaved,
								funcionalitatCodiFont.getRecursosSecundaris(),
								funcionalitatRecursos,
								false)) {
							hiHaCanvisRecursos = true;
						}
						if (hiHaCanvisRecursos) {
							try {
								funcionalitatAcl.updatePermisosFuncionalitatRecurs(funcionalitatSaved.getId());
							} catch (ClassNotFoundException ex) {
								log.error("No s'han pogut actualitzar els permisos de la funcionalitat " + funcionalitatSaved.getEmbedded().getCodi(), ex);
							}
						}
					}
				}
			}
			return new ActionExecutionResult(ActionExecutionState.OK, null, 0);
		} else {
			return super.execute(action, id);
		}
	}

	private boolean refrescarRecursos(
			FuncionalitatEntity funcionalitat,
			List<Class<? extends Identificable<?>>> recursosClasses,
			List<FuncionalitatRecursEntity> funcionalitatRecursos,
			boolean principal) {
		boolean hiHaCanvisRecursos = false;
		for (Class<? extends Identificable<?>> recursClass: recursosClasses) {
			FuncionalitatRecursEntity funcionalitatRecursTrobada = null;
			for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatRecursos) {
				if (recursClass.getName().equals(funcionalitatRecurs.getRecursClassName())) {
					funcionalitatRecursTrobada = funcionalitatRecurs;
					break;
				}
			}
			if (funcionalitatRecursTrobada != null) {
				if (funcionalitatRecursTrobada.getEmbedded().isPrincipal() != principal) {
					funcionalitatRecursTrobada.getEmbedded().setPrincipal(principal);
					hiHaCanvisRecursos = true;
				}
			} else {
				Optional<RecursEntity> recursEntity = recursRepository.findByEmbeddedClassName(recursClass.getName());
				FuncionalitatRecurs funcionalitatRecurs = new FuncionalitatRecurs();
				funcionalitatRecurs.setPrincipal(principal);
				log.debug("        Afegint recurs " + (principal ? "principal " : "") + recursClass.getName() + " a la funcionalitat \"" + funcionalitat.getEmbedded().getDescripcio() + "\" (" + funcionalitat.getEmbedded().getCodi() + ") del mòdul " + funcionalitat.getEmbedded().getModul());
				FuncionalitatRecursEntity repetida = funcionalitatRecursRepository.findByFuncionalitatAndRecurs(funcionalitat, recursEntity.get());
				if (repetida != null) {
					log.warn("Funcionalitat repetida!");
				}
				funcionalitatRecursRepository.save(
						FuncionalitatRecursEntity.builder().
						embedded(funcionalitatRecurs).
						funcionalitat(funcionalitat).
						recurs(recursEntity.get()).
						build());
				hiHaCanvisRecursos = true;
			}
		}
		return hiHaCanvisRecursos;
	}

	@Override
	protected void afterDelete(FuncionalitatEntity entity) {
		super.afterDelete(entity);
		try {
			funcionalitatAcl.updatePermisosFuncionalitatRecurs(entity.getId());
		} catch (ClassNotFoundException ex) {
			log.error("No s'han pogut esborrar els permisos de la funcionalitat " + entity.getEmbedded().getCodi(), ex);
		}
	}

}
