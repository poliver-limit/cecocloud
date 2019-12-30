/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.logic.helper.AsymmetricCryptographyHelper;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;

/**
 * Implementació del servei de gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IdentificadorServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Identificador, IdentificadorEntity, Long> implements IdentificadorService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;

	@Override
	protected void beforePermissionCreate(Long id, BaseBootPermission permission) {
		permission.setAccessGranted(true);
	}
	@Override
	protected void afterPermissionCreate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			UsuariIdentificadorPk usuariIdentificadorPk = new UsuariIdentificadorPk(
					usuari.get().getId(),
					identificador.get().getId());
			UsuariIdentificadorEntity usuariIdentificador = UsuariIdentificadorEntity.builder().
					pk(usuariIdentificadorPk).
					embedded(new UsuariIdentificador()).
					usuari(usuari.get()).
					identificador(identificador.get()).
					build();
			usuariIdentificadorRepository.save(usuariIdentificador);
		}
	}

	@Override
	protected void beforePermissionUpdate(Long id, BaseBootPermission permission) {
		permission.setAccessGranted(true);
	}
	@Override
	protected void afterPermissionUpdate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			UsuariIdentificadorPk usuariIdentificadorPk = new UsuariIdentificadorPk(
					usuari.get().getId(),
					identificador.get().getId());
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findById(usuariIdentificadorPk);
			if (usuariIdentificador.isPresent()) {
				usuariIdentificadorRepository.delete(usuariIdentificador.get());
			} else if (!usuariIdentificador.isPresent()) {
				UsuariIdentificadorEntity usuariIdentificadorPerCrear = UsuariIdentificadorEntity.builder().
						pk(usuariIdentificadorPk).
						embedded(new UsuariIdentificador()).
						usuari(usuari.get()).
						identificador(identificador.get()).
						build();
				usuariIdentificadorRepository.save(usuariIdentificadorPerCrear);
			}
		}
	}

	@Override
	protected void afterPermissionDelete(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType() && permission.isAdminGranted()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			UsuariIdentificadorPk usuariIdentificadorPk = new UsuariIdentificadorPk(
					usuari.get().getId(),
					identificador.get().getId());
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findById(usuariIdentificadorPk);
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
	protected void beforeDelete(IdentificadorEntity entity) {
		super.beforeDelete(entity);
		// Eliminar permisos
		List<BaseBootPermission> permisos = permissionFind(entity.getId());
		for (BaseBootPermission permis: permisos) {
			permissionDelete(entity.getId(), permis.getId());
		}
	}

	@Override
	protected void afterCreate(IdentificadorEntity entity, Identificador dto) {
		super.afterCreate(entity, dto);
		// Assignar permisos al propietari
		BaseBootPermission permission = new BaseBootPermission(
				PermissionSidType.PRINCIPAL,
				entity.getPropietari().getEmbedded().getCodi());
		permission.setAccessGranted(true);
		permission.setAdminGranted(true);
		permissionCreate(entity.getId(), permission);
	}

	@Override
	protected void afterUpdate(IdentificadorEntity entity, Identificador dto) {
		super.afterUpdate(entity, dto);
		// Assignar permisos al propietari
		BaseBootPermission permission = new BaseBootPermission(
				PermissionSidType.PRINCIPAL,
				entity.getPropietari().getEmbedded().getCodi());
		permission.setAccessGranted(true);
		permission.setAdminGranted(true);
		permissionCreate(entity.getId(), permission);
	}

	private void generateLicense(Identificador dto) {
		Llicencia llicencia = new Llicencia(
				dto.getCodi(),
				dto.getDescripcio(),
				dto.getNumEmpreses(),
				dto.getNumUsuaris(),
				dto.getDataInici(),
				dto.getDataFi(),
				null,	// Moduls
				null);	// Caracteristiques
		ObjectMapper mapper = new ObjectMapper();
		String llicenciaJson;
		try {
			llicenciaJson = mapper.writeValueAsString(llicencia);
			dto.setLlicencia(AsymmetricCryptographyHelper.encryptText(llicenciaJson));
		} catch (Exception e) {
			throw new LicenseGenerationException("Error generating the license.", e);
		}
	}

}
