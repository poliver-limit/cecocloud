package es.limit.cecocloud.logic.helper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.security.acls.model.Permission;
import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.api.service.ResourcePermissionService;
import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;
import es.limit.cecocloud.persist.entity.RecursEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorPerfilRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatRecursRepository;

@Component
public class FuncionalitatAclHelper {

	@Autowired
	private FuncionalitatRecursRepository funcionalitatRecursRepository;
	@Autowired
	private FuncionalitatIdentificadorRepository funcionalitatIdentificadorRepository;
	@Autowired
	private FuncionalitatIdentificadorPerfilRepository funcionalitatIdentificadorPerfilRepository;
	@Autowired
	private PermissionHelper permissionHelper;
	@Autowired
	private ResourcePermissionService resourcePermissionService;
	@Autowired
	private PermissionFactory permissionFactory;

	
	public void updatePermisosRemoveRecurs(String resourceClassName) {
		permissionHelper.deleteResource(resourceClassName);
	}

	public void updatePermisosFuncionalitatRecurs(
			FuncionalitatEntity funcionalitat,
			List<RecursEntity> resourcesAdded,
			List<RecursEntity> resourcesRemoved) throws ClassNotFoundException {
		List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificador = funcionalitatIdentificadorRepository.findByFuncionalitatOrderByIdentificador(funcionalitat);

		// Actualitzam per a cada identificador
		for (FuncionalitatIdentificadorEntity funcionalitatIdentificador: funcionalitatsIdentificador) {
			//			 List<FuncionalitatIdentificadorPerfilEntity> fucionalitatIdentificadorPerfils = funcionalitatIdentificadorPerfilRepository.findByFuncionalitatIdentificadorOrderByPerfil(funcionalitatIdentificador);
			Set<PerfilEntity> perfils = funcionalitatIdentificadorPerfilRepository
					.findByFuncionalitatIdentificadorOrderByPerfil(funcionalitatIdentificador)
					.stream()
					.map(funcidfPerfil -> funcidfPerfil.getPerfil()).collect(Collectors.toSet());

			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorTotes = null;
			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorAltres = null;
			Long perfilId = null;

			for (PerfilEntity perfil: perfils) {

				// Obtenir totes les funcionalitats del perfil
				funcionalitatsIdentificadorTotes = funcionalitatIdentificadorPerfilRepository
						.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfil.getId())
						.stream()
						.map(funcidfPerf -> funcidfPerf.getFuncionalitatIdentificador()).collect(Collectors.toList());
				// Obtenir la resta de funcionalitats del perfil
				funcionalitatsIdentificadorAltres = funcionalitatIdentificadorPerfilRepository
						.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfil.getId())
						.stream()
						.filter(funcidfPerf -> !funcidfPerf.getFuncionalitatIdentificador().getId().equals(funcionalitatIdentificador.getId()))
						.map(funcidfPerf -> funcidfPerf.getFuncionalitatIdentificador()).collect(Collectors.toList());
				// Obtenir permisos de la funcionalitat
				BaseBootPermission permisosActuals = new BaseBootPermission();
				funcionalitatIdentificadorPerfilRepository.findByPerfilIdAndFuncionalitatIdentificadorId(perfilId, funcionalitatIdentificador.getId())
						.forEach(funcidfPerfil -> permisosActuals.setGranted(permissionFactory.buildFromName(funcidfPerfil.getEmbedded().getPermis()).getMask()));

				
				// Recursos afegits
				for (RecursEntity recurs: resourcesAdded) {
					FuncionalitatRecursEntity funcionalitatRecurs = funcionalitatRecursRepository.findByFuncionalitatAndRecurs(funcionalitat, recurs);
					BaseBootPermission permisRecurs = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfilId);
					if (!funcionalitatsIdentificadorTotes.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsIdentificadorAndRecurs(
								funcionalitatsIdentificadorTotes, 
								recurs.getEmbedded().getClassName()
								).forEach(funcRecurs -> permisRecurs.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
													ExtendedPermission.READ.getMask()));

					if (funcionalitatRecurs.getEmbedded().isPrincipal()) {
						permisRecurs.addPermissions(permisosActuals);
					} else {
						permisRecurs.setGranted(ExtendedPermission.READ.getMask());
					}
					
					resourcePermissionService.savePermission(recurs.getEmbedded().getClassName(), permisRecurs);
				}

				// Recursos eliminats
				for (RecursEntity recurs: resourcesRemoved) {
					FuncionalitatRecursEntity funcionalitatRecurs = funcionalitatRecursRepository.findByFuncionalitatAndRecurs(funcionalitat, recurs);
					BaseBootPermission permisRecurs = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfilId);

					if (!funcionalitatsIdentificadorAltres.isEmpty())
						funcionalitatRecursRepository.findPermisosByFuncionalitatsIdentificadorAndRecurs(
								funcionalitatsIdentificadorAltres, 
								funcionalitatRecurs.getRecursClassName()
								).forEach(funcRecurs -> permisRecurs.setGranted(
										funcRecurs.isPrincipal() ? 
												permissionFactory.buildFromName(funcRecurs.getPermis()).getMask() : 
													ExtendedPermission.READ.getMask()));

