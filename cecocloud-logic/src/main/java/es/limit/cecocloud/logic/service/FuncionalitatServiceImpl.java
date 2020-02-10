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
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.FuncionalitatService;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatRepository;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatServiceImpl extends AbstractGenericServiceImpl<Funcionalitat, FuncionalitatEntity, Long> implements FuncionalitatService {

	@Autowired
	private FuncionalitatRepository funcionalitatRepository;

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
					if (funcionalitatEntity.isPresent()) {
						Funcionalitat funcionalitat = funcionalitatEntity.get().getEmbedded();
						funcionalitat.setTipus(funcionalitatCodiFont.getTipus());
						funcionalitat.setDescripcio(funcionalitatCodiFont.getDescripcio());
						// TODO actualitzar recursos i propagar canvis als ACLs
					} else {
						Funcionalitat funcionalitat = new Funcionalitat();
						funcionalitat.setCodi(funcionalitatCodiFont.getCodi());
						funcionalitat.setTipus(funcionalitatCodiFont.getTipus());
						funcionalitat.setDescripcio(funcionalitatCodiFont.getDescripcio());
						funcionalitat.setModul(funcionalitatCodiFont.getModul());
						funcionalitatRepository.save(
								FuncionalitatEntity.
								builder().
								embedded(funcionalitat).
								build());
					}
				}
			}
			return new ActionExecutionResult(ActionExecutionState.OK, null, 0);
		} else {
			return super.execute(action, id);
		}
	}

}
