/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import es.limit.cecocloud.logic.api.service.FuncionalitatIdentificadorPerfilService;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatPerfilServiceImpl extends AbstractGenericServiceImpl<FuncionalitatIdentificadorPerfil, FuncionalitatIdentificadorPerfilEntity, Long> implements FuncionalitatIdentificadorPerfilService {

	/*@Autowired
	private FuncionalitatIdentificadorRepository funcionalitatIdentificadorRepository;
	@Autowired
	private FuncionalitatIdentificadorPerfilRepository funcionalitatIdentificadorPerfilRepository;
//	@Autowired
//	private FuncionalitatRepository funcionalitatRepository;
	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private PerfilUsuariIdentificadorEmpresaRepository perfilUsuariIdentificadorEmpresaRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private FuncionalitatAclHelper funcionalitatAclHelper;
	@Autowired
	private PermissionFactory permissionFactory;
	
	
	// Obtenció de informació de funcionalitats
	// ____________________________________________________________________________________________________________
	@Override
	@Transactional(readOnly = true)
	public List<FuncionalitatPermisModule> findAllFuncionalitatsByPerfilOrderByModule(Long perfilId) {

		// Obtenim tots els permisos actuals sobre les funcionalitats del perfil
		List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils = funcionalitatIdentificadorPerfilRepository
				.findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfilId);
		
		return getFuncionalitatPermisosPerModuls(funcionalitatIdentificadorPerfils);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FuncionalitatPermisModule> findAllFuncionalitatsByPerfilsOrderByModule(List<Long> perfilsId) {
		
		// Obtenim tots els permisos actuals sobre les funcionalitats dels perfils
		List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils = funcionalitatIdentificadorPerfilRepository
				.findByPerfilIdInOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(perfilsId);
		
		return getFuncionalitatPermisosPerModuls(funcionalitatIdentificadorPerfils);
	}
	
	private List<FuncionalitatPermisModule> getFuncionalitatPermisosPerModuls(List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils) {
		
		// Obtenim els mòduls
		List<FuncionalitatPermisModule> modulsFuncionalitats = new ArrayList<FuncionalitatPermisModule>();
		@SuppressWarnings("unchecked")
		List<ModuleInfo> moduls = (List<ModuleInfo>)(List<?>)Modules.registeredFindAll();
		
		// Obtenimm totes les funcionalitats de l'identificador actual
		UserSession session = (UserSession)authenticationHelper.getSession();
		List<FuncionalitatIdentificadorEntity> funcionalitatIdentificadors = funcionalitatIdentificadorRepository
				.findByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(session.getI());
//				.stream().map(funcionalitatIdent -> funcionalitatIdent.getFuncionalitat()).collect(Collectors.toList());
		
		for (ModuleInfo modul: moduls) {
			
			List<FuncionalitatPermis> funcionalitatsInfo = new ArrayList<FuncionalitatPermis>(); 
			List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificadorModul = funcionalitatIdentificadors.stream()
					.filter(funcidf -> funcidf.getFuncionalitat().getEmbedded().getModul().equals(Modul.valueOf(modul.getCode()))
							).collect(Collectors.toList());
			
			Map<String, FuncionalitatCodiFont> funcionalitatsCodi = modul.getFuncionalitats();
			
			for (FuncionalitatIdentificadorEntity funcidfModul: funcionalitatsIdentificadorModul) {
				FuncionalitatPermis funcionalitatInfo =  new  FuncionalitatPermis(
						funcidfModul.getId(),
						funcidfModul.getFuncionalitat().getEmbedded().getCodi(),
						funcidfModul.getFuncionalitat().getEmbedded().getDescripcio(),
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
			
			if (!funcionalitatsInfo.isEmpty())
				modulsFuncionalitats.add(new FuncionalitatPermisModule(modul, funcionalitatsInfo));
		}
		return modulsFuncionalitats;
	}

	@Override
	@Transactional
	public List<String> findAllowedFuncionalitatsByModul(Modul modul) {
		
		UserSession session = (UserSession)authenticationHelper.getSession();
		Long identificadorId = session.getI();
		Long empresaId = session.getE();
		String usuariCodi = authenticationHelper.getPrincipalName();
		
		List<PerfilEntity> perfils = perfilUsuariIdentificadorEmpresaRepository.findPerfilsByUsuariCodiAndIdentificadorIdAndEmpresaId(
				usuariCodi, 
				identificadorId, 
				empresaId);
		List<FuncionalitatEntity> funcionalitats = funcionalitatIdentificadorPerfilRepository.findAllowedFuncionalitatsByPerfilsAndModul(perfils, modul);
		
		return funcionalitats.stream().map(funcionalitat -> funcionalitat.getEmbedded().getCodi()).collect(Collectors.toList());
	}
	
	
	// Assignació de permisos a funcionalitats
	// ____________________________________________________________________________________________________________
	
	@Override
	@Transactional
	public void savePermisos(Long perfilId, FuncionalitatPermis funcionalitatInfo, String modulCodi) throws Exception {
		Optional<es.limit.base.boot.logic.api.module.ModuleInfo> opModul = Modules.registeredGetOne(modulCodi);
		if (opModul.isPresent()) {
			ModuleInfo modul = (ModuleInfo)opModul.get();
			FuncionalitatCodiFont funcionalitatCodi = modul.getFuncionalitats().get(funcionalitatInfo.getCodi());
			if (funcionalitatCodi != null) {
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
					for(Permission permis : permissionRemoved) {
						// 1. elimina, FuncionalitatPerfilEntity
						FuncionalitatIdentificadorPerfilEntity funcionalitatIdentificadorPerfil = funcionalitatIdentificadorPerfilRepository.findByPerfilAndFuncionalitatIdentificadorAndEmbeddedPermis(
								perfil, 
								funcionalitatIdentificador,
								ExtendedPermission.getName(permis.getMask()));
						funcionalitatIdentificadorPerfilRepository.delete(funcionalitatIdentificadorPerfil);
					}
					
					funcionalitatAclHelper.refreshPermisosPerfil(perfilId);
				}
			}
		}
		
	}

	@Override
	@Transactional
	public void refreshPermisos(Long perfilId) throws Exception {
		funcionalitatAclHelper.refreshPermisosPerfil(perfilId);
	}*/

}