					resourcePermissionService.savePermission(funcionalitatRecurs.getRecursClassName(), permisRecurs);
				}

			}
		}
	}

	public void updatePermisosFuncionalitatIdentificadorPerfil(
			Long perfilId, 
			FuncionalitatIdentificadorEntity funcionalitatIdentificador,
			List<Permission> permissionAdded,
			List<Permission> permissionRemoved) throws ClassNotFoundException {

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
			for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatsRecurs) {
				BaseBootPermission permisRecurs = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfilId);

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
			// 2. comprovam si hem d'eliminar els permisos
			for (FuncionalitatRecursEntity funcionalitatRecurs: funcionalitatsRecurs) {
				BaseBootPermission permisRecursActual = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfilId);
				BaseBootPermission permisRecursAltres = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfilId);

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

	public void refreshPermisosPerfil(PerfilEntity perfil) throws ClassNotFoundException {
		
		// 1. Eliminam els permisos del perfil
		permissionHelper.deleteSidEntries("Perfil_" + perfil.getId());
		
		// 2. Assigna permisos per a tots els recursos
		Set<RecursEntity> recursos = funcionalitatRecursRepository.findByPerfil(perfil).stream().map(funcrec -> funcrec.getRecurs()).collect(Collectors.toSet());
		
		for (RecursEntity recurs: recursos) {
			BaseBootPermission permisos = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfil.getId());
			funcionalitatIdentificadorPerfilRepository.findPermisosByRecursAndPerfil(recurs, perfil)
					.forEach(permis -> permisos.setGranted(permissionFactory.buildFromName(permis).getMask()));
			resourcePermissionService.savePermission(recurs.getEmbedded().getClassName(), permisos);
		}
		
//		// Obtenir permisos de la funcionalitat
//		BaseBootPermission permisosActuals = new BaseBootPermission();
//		funcionalitatIdentificadorPerfilRepository.findByPerfilIdAndFuncionalitatIdentificadorId(perfilId, funcionalitatIdentificador.getId())
//				.forEach(funcidfPerfil -> permisosActuals.setGranted(permissionFactory.buildFromName(funcidfPerfil.getEmbedded().getPermis()).getMask()));
		
		
//		// Obtenir totes les funcionalitats del perfil
//		List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificador = funcionalitatIdentificadorPerfilRepository
//				.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfil.getId())
//				.stream()
//				.map(funcidfPerf -> funcidfPerf.getFuncionalitatIdentificador()).collect(Collectors.toList());
//		
//		for (FuncionalitatIdentificadorEntity funcionalitatIdentificador: funcionalitatsIdentificador) {
//			// Obtenir recursos de la funcionalitat
//			List<FuncionalitatRecursEntity> funcionalitatsRecurs = funcionalitatRecursRepository.findByFuncionalitat(funcionalitatIdentificador.getFuncionalitat());
//			// Obtenir permisos de la funcionalitat
//			BaseBootPermission permisosPrincipals = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfil.getId());
//			funcionalitatIdentificadorPerfilRepository.findByPerfilIdAndFuncionalitatIdentificadorId(perfil.getId(), funcionalitatIdentificador.getId())
//					.forEach(funcidfPerfil -> permisosPrincipals.setGranted(permissionFactory.buildFromName(funcidfPerfil.getEmbedded().getPermis()).getMask()));
//			// Obtenir tots els recursos principals
//			List<FuncionalitatRecursEntity> funcionalitatsRecursPrincipal = funcionalitatsRecurs
//					.stream()
//					.filter(funcrec -> funcrec.getEmbedded().isPrincipal()).collect(Collectors.toList());
//			for (FuncionalitatRecursEntity funcionalitatRecursPrincipal: funcionalitatsRecursPrincipal) {
//				resourcePermissionService.savePermission(funcionalitatRecursPrincipal.getRecursClassName(), permisosPrincipals);
//			}
//			// Obtenir tots els recursos auxiliars
//			BaseBootPermission permisosAuxiliars = new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, "Perfil_" + perfil.getId());
//			permisosAuxiliars.setReadGranted(true);
//			List<FuncionalitatRecursEntity> funcionalitatsRecursAuxiliars = funcionalitatsRecurs
//					.stream()
//					.filter(funcrec -> !funcrec.getEmbedded().isPrincipal()).collect(Collectors.toList());
//			for (FuncionalitatRecursEntity funcionalitatRecursPrincipal: funcionalitatsRecursPrincipal) {
//				resourcePermissionService.savePermission(funcionalitatRecursPrincipal.getRecursClassName(), permisosAuxiliars);
//			}
//		}
	}
	
	// TODO: Al eliminar una funcionalitat perfil s'han d'eliminar els seus ACLs
}
