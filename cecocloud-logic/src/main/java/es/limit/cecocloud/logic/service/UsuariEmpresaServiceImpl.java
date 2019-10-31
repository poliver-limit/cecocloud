/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.service.UsuariEmpresaService;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.repository.UsuariEmpresaRepository;

/**
 * Implementació del servei de gestió d'usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariEmpresaServiceImpl extends AbstractGenericServiceImpl<UsuariEmpresa, UsuariEmpresaEntity, Long> implements UsuariEmpresaService {

	@Autowired
	private UsuariEmpresaRepository usuariEmpresaRepository;
	
	@Autowired
	private PermissionHelper permisosHelper;

	@Override
	public List<String> findMenusPermesos(String modulActiu) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<String> rolNames = auth.getAuthorities().stream().map(rol -> String.valueOf(rol.getAuthority())).collect(Collectors.toList());
		
		List<String> recursosDisponibles = null;
		
		// TODO: CACHE!!
		if (modulActiu != null && !modulActiu.isEmpty()) {
			recursosDisponibles = new ArrayList<String> (permisosHelper.findResourcesWithPermissionAndPrefix(
					"", //ue.getId(), 
					rolNames,
					modulActiu,
					ExtendedPermission.READ));
		} else {
			recursosDisponibles = new ArrayList<String> (permisosHelper.findResourcesWithPermission(
					"", //ue.getId(), 
					rolNames,
					ExtendedPermission.READ));
		}
		
		return recursosDisponibles;
	}
	

	@Transactional
	@Override
	public List<UsuariEmpresa> findByUsuariCodi(
			String usuariCodi,
			String identificadorCodi) {
		return toDto(usuariEmpresaRepository.findByUsuariCodiAndIdentificadorCodi(
					usuariCodi,
					identificadorCodi));
	}

	@Override
	public UsuariEmpresa findByUsuariCodiAndEmpresa(
			String usuariCodi, 
			Long empresaCodi) {
		return toDto(usuariEmpresaRepository.getByUsuariEmbeddedCodiAndEmpresaEmbeddedCodi(
					usuariCodi, 
					empresaCodi));
	}

}
