/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.service.AbstractGenericServiceWithPermissionsImpl;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class EmpresaServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Empresa, EmpresaEntity, Long> implements EmpresaService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;
	@Autowired
	private UsuariIdentificadorEmpresaRepository usuariIdentificadorEmpresaRepository;

	@Override
	protected void afterCreate(EmpresaEntity entity, Empresa dto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		BaseBootPermission permission = new BaseBootPermission(
				PermissionSidType.PRINCIPAL,
				auth.getName());
		permission.setReadGranted(true);
		permissionCreate(
				entity.getId(),
				permission);
	}

	@Override
	protected void afterPermissionCreate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType() && hasAnyPermission(permission)) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<EmpresaEntity> empresa = getRepository().findById(id);
			IdentificadorEntity identificador = empresa.get().getIdentificador();
			UsuariIdentificadorPk usuariIdentificadorPk = new UsuariIdentificadorPk(
					usuari.get().getId(),
					identificador.getId());
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findById(usuariIdentificadorPk);
			UsuariIdentificadorEmpresaPk usuariIdentificadorEmpresaPk = new UsuariIdentificadorEmpresaPk(
					usuari.get().getId(),
					identificador.getId(),
					empresa.get().getId());
			UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa = UsuariIdentificadorEmpresaEntity.builder().
					pk(usuariIdentificadorEmpresaPk).
					embedded(new UsuariIdentificadorEmpresa()).
					usuariIdentificador(usuariIdentificador.get()).
					empresa(empresa.get()).
					build();
			usuariIdentificadorEmpresaRepository.save(usuariIdentificadorEmpresa);
		}
	}

	@Override
	protected void afterPermissionUpdate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<EmpresaEntity> empresa = getRepository().findById(id);
			IdentificadorEntity identificador = empresa.get().getIdentificador();
			UsuariIdentificadorPk usuariIdentificadorPk = new UsuariIdentificadorPk(
					usuari.get().getId(),
					identificador.getId());
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findById(usuariIdentificadorPk);
			UsuariIdentificadorEmpresaPk usuariIdentificadorEmpresaPk = new UsuariIdentificadorEmpresaPk(
					usuari.get().getId(),
					identificador.getId(),
					empresa.get().getId());
			Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.findById(usuariIdentificadorEmpresaPk);
			if (usuariIdentificadorEmpresa.isPresent() && !hasAnyPermission(permission)) {
				usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresa.get());
			} else if (!usuariIdentificadorEmpresa.isPresent() && hasAnyPermission(permission)) {
				UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresaPerCrear = UsuariIdentificadorEmpresaEntity.builder().
						pk(usuariIdentificadorEmpresaPk).
						embedded(new UsuariIdentificadorEmpresa()).
						usuariIdentificador(usuariIdentificador.get()).
						empresa(empresa.get()).
						build();
				usuariIdentificadorEmpresaRepository.save(usuariIdentificadorEmpresaPerCrear);
			}
		}
	}

	@Override
	protected void afterPermissionDelete(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType() && permission.isAdminGranted()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<EmpresaEntity> empresa = getRepository().findById(id);
			IdentificadorEntity identificador = empresa.get().getIdentificador();
			UsuariIdentificadorEmpresaPk usuariIdentificadorEmpresaPk = new UsuariIdentificadorEmpresaPk(
					usuari.get().getId(),
					identificador.getId(),
					empresa.get().getId());
			Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.findById(usuariIdentificadorEmpresaPk);
			if (usuariIdentificadorEmpresa.isPresent()) {
				usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresa.get());
			}
		}
	}

	private boolean hasAnyPermission(BaseBootPermission permission) {
		return permission.isReadGranted();
	}

}
