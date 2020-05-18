/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class EmpresaServiceImpl extends AbstractGenericServiceImpl<Empresa, EmpresaEntity, Long> implements EmpresaService {

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	protected void afterCreate(EmpresaEntity entity, Empresa dto) {
		// Propagar creació de l'entitat als demès mòduls
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					EmpresaIdentificadorSyncService syncService = applicationContext.getBean(cecocloudModule.getEmpresaIdentificadorSyncServiceClass());
					switch (dto.getTipus()) {
					case COMPTABLE:
						syncService.empresaComptableCreate(dto);
						break;
					case GESTIO:
						syncService.empresaGestioCreate(dto);
						break;
					}
				}
			}
		}
	}

	@Override
	protected void beforeUpdate(EmpresaEntity entity, Empresa dto) {
		// Evita que es modifiqui el codi de l'empresa
		dto.setCodi(entity.getEmbedded().getCodi());
	}

	@Override
	protected void afterUpdate(EmpresaEntity entity, Empresa dto) {
		// Propagar modificació de l'entitat als demès mòduls
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					EmpresaIdentificadorSyncService syncService = applicationContext.getBean(cecocloudModule.getEmpresaIdentificadorSyncServiceClass());
					switch (dto.getTipus()) {
					case COMPTABLE:
						syncService.empresaComptableUpdate(dto);
						break;
					case GESTIO:
						syncService.empresaGestioUpdate(dto);
						break;
					}
				}
			}
		}
	}

	@Override
	protected void afterDelete(EmpresaEntity entity) {
		// Propagar eliminació de l'entitat als demès mòduls
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					EmpresaIdentificadorSyncService syncService = applicationContext.getBean(cecocloudModule.getEmpresaIdentificadorSyncServiceClass());
					switch (entity.getEmbedded().getTipus()) {
					case COMPTABLE:
						syncService.empresaComptableDelete(entity.getEmbedded());
						break;
					case GESTIO:
						syncService.empresaGestioDelete(entity.getEmbedded());
						break;
					}
				}
			}
		}
	}

}
