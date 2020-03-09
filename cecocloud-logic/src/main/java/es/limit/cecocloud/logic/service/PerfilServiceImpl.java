/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.security.acls.model.Permission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.api.exception.PermissionNotAllowedException;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermis;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermisModule;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.PerfilService;
import es.limit.cecocloud.logic.helper.FuncionalitatAclHelper;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorPerfilRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorRepository;
import es.limit.cecocloud.persist.repository.PerfilRepository;

/**
 * Implementació del servei encarregat de gestionar perfils.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PerfilServiceImpl extends AbstractGenericServiceImpl<Perfil, PerfilEntity, Long> implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private FuncionalitatIdentificadorPerfilRepository funcionalitatIdentificadorPerfilRepository;
	@Autowired
	private FuncionalitatIdentificadorRepository funcionalitatIdentificadorRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private FuncionalitatAclHelper funcionalitatAclHelper;
	@Autowired
	private PermissionFactory permissionFactory;

	@Override
	@Transactional(readOnly = true)
	public List<FuncionalitatPermisModule> funcionalitatPermisFindOrderedByModul(
			Long id,
			Long[] idsAddicionals) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(id);
		if (idsAddicionals != null) {
			ids.addAll(Arrays.asList(idsAddicionals));
		}
		List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils = funcionalitatIdentificadorPerfilRepository.findByPerfilIdInOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(ids);
		return getFuncionalitatPermisosPerModuls(funcionalitatIdentificadorPerfils);
	}

	@Override
	@Transactional
	public void funcionalitatPermisSave(
			Long id,
			FuncionalitatPermis funcionalitatPermis) throws ClassNotFoundException {
		FuncionalitatIdentificadorEntity funcionalitatIdentificador = funcionalitatIdentificadorRepository.getOne(funcionalitatPermis.getFuncionalitatIdentificadorId());
		FuncionalitatEntity funcionalitat = funcionalitatIdentificador.getFuncionalitat();
		Optional<es.limit.base.boot.logic.api.module.ModuleInfo> opModul = Modules.registeredGetOne(funcionalitat.getEmbedded().getModul().name());
		if (opModul.isPresent()) {
			ModuleInfo moduleInfo = (ModuleInfo)opModul.get();
			FuncionalitatCodiFont funcionalitatCodi = moduleInfo.getFuncionalitats().get(funcionalitat.getEmbedded().getCodi());
			if (funcionalitatCodi != null) {
				BaseBootPermission permisos = funcionalitatPermis.getPermission();
				// Obtenim els permisos actuals
				BaseBootPermission permisosActuals = new BaseBootPermission();
				funcionalitatIdentificadorPerfilRepository.findByPerfilIdAndFuncionalitatIdentificadorId(id, funcionalitatPermis.getFuncionalitatIdentificadorId())
						.forEach(funcidfPerfil -> permisosActuals.setGranted(permissionFactory.buildFromName(funcidfPerfil.getEmbedded().getPermis()).getMask()));
				// Comparar permisos antics amb nous
				List<Permission> permissionAdded = permisos.getPermissionAdded(permisosActuals);
				List<Permission> permissionRemoved =  permisos.getPermissionRemoved(permisosActuals);
				if (!permissionAdded.isEmpty() || !permissionRemoved.isEmpty()) {
					PerfilEntity perfil = perfilRepository.getOne(id);
					// Afegir permis 
					for(Permission permis : permissionAdded) {
						// Comprovam que el permis es pugui assignar
						if (funcionalitatCodi.getAllowedPermission().contains(permis)) {
							FuncionalitatIdentificadorPerfil embedded = new FuncionalitatIdentificadorPerfil();
							embedded.setPermis(ExtendedPermission.getName(permis.getMask()));
							FuncionalitatIdentificadorPerfilEntity funcionalitatIdentificadorPerfil = FuncionalitatIdentificadorPerfilEntity.builder()
								.funcionalitatIdentificador(funcionalitatIdentificador)
								.perfil(perfil)
								.embedded(embedded).build();
							funcionalitatIdentificadorPerfilRepository.save(funcionalitatIdentificadorPerfil);
						} else {
							throw new PermissionNotAllowedException();
						}
					}
					// Eliminar permis
					for (Permission permis: permissionRemoved) {
						// 1. elimina, FuncionalitatPerfilEntity
						FuncionalitatIdentificadorPerfilEntity funcionalitatIdentificadorPerfil = funcionalitatIdentificadorPerfilRepository.findByPerfilAndFuncionalitatIdentificadorAndEmbeddedPermis(
								perfil, 
								funcionalitatIdentificador,
								ExtendedPermission.getName(permis.getMask()));
						funcionalitatIdentificadorPerfilRepository.delete(funcionalitatIdentificadorPerfil);
					}
					funcionalitatAclHelper.refreshPermisosPerfil(id);
				}
			}
		}
	}

	@Override
	@Transactional
	public void funcionalitatPermisRefresh(Long id) throws ClassNotFoundException {
		funcionalitatAclHelper.refreshPermisosPerfil(id);
	}

	private List<FuncionalitatPermisModule> getFuncionalitatPermisosPerModuls(List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils) {
		List<FuncionalitatPermisModule> modulsFuncionalitats = new ArrayList<FuncionalitatPermisModule>();
		@SuppressWarnings("unchecked")
		List<ModuleInfo> moduls = (List<ModuleInfo>)(List<?>)Modules.registeredFindAll();
		UserSession session = (UserSession)authenticationHelper.getSession();
		List<FuncionalitatIdentificadorEntity> funcionalitatIdentificadors = funcionalitatIdentificadorRepository.findByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(session.getI());
		for (ModuleInfo modul: moduls) {
			List<FuncionalitatPermis> funcionalitatsInfo = new ArrayList<FuncionalitatPermis>(); 
			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorModul = funcionalitatIdentificadors.stream().
					filter(funcidf -> funcidf.getFuncionalitat().getEmbedded().getModul().equals(Modul.valueOf(modul.getCode()))).
					collect(Collectors.toList());
			Map<String, FuncionalitatCodiFont> funcionalitatsCodi = modul.getFuncionalitats();
			for (FuncionalitatIdentificadorEntity funcidfModul: funcionalitatsIdentificadorModul) {
				FuncionalitatPermis funcionalitatInfo =  new  FuncionalitatPermis(
						funcidfModul.getId(),
						funcidfModul.getFuncionalitat().getEmbedded().getCodi(),
						funcidfModul.getFuncionalitat().getEmbedded().getDescripcio(),
						modul.getCode(),
						funcidfModul.getFuncionalitat().getEmbedded().getTipus(),
						new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, ""),
						new BaseBootPermission(PermissionSidType.GRANTED_AUTHORITY, ""));
				List<FuncionalitatIdentificadorPerfilEntity> funcionalitatsIdentificadorPerfilModul = funcionalitatIdentificadorPerfils.stream()
						.filter(funcidf -> funcidf.getFuncionalitatIdentificador().getId().equals(funcidfModul.getId())
								).collect(Collectors.toList());
				funcionalitatsIdentificadorPerfilModul.forEach(funcPerfil -> funcionalitatInfo.getPermission().setGranted(
							permissionFactory.buildFromName(funcPerfil.getEmbedded().getPermis()).getMask())
				);
				FuncionalitatCodiFont funcionalitatCodi = funcionalitatsCodi.get(funcionalitatInfo.getCodi());
				if (funcionalitatCodi != null) {
					funcionalitatCodi.getAllowedPermission().forEach(permis -> funcionalitatInfo.getAllowedPermission().setGranted(permis.getMask()));
				}
				funcionalitatsInfo.add(funcionalitatInfo);
			}
			if (!funcionalitatsInfo.isEmpty()) {
				modulsFuncionalitats.add(new FuncionalitatPermisModule(modul, funcionalitatsInfo));
			}
		}
		return modulsFuncionalitats;
	}

}
