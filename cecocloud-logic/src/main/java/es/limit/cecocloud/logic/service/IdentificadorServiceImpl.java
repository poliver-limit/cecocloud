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
import es.limit.base.boot.logic.api.exception.GenericException;
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
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei de gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class IdentificadorServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Identificador, IdentificadorEntity, Long> implements IdentificadorService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;
	

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
	protected void beforeCreate(IdentificadorEntity entity, Identificador dto) {
		super.beforeCreate(entity, dto);
		generateLicense(dto);
	}
	
	@Override
	protected void beforeUpdate(IdentificadorEntity entity, Identificador dto) throws GenericException {
		super.beforeUpdate(entity, dto);
		generateLicense(dto);
	}
	
	
	
	@Override
	protected void beforeDelete(IdentificadorEntity entity) throws GenericException {
		super.beforeDelete(entity);
		// Eliminar permisos
		List<BaseBootPermission> permisos = permissionFind(entity.getId());
		for (BaseBootPermission permis: permisos) {
			permissionDelete(entity.getId(), permis.getId());
		}
		// Eliminar UsuariIdentificador
		List<UsuariIdentificadorEntity> usuariIdfs = usuariIdentificadorRepository.findByIdentificadorId(entity.getId());
		for(UsuariIdentificadorEntity usuariIdf: usuariIdfs) {
			usuariIdentificadorRepository.delete(usuariIdf);
		}
	}

	private void generateLicense(Identificador dto) {
		// General la llicència
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
			log.error("Error al generar la llicència", e);
			throw new GenericException("Error generating the license.", e);
		}
	}
	
	@Override
	protected void afterCreate(IdentificadorEntity entity, Identificador dto) {
		super.afterCreate(entity, dto);
		
		// Assignar permisos al propietari
		BaseBootPermission permission = new BaseBootPermission(
				PermissionSidType.PRINCIPAL,
				entity.getPropietari().getEmbedded().getCodi());
		permission.setAdminGranted(true);
		permission.setAccessGranted(true);
		permission.setSyncGranted(true);
		permissionCreate(entity.getId(), permission);
	}
	
	@Override
	protected void afterUpdate(IdentificadorEntity entity, Identificador dto) {
		super.afterUpdate(entity, dto);
		
		// Assignar permisos al propietari
		BaseBootPermission permission = new BaseBootPermission(
				PermissionSidType.PRINCIPAL,
				entity.getPropietari().getEmbedded().getCodi());
		permission.setAdminGranted(true);
		permission.setAccessGranted(true);
		permission.setSyncGranted(true);
		permissionCreate(entity.getId(), permission);
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
