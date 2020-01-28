/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPerfil;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.FuncionalitatPerfilService;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatPerfilEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorRepository;
import es.limit.cecocloud.persist.repository.FuncionalitatPerfilRepository;

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
	private FuncionalitatIdentificadorRepository funcionalitatIdentificadorRepository;
	@Autowired
	private FuncionalitatPerfilRepository funcionalitatPerfilRepository;
	@Autowired
	private PermissionFactory permissionFactory;
	
	@Override
	public List<ModuleFuncionalitatInfo> findAllFuncionalitatsPerfillOrderByModule(Long perfilId) {

		// Obtenim els mòduls
		List<ModuleFuncionalitatInfo> modulsFuncionalitats = new ArrayList<ModuleFuncionalitatInfo>();
		List<ModuleInfo> moduls = AbstractModules.registeredFindAll();
		
		// Obtenimm totes les funcionalitats de l'identificador actual
		UserSession session = (UserSession)authenticationHelper.getSession();
		List<FuncionalitatEntity> funcionalitats = funcionalitatIdentificadorRepository
				.findFuncionalitatByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(session.getI());
		
		// Obtenim tots els permisos actuals sobre les funcionalitats del perfil
		List<FuncionalitatPerfilEntity> funcionalitatsPerfil = funcionalitatPerfilRepository
				.findByPerfilIdOrderByFuncionalitatEmbeddedDescripcio(perfilId);
		
		for (ModuleInfo modul: moduls) {
			
			List<FuncionalitatInfo> funcionalitatsInfo = new ArrayList<FuncionalitatInfo>(); 
			List<FuncionalitatEntity> funcionalitatsModul = funcionalitats.stream()
					.filter(func -> func.getEmbedded().getModul().equals(modul.getCode())
							).collect(Collectors.toList());
			
			for (FuncionalitatEntity funcModul: funcionalitatsModul) {
				FuncionalitatInfo funcionalitatInfo =  new  FuncionalitatInfo(
						funcModul.getEmbedded().getCodi(),
						funcModul.getEmbedded().getDescripcio(),
						new BaseBootPermission());
				
				List<FuncionalitatPerfilEntity> funcionalitatsPerfilModul = funcionalitatsPerfil.stream()
						.filter(func -> func.getFuncionalitat().equals(funcModul)
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
	
}
