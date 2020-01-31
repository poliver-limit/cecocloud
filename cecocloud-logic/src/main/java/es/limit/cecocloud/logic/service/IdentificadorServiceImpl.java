/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.api.exception.LicenseGenerationException;
import es.limit.base.boot.logic.service.AbstractGenericServiceWithPermissionsImpl;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Llicencia;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.logic.helper.AsymmetricCryptographyHelper;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;

/**
 * Implementació del servei encarregat de gestionar identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IdentificadorServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Identificador, IdentificadorEntity, Long> implements IdentificadorService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	protected void beforePermissionCreate(Long id, BaseBootPermission permission) {
		permission.setReadGranted(true);
	}
	@Override
	protected void afterPermissionCreate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			createUsuariIdentificadorIfNotExists(usuari.get(), identificador.get());
		}
	}

	@Override
	protected void beforePermissionUpdate(Long id, BaseBootPermission permission) {
		permission.setReadGranted(true);
	}
	@Override
	protected void afterPermissionUpdate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
					usuari.get(),
					identificador.get());
			if (usuariIdentificador.isPresent()) {
				usuariIdentificadorRepository.delete(usuariIdentificador.get());
			} else if (!usuariIdentificador.isPresent()) {
				createUsuariIdentificadorIfNotExists(usuari.get(), identificador.get());
			}
		}
	}

	@Override
	protected void afterPermissionDelete(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType() && permission.isAdminGranted()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
					usuari.get(),
					identificador.get());
			if (usuariIdentificador.isPresent()) {
				usuariIdentificadorRepository.delete(usuariIdentificador.get());
			}
		}
	}

	@Override
	protected void beforeCreate(IdentificadorEntity entity, Identificador dto) {
		super.beforeCreate(entity, dto);
		generateLicense(dto);
	}

	@Override
	protected void beforeUpdate(IdentificadorEntity entity, Identificador dto) {
		super.beforeUpdate(entity, dto);
		generateLicense(dto);
	}

	@Override
	protected void afterCreate(IdentificadorEntity entity, Identificador dto) {
		super.afterCreate(entity, dto);
		assignarPermisosPropietari(entity);
		// Propagar creació de l'entitat als demès mòduls
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					EmpresaIdentificadorSyncService syncService = applicationContext.getBean(cecocloudModule.getEmpresaIdentificadorSyncServiceClass());
					syncService.identificadorCreate(dto);
				}
			}
		}
	}

	@Override
	protected void afterUpdate(IdentificadorEntity entity, Identificador dto) {
		super.afterUpdate(entity, dto);
		assignarPermisosPropietari(entity);
		// Propagar modificació de l'entitat als demès mòduls
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					EmpresaIdentificadorSyncService syncService = applicationContext.getBean(cecocloudModule.getEmpresaIdentificadorSyncServiceClass());
					syncService.identificadorUpdate(dto);
				}
			}
		}
	}

	@Override
	protected void afterDelete(IdentificadorEntity entity) {
		super.afterDelete(entity);
		// Eliminar permisos
		List<BaseBootPermission> permisos = permissionFind(entity.getId());
		for (BaseBootPermission permis: permisos) {
			permissionDelete(entity.getId(), permis.getId());
		}
		// Propagar eliminació de l'entitat als demès mòduls
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					EmpresaIdentificadorSyncService syncService = applicationContext.getBean(cecocloudModule.getEmpresaIdentificadorSyncServiceClass());
					syncService.identificadorDelete(entity.getEmbedded());
				}
			}
		}
	}

	private void generateLicense(Identificador dto) {
		Llicencia llicencia = new Llicencia(
				dto.getCodi(),
				dto.getDescripcio(),
				dto.getNumEmpreses(),
				dto.getNumUsuaris(),
				dto.getDataInici(),
				dto.getDataFi(),
				null,  // Moduls
				null); // Caracteristiques
		ObjectMapper mapper = new ObjectMapper();
		String llicenciaJson;
		try {
			llicenciaJson = mapper.writeValueAsString(llicencia);
			dto.setLlicencia(AsymmetricCryptographyHelper.encryptText(llicenciaJson));
		} catch (Exception e) {
			throw new LicenseGenerationException("Error generating the license.", e);
		}
	}

	private void createUsuariIdentificadorIfNotExists(
			UsuariEntity usuari,
			IdentificadorEntity identificador) {
		Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
				usuari,
				identificador);
		if (!usuariIdentificador.isPresent()) {
			UsuariIdentificadorEntity usuariIdentificadorPerCrear = UsuariIdentificadorEntity.builder().
					embedded(new UsuariIdentificador()).
					usuari(usuari).
					identificador(identificador).
					build();
			usuariIdentificadorRepository.save(usuariIdentificadorPerCrear);
		}
	}

	private void assignarPermisosPropietari(IdentificadorEntity entity) {
		BaseBootPermission permission = new BaseBootPermission(
				PermissionSidType.PRINCIPAL,
				entity.getPropietari().getEmbedded().getCodi());
		permission.setReadGranted(true);
		permission.setAdminGranted(true);
		permissionCreate(entity.getId(), permission);
	}

}
