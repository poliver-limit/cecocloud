/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.base.boot.logic.api.service.ModuleService;

/**
 * Implementació del servei encarregat de gestionar els mòduls de l'aplicació.
 * 
 * @author Limit Tecnologies
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	/*@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private FuncionalitatRepository funcionalitatRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;*/

	@Override
	public List<ModuleInfo> findAvailable() {
		return AbstractModules.registeredFindAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModuleInfo> findAllowed() {
		return AbstractModules.registeredFindAll();
		/*UserSession userSession = (UserSession)authenticationHelper.getSession();
		if (userSession != null) {
			List<ModuleInfo> registeredModules = AbstractModules.registeredFindAll();
			Long identificadorId = (Long)userSession.getI();
			Long empresaId = (Long)userSession.getE();
			if (identificadorId != null && empresaId != null) {
				List<FuncionalitatEntity> funcionalitats = funcionalitatRepository.findByPerfilIn(
						perfilRepository.findByUsuariCodiAndIdentificadorIdAndEmpresaId(
								authenticationHelper.getPrincipalName(),
								identificadorId,
								empresaId));
				Set<String> moduleCodes = funcionalitats.stream().map(funcionalitat -> funcionalitat.getEmbedded().getModul()).collect(Collectors.toSet());
				return registeredModules.stream().filter(module -> moduleCodes.contains(module.getCode())).collect(Collectors.toList());
			}
		}
		return new ArrayList<ModuleInfo>();*/
	}

}
