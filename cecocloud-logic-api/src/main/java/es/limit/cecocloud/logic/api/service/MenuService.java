/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.MenuCompanyia;

/**
 * Servei encarregat de gestionar companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MenuService {

	public List<MenuCompanyia> getMenuCompanyia();
	public List<String> findMenusPermesos(String modulActiu);
}
