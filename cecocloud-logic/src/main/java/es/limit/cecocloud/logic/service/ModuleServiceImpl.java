/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.module.AbstractModules;
import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.base.boot.logic.api.service.ModuleService;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatRepository;
import es.limit.cecocloud.persist.repository.PerfilRepository;

/**
 * Implementació del servei encarregat de gestionar els mòduls de l'aplicació.
 * 
 * @author Limit Tecnologies
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	// Si es posa a true es veuran tots els mòduls disponibles
	private static final boolean DEV_MODE = true;

	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private FuncionalitatRepository funcionalitatRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Override
	public List<ModuleInfo> findAvailable() {
		return AbstractModules.registeredFindAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModuleInfo> findAllowed() {
		if (DEV_MODE) {
			return findAvailable();
		} else {
			UserSession userSession = (UserSession)authenticationHelper.getSession();
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
					Set<String> moduleCodes = funcionalitats.stream().map(funcionalitat -> funcionalitat.getEmbedded().getModul().name()).collect(Collectors.toSet());
					return registeredModules.stream().filter(module -> moduleCodes.contains(module.getCode())).collect(Collectors.toList());
				}
			}
			return new ArrayList<ModuleInfo>();
		}
	}

}
