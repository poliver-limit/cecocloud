/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.service.AbstractProfileServiceImpl;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Implementació del servei per a obtenir perfil d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProfileServiceImpl extends AbstractProfileServiceImpl {

	private List<String> packageNames = null;

	@Override
	protected String[] getDtoPackageNames() {
		if (packageNames == null) {
			packageNames = new ArrayList<String>();
			packageNames.add(Profile.class.getPackage().getName());
			packageNames.add(Companyia.class.getPackage().getName());
			for (ModuleInfo moduleInfo: Modules.getModules()) {
				packageNames.add(moduleInfo.getDtoPackage());
			}
		}
		return packageNames.toArray(new String[packageNames.size()]);
	}

}
