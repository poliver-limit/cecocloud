/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.service.AbstractProfileServiceImpl;
import es.limit.cecocloud.logic.api.dto.Companyia;

/**
 * Implementació del servei per a obtenir perfil d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProfileServiceImpl extends AbstractProfileServiceImpl {

	@Override
	protected String[] getDtoPackageNames() {
		return new String[] {
				Profile.class.getPackage().getName(),
				Companyia.class.getPackage().getName()
		};
	}

}
