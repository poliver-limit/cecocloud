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

import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.cecocloud.logic.api.service.MenuService;

/**
 * Implementació del servei encarregat de gestionar companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired private PermissionHelper permissionHelper;
	
	@Override
	public List<String> findMenusPermesos(String modulActiu) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<String> rolNames = auth.getAuthorities().stream().map(rol -> String.valueOf(rol.getAuthority())).collect(Collectors.toList());
		List<String> recursosDisponibles = null;
		// TODO: CACHE!!
		if (modulActiu != null && !modulActiu.isEmpty()) {
			recursosDisponibles = new ArrayList<String> (permissionHelper.findResourcesWithPermissionAndPrefix(
					"", //ue.getId(), 
					rolNames,
					modulActiu,
					ExtendedPermission.READ));
		} else {
			recursosDisponibles = new ArrayList<String> (permissionHelper.findResourcesWithPermission(
					"", //ue.getId(), 
					rolNames,
					ExtendedPermission.READ));
		}
		return recursosDisponibles;
	}

}
