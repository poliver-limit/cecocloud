/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.MenuCompanyia;
import es.limit.cecocloud.logic.api.service.MenuService;

/**
 * Controlador per al servei REST que retorna la llista de mòduls disponibles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = ApiControllerHelper.API_PATH + "/menus")
public class MenuApiController {

	@Autowired MenuService menuService;
	
	@GetMapping(
			produces = "application/json")
	public ResponseEntity<List<MenuCompanyia>> findMenuCompanyies(
			HttpServletRequest request) {
		return ResponseEntity.ok(menuService.getMenuCompanyia());
	}

}
