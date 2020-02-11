/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class EmpresaServiceImpl extends AbstractGenericServiceImpl<Empresa, EmpresaEntity, Long> implements EmpresaService {

	/*@Autowired
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
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
					usuari.get(),
					identificador);
			UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa = UsuariIdentificadorEmpresaEntity.builder().
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
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
					usuari.get(),
					identificador);
			Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorAndEmpresa(
					usuariIdentificador.get(),
					empresa.get());
			if (usuariIdentificadorEmpresa.isPresent() && !hasAnyPermission(permission)) {
				usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresa.get());
			} else if (!usuariIdentificadorEmpresa.isPresent() && hasAnyPermission(permission)) {
				UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresaPerCrear = UsuariIdentificadorEmpresaEntity.builder().
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
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
					usuari.get(),
					identificador);
			Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorAndEmpresa(
					usuariIdentificador.get(),
					empresa.get());
			if (usuariIdentificadorEmpresa.isPresent()) {
				usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresa.get());
			}
		}
	}

	private boolean hasAnyPermission(BaseBootPermission permission) {
		return permission.isReadGranted();
	}*/

}
