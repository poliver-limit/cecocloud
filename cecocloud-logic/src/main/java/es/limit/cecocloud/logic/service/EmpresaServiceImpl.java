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
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.repository.UsuariEmpresaRepository;

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
	private UsuariEmpresaRepository usuariEmpresaRepository;

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
			UsuariEmpresaPk usuariEmpresaPk = new UsuariEmpresaPk(
					usuari.get().getId(),
					empresa.get().getId());
			UsuariEmpresaEntity usuariEmpresa = UsuariEmpresaEntity.builder().
					pk(usuariEmpresaPk).
					embedded(new UsuariEmpresa()).
					usuari(usuari.get()).
					empresa(empresa.get()).
					build();
			usuariEmpresaRepository.save(usuariEmpresa);
		}
	}

	@Override
	protected void afterPermissionUpdate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<EmpresaEntity> empresa = getRepository().findById(id);
			UsuariEmpresaPk usuariEmpresaPk = new UsuariEmpresaPk(
					usuari.get().getId(),
					empresa.get().getId());
			Optional<UsuariEmpresaEntity> usuariEmpresa = usuariEmpresaRepository.findById(usuariEmpresaPk);
			if (usuariEmpresa.isPresent() && !hasAnyPermission(permission)) {
				usuariEmpresaRepository.delete(usuariEmpresa.get());
			} else if (!usuariEmpresa.isPresent() && hasAnyPermission(permission)) {
				UsuariEmpresaEntity usuariEmpresaPerCrear = UsuariEmpresaEntity.builder().
						pk(usuariEmpresaPk).
						embedded(new UsuariEmpresa()).
						usuari(usuari.get()).
						empresa(empresa.get()).
						build();
				usuariEmpresaRepository.save(usuariEmpresaPerCrear);
			}
		}
	}

	@Override
	protected void afterPermissionDelete(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType() && permission.isAdminGranted()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<EmpresaEntity> empresa = getRepository().findById(id);
			UsuariEmpresaPk usuariEmpresaPk = new UsuariEmpresaPk(
					usuari.get().getId(),
					empresa.get().getId());
			Optional<UsuariEmpresaEntity> usuariEmpresa = usuariEmpresaRepository.findById(usuariEmpresaPk);
			if (usuariEmpresa.isPresent()) {
				usuariEmpresaRepository.delete(usuariEmpresa.get());
			}
		}
	}

	private boolean hasAnyPermission(BaseBootPermission permission) {
		return permission.isReadGranted();
	}

}
