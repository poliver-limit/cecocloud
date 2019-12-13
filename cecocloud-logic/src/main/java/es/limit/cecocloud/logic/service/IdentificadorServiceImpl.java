/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceWithPermissionsImpl;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.acl.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorEmpresaRepository;
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
	@Autowired
	private UsuariIdentificadorEmpresaRepository usuariIdentificadorEmpresaRepository;
	@Autowired
	private PermissionHelper permissionHelper;

	@Override
	protected void afterPermissionCreate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType() && hasAnyPermission(permission)) {
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
	protected void afterPermissionUpdate(Long id, BaseBootPermission permission) {
		if (PermissionSidType.PRINCIPAL == permission.getSidType()) {
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(permission.getSidName());
			Optional<IdentificadorEntity> identificador = getRepository().findById(id);
			UsuariIdentificadorPk usuariIdentificadorPk = new UsuariIdentificadorPk(
					usuari.get().getId(),
					identificador.get().getId());
			Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findById(usuariIdentificadorPk);
			if (usuariIdentificador.isPresent() && !hasAnyPermission(permission)) {
				usuariIdentificadorRepository.delete(usuariIdentificador.get());
			} else if (!usuariIdentificador.isPresent() && hasAnyPermission(permission)) {
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
	public List<IdentificadorEmpresaSelectionTreeItem> buildSelectionTree() {
		List<IdentificadorEmpresaSelectionTreeItem> selectionTree = new ArrayList<IdentificadorEmpresaSelectionTreeItem>();
		String usuariCodi = SecurityContextHolder.getContext().getAuthentication().getName();
		List<UsuariIdentificadorEntity> usuariIdentificadors = usuariIdentificadorRepository.findByUsuariEmbeddedCodiOrderByIdentificadorEmbeddedDescripcio(usuariCodi);
		for (UsuariIdentificadorEntity usuariIdentificador: usuariIdentificadors) {
			IdentificadorEntity identificador = usuariIdentificador.getIdentificador();
			boolean hasAdminPermission = permissionHelper.checkPermissionForCurrentUser(
					Identificador.class,
					identificador.getId(),
					ExtendedPermission.ADMINISTRATION);
			List<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpreses = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorUsuariEmbeddedCodiAndEmpresaIdentificadorIdOrderByEmpresaEmbeddedNom(
					usuariCodi,
					identificador.getId());
			List<Empresa> empreses = toDto(
					usuariIdentificadorEmpreses.stream().map(usuariIdentificadorEmpresa -> usuariIdentificadorEmpresa.getEmpresa()).collect(Collectors.toList()),
					Empresa.class);
			if (hasAdminPermission || !empreses.isEmpty()) {
				IdentificadorEmpresaSelectionTreeItem dto = toDto(identificador, IdentificadorEmpresaSelectionTreeItem.class);
				dto.setDescription(identificador.getEmbedded().getDescripcio());
				dto.setHasAdminPermission(hasAdminPermission);
				dto.setEmpreses(empreses);
				selectionTree.add(dto);
			}
		}
		return selectionTree;
	}

	/*@Override
	protected void beforeCreate(IdentificadorEntity entity, Identificador dto) {
		BaseBootAuthenticationToken auth = (BaseBootAuthenticationToken)authenticationFacade.getAuthentication();
		UserSession session = (UserSession)auth.getSession();
		CompanyiaEntity companyia = companyiaRepository.getOne(session.getC());
		entity.updateCompanyia(companyia);
		String codi;
		boolean exist = false;
		do {
			codi = generateCode();
			Optional<IdentificadorEntity> idf = identificadorRepository.findById(codi);
			exist = idf.isPresent();
		} while (exist);
		entity.setCodi(codi);
	}
	
	private String generateCode() {
		ReturningWork<Long> codeReturningWork = new ReturningWork<Long>() {
			@Override
			public Long execute(Connection connection) throws SQLException {
				DialectResolver dialectResolver = new StandardDialectResolver();
				Dialect dialect =  dialectResolver.resolveDialect(
						new DatabaseMetaDataDialectResolutionInfoAdapter(connection.getMetaData()));
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				try {
				    preparedStatement = connection.prepareStatement( dialect.getSequenceNextValString("identificador_sequence"));
				    resultSet = preparedStatement.executeQuery();
				    resultSet.next();
				    return resultSet.getLong(1);
				} catch (SQLException e) {
			    	throw e;
				} finally {
				    if(preparedStatement != null) {
			        	preparedStatement.close();
				    }
				    if(resultSet != null) {
			        	resultSet.close();
				    }
				}
			}
		};
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Long longCode = session.doReturningWork(codeReturningWork);
		session.close();
		return StringUtils.leftPad(Long.toString(longCode, 36).toUpperCase(), 4, "0");
	}*/

	private boolean hasAnyPermission(BaseBootPermission permission) {
		return permission.isReadGranted() || permission.isAdminGranted();
	}

}
