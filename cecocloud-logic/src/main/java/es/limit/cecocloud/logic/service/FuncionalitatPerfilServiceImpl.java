/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.security.acls.model.Permission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.api.service.ResourcePermissionService;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import es.limit.cecocloud.logic.api.dto.FuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.service.FuncionalitatPerfilService;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorPerfilRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRecursRepository;
import es.limit.cecocloud.persist.repository.PerfilRepository;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatPerfilServiceImpl extends AbstractGenericServiceImpl<FuncionalitatIdentificadorPerfil, FuncionalitatIdentificadorPerfilEntity, Long> implements FuncionalitatPerfilService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private FuncionalitatRecursRepository funcionalitatRecursRepository;
	@Autowired
	private FuncionalitatIdentificadorRepository funcionalitatIdentificadorRepository;
	@Autowired
	private FuncionalitatIdentificadorPerfilRepository funcionalitatIdentificadorPerfilRepository;
//	@Autowired
//	private FuncionalitatRepository funcionalitatRepository;
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private ResourcePermissionService resourcePermissionService;
	
	@Autowired
	private PermissionFactory permissionFactory;
	
	
	// Obtenció de informació de funcionalitats
	// ____________________________________________________________________________________________________________
	@Override
	@Transactional(readOnly = true)
	public List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilOrderByModule(Long perfilId) {

		// Obtenim tots els permisos actuals sobre les funcionalitats del perfil
		List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils = funcionalitatIdentificadorPerfilRepository
				.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfilId);
		
		return getFuncionalitatPermisosPerModuls(funcionalitatIdentificadorPerfils);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilsOrderByModule(List<Long> perfilsId) {
		
		// Obtenim tots els permisos actuals sobre les funcionalitats dels perfils
		List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils = funcionalitatIdentificadorPerfilRepository
				.findByPerfilIdInOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfilsId);
		
		return getFuncionalitatPermisosPerModuls(funcionalitatIdentificadorPerfils);
	}
	
	private List<ModuleFuncionalitatInfo> getFuncionalitatPermisosPerModuls(List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils) {
		
		// Obtenim els mòduls
		List<ModuleFuncionalitatInfo> modulsFuncionalitats = new ArrayList<ModuleFuncionalitatInfo>();
		List<ModuleInfo> moduls = AbstractModules.registeredFindAll();
		
		// Obtenimm totes les funcionalitats de l'identificador actual
		UserSession session = (UserSession)authenticationHelper.getSession();
		List<FuncionalitatIdentificadorEntity> funcionalitatIdentificadors = funcionalitatIdentificadorRepository
				.findByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(session.getI());
//				.stream().map(funcionalitatIdent -> funcionalitatIdent.getFuncionalitat()).collect(Collectors.toList());
		
		for (ModuleInfo modul: moduls) {
			
			List<FuncionalitatInfo> funcionalitatsInfo = new ArrayList<FuncionalitatInfo>(); 
			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorModul = funcionalitatIdentificadors.stream()
					.filter(funcidf -> funcidf.getFuncionalitat().getEmbedded().getModul().equals(Modul.valueOf(modul.getCode()))
							).collect(Collectors.toList());
			
			for (FuncionalitatIdentificadorEntity funcidfModul: funcionalitatsIdentificadorModul) {
				FuncionalitatInfo funcionalitatInfo =  new  FuncionalitatInfo(
						funcidfModul.getId(),
						funcidfModul.getFuncionalitat().getEmbedded().getCodi(),
						funcidfModul.getFuncionalitat().getEmbedded().getDescripcio(),
						funcidfModul.getFuncionalitat().getEmbedded().getTipus(),
						new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, ""));
				List<FuncionalitatIdentificadorPerfilEntity> funcionalitatsIdentificadorPerfilModul = funcionalitatIdentificadorPerfils.stream()
						.filter(funcidf -> funcidf.getFuncionalitatIdentificador().getId().equals(funcidfModul.getId())
								).collect(Collectors.toList());
				
				for (FuncionalitatIdentificadorPerfilEntity funcPerfil: funcionalitatsIdentificadorPerfilModul) {
					funcionalitatInfo.getPermission().setGranted(
							permissionFactory.buildFromName(funcPerfil.getEmbedded().getPermis()).getMask());
				}
				funcionalitatsInfo.add(funcionalitatInfo);
			}
			
			modulsFuncionalitats.add(new ModuleFuncionalitatInfo(modul, funcionalitatsInfo));
		}
		return modulsFuncionalitats;
	}

	
	// Assignació de permisos a funcionalitats
	// ____________________________________________________________________________________________________________
	
	@Override
	@Transactional
	public void savePermisos(Long perfilId, FuncionalitatInfo funcionalitatInfo) throws Exception {
		BaseBootPermission permisos = funcionalitatInfo.getPermission();
		
		// Obtenim els permisos actuals
		BaseBootPermission permisosActuals = new BaseBootPermission();
		funcionalitatIdentificadorPerfilRepository.findByPerfilIdAndFuncionalitatIdentificadorId(perfilId, funcionalitatInfo.getId())
				.forEach(funcidfPerfil -> permisosActuals.setGranted(permissionFactory.buildFromName(funcidfPerfil.getEmbedded().getPermis()).getMask()));
				
		
		// Comparar permisos antics amb nous
		List<Permission> permissionAdded = permisos.getPermissionAdded(permisosActuals);
		List<Permission> permissionRemoved =  permisos.getPermissionRemoved(permisosActuals);

		if (!permissionAdded.isEmpty() || !permissionRemoved.isEmpty()) {
			
			PerfilEntity perfil = perfilRepository.getOne(perfilId);
			FuncionalitatIdentificadorEntity funcionalitatIdentificador = funcionalitatIdentificadorRepository.getOne(funcionalitatInfo.getId());
			// Obtenir recursos de la funcionalitat
			List<FuncionalitatRecursEntity> funcionalitatsRecurs = funcionalitatRecursRepository.findByFuncionalitat(funcionalitatIdentificador.getFuncionalitat());
			// Obtenir totes les funcionalitats del perfil
			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorTotes = funcionalitatIdentificadorPerfilRepository
					.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfilId)
					.stream()
					.map(funcidfPerf -> funcidfPerf.getFuncionalitatIdentificador()).collect(Collectors.toList());
			// Obtenir la resta de funcionalitats del perfil
			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorAltres = funcionalitatIdentificadorPerfilRepository
					.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfilId)
					.stream()
					.filter(funcidfPerf -> !funcidfPerf.getFuncionalitatIdentificador().getId().equals(funcionalitatIdentificador.getId()))
					.map(funcidfPerf -> funcidfPerf.getFuncionalitatIdentificador()).collect(Collectors.toList());
	
			// Afegir permis 
			for(Permission permis : permissionAdded) {
				
				// 1. afegim FuncionalitatIdentificadorPerfilEntity amb el permís
				FuncionalitatIdentificadorPerfil embedded = new FuncionalitatIdentificadorPerfil();
				embedded.setPermis(ExtendedPermission.getName(permis.getMask()));
				FuncionalitatIdentificadorPerfilEntity funcionalitatIdentificadorPerfil = FuncionalitatIdentificadorPerfilEntity.builder()
					.funcionalitatIdentificador(funcionalitatIdentificador)
					.perfil(perfil)
					.embedded(embedded).build();
				funcionalitatIdentificadorPerfilRepository.save(funcionalitatIdentificadorPerfil);
				
				// 2. Assignam permisos a recursos
				for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatsRecurs) {
					BaseBootPermission permisRecurs = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, perfil.getId().toString());
					
					if (!funcionalitatsIdentificadorTotes.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsIdentificadorAndRecurs(
								funcionalitatsIdentificadorTotes, 
								funcionalitatRecurs.getRecursClassName()
								).forEach(funcRecurs -> permisRecurs.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
												ExtendedPermission.READ.getMask()));
					
					permisRecurs.setGranted(funcionalitatRecurs.getEmbedded().isPrincipal() ? permis.getMask() : ExtendedPermission.READ.getMask());
					resourcePermissionService.savePermission(funcionalitatRecurs.getRecursClassName(), permisRecurs);
				}
			}
			
			// Eliminar permis
			for(Permission permis : permissionRemoved) {

				// 1. elimina, FuncionalitatPerfilEntity
				FuncionalitatIdentificadorPerfilEntity funcionalitatIdentificadorPerfil = funcionalitatIdentificadorPerfilRepository.findByPerfilAndFuncionalitatIdentificadorAndEmbeddedPermis(
						perfil, 
						funcionalitatIdentificador,
						ExtendedPermission.getName(permis.getMask()));
				funcionalitatIdentificadorPerfilRepository.delete(funcionalitatIdentificadorPerfil);
				
				// 2. comprovam si hem d'eliminar els permisos
				for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatsRecurs) {
					BaseBootPermission permisRecursActual = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, perfil.getId().toString());
					BaseBootPermission permisRecursAltres = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, perfil.getId().toString());
					
					if (!funcionalitatsIdentificadorTotes.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsIdentificadorAndRecurs(
								funcionalitatsIdentificadorTotes, 
								funcionalitatRecurs.getRecursClassName()
								).forEach(funcRecurs -> permisRecursActual.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
												ExtendedPermission.READ.getMask()));
					
					if (!funcionalitatsIdentificadorAltres.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsIdentificadorAndRecurs(
								funcionalitatsIdentificadorAltres, 
								funcionalitatRecurs.getRecursClassName()
								).forEach(funcRecurs -> permisRecursAltres.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
												ExtendedPermission.READ.getMask()));
					
					if (funcionalitatRecurs.getEmbedded().isPrincipal()) {
						if (!permisRecursAltres.isGranted(permis.getMask()))
							permisRecursActual.setNotGranted(permis.getMask());
					} else {
						if (!permisRecursAltres.isGranted(ExtendedPermission.READ.getMask()))
							permisRecursActual.setNotGranted(ExtendedPermission.READ.getMask());
					}
					resourcePermissionService.savePermission(funcionalitatRecurs.getRecursClassName(), permisRecursActual);
				}
			}
			
		}
		
	}
	
}
