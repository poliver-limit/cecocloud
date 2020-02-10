/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.ActionExecutionResult;
import es.limit.base.boot.logic.api.dto.ActionExecutionResult.ActionExecutionState;
import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecurs;
import es.limit.cecocloud.logic.api.helper.FuncionalitatAcl;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.FuncionalitatService;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatRecursRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRepository;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatServiceImpl extends AbstractGenericServiceImpl<Funcionalitat, FuncionalitatEntity, Long> implements FuncionalitatService {

	@Autowired
	private FuncionalitatAcl funcionalitatAcl;
	@Autowired
	private FuncionalitatRepository funcionalitatRepository;
	@Autowired
	private FuncionalitatRecursRepository funcionalitatRecursRepository;

	@Override
	@Transactional
	public ActionExecutionResult execute(
			String action,
			Long id) {
		if ("sync".equals(action)) {
			List<es.limit.base.boot.logic.api.module.ModuleInfo> modules = Modules.registeredFindAll();
			for (es.limit.base.boot.logic.api.module.ModuleInfo moduleInfo: modules) {
				ModuleInfo cecocloudModuleInfo = (ModuleInfo)moduleInfo;
				List<FuncionalitatCodiFont> funcionalitats = cecocloudModuleInfo.getFuncionalitats();
				// Elimina les funcionalitats no utilitzades
				List<FuncionalitatEntity> funcionalitatEntities = funcionalitatRepository.findByEmbeddedModul(cecocloudModuleInfo.getModul());
				for (FuncionalitatEntity funcionalitatEntity: funcionalitatEntities) {
					boolean trobada = false;
					for (FuncionalitatCodiFont funcionalitatCodiFont: funcionalitats) {
						if (funcionalitatCodiFont.getCodi().equals(funcionalitatEntity.getEmbedded().getCodi())) {
							trobada = true;
							break;
						}
					}
					if (!trobada) {
						funcionalitatRepository.delete(funcionalitatEntity);
					}
				}
				// Crea o modifica les demés funcionalitats
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
						Funcionalitat funcionalitat = new Funcionalitat();
						funcionalitat.setCodi(funcionalitatCodiFont.getCodi());
						funcionalitat.setTipus(funcionalitatCodiFont.getTipus());
						funcionalitat.setDescripcio(funcionalitatCodiFont.getDescripcio());
						funcionalitat.setModul(funcionalitatCodiFont.getModul());
						funcionalitatSaved = funcionalitatRepository.save(
								FuncionalitatEntity.
								builder().
								embedded(funcionalitat).
								build());
					}
					boolean hiHaCanvisRecursos = false;
					List<FuncionalitatRecursEntity> funcionalitatRecursos = funcionalitatRecursRepository.findByFuncionalitat(funcionalitatSaved);
					// Elimina els recursos de la funcionalitat no utilitzats
					for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatRecursos) {
						boolean trobada = false;
						for (Class<? extends Identificable<?>> recursClass: funcionalitatCodiFont.getRecursosPrincipals()) {
							if (funcionalitatRecurs.getRecursClassName().equals(recursClass.getName())) {
								trobada = true;
								break;
							}
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
							funcionalitatRecursRepository.delete(funcionalitatRecurs);
							hiHaCanvisRecursos = true;
						}
					}
					// Refresca els recursos principals de la funcionalitat
					refrescarRecursos(
							funcionalitatSaved,
							funcionalitatCodiFont.getRecursosPrincipals(),
							funcionalitatRecursos,
							true);
					// Refresca els recursos secundaris de la funcionalitat
					refrescarRecursos(
							funcionalitatSaved,
							funcionalitatCodiFont.getRecursosSecundaris(),
							funcionalitatRecursos,
							false);
					if (hiHaCanvisRecursos) {
						// TODO propagar canvis en els recursos als ACLs
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
				FuncionalitatRecurs funcionalitatRecurs = new FuncionalitatRecurs();
				funcionalitatRecurs.setPrincipal(principal);
				funcionalitatRecursRepository.save(
						FuncionalitatRecursEntity.builder().
						embedded(funcionalitatRecurs).
						funcionalitat(funcionalitat).
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
