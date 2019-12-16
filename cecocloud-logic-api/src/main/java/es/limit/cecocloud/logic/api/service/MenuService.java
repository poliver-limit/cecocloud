/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

/**
 * Servei encarregat de gestionar menus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MenuService {

	public List<String> findMenusPermesos(String modulActiu);
	
}
