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
import es.limit.cecocloud.logic.api.dto.FuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPerfil;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.FuncionalitatPerfilService;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatPerfilEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatPerfilRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRecursRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRepository;
import es.limit.cecocloud.persist.repository.PerfilRepository;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatPerfilServiceImpl extends AbstractGenericServiceImpl<FuncionalitatPerfil, FuncionalitatPerfilEntity, Long> implements FuncionalitatPerfilService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private FuncionalitatRecursRepository funcionalitatRecursRepository;
	@Autowired
	private FuncionalitatIdentificadorRepository funcionalitatIdentificadorRepository;
	@Autowired
	private FuncionalitatPerfilRepository funcionalitatPerfilRepository;
	@Autowired
	private FuncionalitatRepository funcionalitatRepository;
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
		List<FuncionalitatPerfilEntity> funcionalitatsPerfil = funcionalitatPerfilRepository
				.findByPerfilIdOrderByFuncionalitatEmbeddedDescripcio(perfilId);
		
		return getFuncionalitatPermisosPerModuls(funcionalitatsPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilsOrderByModule(List<Long> perfilsId) {
		
		// Obtenim tots els permisos actuals sobre les funcionalitats dels perfils
		List<FuncionalitatPerfilEntity> funcionalitatsPerfil = funcionalitatPerfilRepository
				.findByPerfilIdInOrderByFuncionalitatEmbeddedDescripcio(perfilsId);
		
		return getFuncionalitatPermisosPerModuls(funcionalitatsPerfil);
	}
	
	private List<ModuleFuncionalitatInfo> getFuncionalitatPermisosPerModuls(List<FuncionalitatPerfilEntity> funcionalitatsPerfil) {
		
		// Obtenim els mòduls
		List<ModuleFuncionalitatInfo> modulsFuncionalitats = new ArrayList<ModuleFuncionalitatInfo>();
		List<ModuleInfo> moduls = AbstractModules.registeredFindAll();
		
		// Obtenimm totes les funcionalitats de l'identificador actual
		UserSession session = (UserSession)authenticationHelper.getSession();
		List<FuncionalitatEntity> funcionalitats = funcionalitatIdentificadorRepository
				.findByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(session.getI())
				.stream().map(funcionalitatIdent -> funcionalitatIdent.getFuncionalitat()).collect(Collectors.toList());
		
		for (ModuleInfo modul: moduls) {
			
			List<FuncionalitatInfo> funcionalitatsInfo = new ArrayList<FuncionalitatInfo>(); 
			List<FuncionalitatEntity> funcionalitatsModul = funcionalitats.stream()
					.filter(func -> func.getEmbedded().getModul().equals(modul.getCode())
							).collect(Collectors.toList());
			
			for (FuncionalitatEntity funcModul: funcionalitatsModul) {
				FuncionalitatInfo funcionalitatInfo =  new  FuncionalitatInfo(
						funcModul.getId(),
						funcModul.getEmbedded().getCodi(),
						funcModul.getEmbedded().getDescripcio(),
						funcModul.getEmbedded().getTipus(),
						new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, ""));
				List<FuncionalitatPerfilEntity> funcionalitatsPerfilModul = funcionalitatsPerfil.stream()
						.filter(func -> func.getFuncionalitat().getId().equals(funcModul.getId())
								).collect(Collectors.toList());
				
				for (FuncionalitatPerfilEntity funcPerfil: funcionalitatsPerfilModul) {
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
		funcionalitatPerfilRepository.findByPerfilIdAndFuncionalitatId(perfilId, funcionalitatInfo.getId())
				.forEach(funcPerfil -> permisosActuals.setGranted(permissionFactory.buildFromName(funcPerfil.getEmbedded().getPermis()).getMask()));
				
		
		// Comparar permisos antics amb nous
		List<Permission> permissionAdded = permisos.getPermissionAdded(permisosActuals);
		List<Permission> permissionRemoved =  permisos.getPermissionRemoved(permisosActuals);

		if (!permissionAdded.isEmpty() || !permissionRemoved.isEmpty()) {
			
			PerfilEntity perfil = perfilRepository.getOne(perfilId);
			FuncionalitatEntity funcionalitat = funcionalitatRepository.getOne(funcionalitatInfo.getId());
			// Obtenir recursos de la funcionalitat
			List<FuncionalitatRecursEntity> funcionalitatsRecurs = funcionalitatRecursRepository.findByFuncionalitat(funcionalitat);
			// Obtenir totes les funcionalitats del perfil
			List<FuncionalitatEntity> funcionalitatsTotes = funcionalitatPerfilRepository
					.findByPerfilIdOrderByFuncionalitatEmbeddedDescripcio(perfilId)
					.stream()
					.map(funcionalitatPerf -> funcionalitatPerf.getFuncionalitat()).collect(Collectors.toList());
			// Obtenir la resta de funcionalitats del perfil
			List<FuncionalitatEntity> funcionalitatsAltres = funcionalitatPerfilRepository
					.findByPerfilIdOrderByFuncionalitatEmbeddedDescripcio(perfilId)
					.stream()
					.filter(funcionalitatPerf -> !funcionalitatPerf.getFuncionalitat().getId().equals(funcionalitat.getId()))
					.map(funcionalitatPerf -> funcionalitatPerf.getFuncionalitat()).collect(Collectors.toList());

			// Afegir permis 
			for(Permission permis : permissionAdded) {
				
				// 1. afegim FuncionalitatPerfilEntity amb el permís
				FuncionalitatPerfil embedded = new FuncionalitatPerfil();
				embedded.setPermis(ExtendedPermission.getName(permis.getMask()));
				FuncionalitatPerfilEntity funcionalitatPerfil = FuncionalitatPerfilEntity.builder()
					.funcionalitat(funcionalitat)
					.perfil(perfil)
					.embedded(embedded).build();
				funcionalitatPerfilRepository.save(funcionalitatPerfil);
				
				// 2. Assignam permisos a recursos
				for (FuncionalitatRecursEntity recurs: funcionalitatsRecurs) {
					BaseBootPermission permisRecurs = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, perfil.getId().toString());
					
					if (!funcionalitatsTotes.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsAndRecurs(
								funcionalitatsTotes, 
								recurs.getEmbedded().getResourceClassName()
								).forEach(funcRecurs -> permisRecurs.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
												ExtendedPermission.READ.getMask()));
					
					permisRecurs.setGranted(recurs.getEmbedded().isPrincipal() ? permis.getMask() : ExtendedPermission.READ.getMask());
					resourcePermissionService.savePermission(recurs.getEmbedded().getResourceClassName(), permisRecurs);
				}
			}
			
			// Eliminar permis
			for(Permission permis : permissionRemoved) {

				// 1. elimina, FuncionalitatPerfilEntity
				FuncionalitatPerfilEntity funcionalitatPerfil = funcionalitatPerfilRepository.findByPerfilAndFuncionalitatAndEmbeddedPermis(
						perfil, 
						funcionalitat,
						ExtendedPermission.getName(permis.getMask()));
				funcionalitatPerfilRepository.delete(funcionalitatPerfil);
				
				// 2. comprovam si hem d'eliminar els permisos
				for (FuncionalitatRecursEntity recurs: funcionalitatsRecurs) {
					BaseBootPermission permisRecursActual = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, perfil.getId().toString());
					BaseBootPermission permisRecursAltres = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, perfil.getId().toString());
					
					if (!funcionalitatsTotes.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsAndRecurs(
								funcionalitatsTotes, 
								recurs.getEmbedded().getResourceClassName()
								).forEach(funcRecurs -> permisRecursActual.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
												ExtendedPermission.READ.getMask()));
					
					if (!funcionalitatsAltres.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsAndRecurs(
								funcionalitatsAltres, 
								recurs.getEmbedded().getResourceClassName()
								).forEach(funcRecurs -> permisRecursAltres.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
												ExtendedPermission.READ.getMask()));
					
					if (recurs.getEmbedded().isPrincipal()) {
						if (!permisRecursAltres.isGranted(permis.getMask()))
							permisRecursActual.setNotGranted(permis.getMask());
					} else {
						if (!permisRecursAltres.isGranted(ExtendedPermission.READ.getMask()))
							permisRecursActual.setNotGranted(ExtendedPermission.READ.getMask());
					}
					resourcePermissionService.savePermission(recurs.getEmbedded().getResourceClassName(), permisRecursActual);
				}
			}
			
		}
		
	}
	
}
