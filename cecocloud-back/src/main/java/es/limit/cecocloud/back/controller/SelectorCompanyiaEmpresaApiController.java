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
import es.limit.cecocloud.logic.api.dto.SelectorCompanyia;
import es.limit.cecocloud.logic.api.service.SelectorCompanyiaEmpresaService;

/**
 * Controlador per al servei REST que retorna la llista de companyies i empreses a les
 * que l'usuari té accés.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(value = ApiControllerHelper.API_PATH + "/selectorCompanyiaEmpres")
public class SelectorCompanyiaEmpresaApiController {

	@Autowired SelectorCompanyiaEmpresaService selectorCompanyiaEmpresaService;

	@GetMapping(
			produces = "application/json")
	public ResponseEntity<List<SelectorCompanyia>> findMenuCompanyies(
			HttpServletRequest request) {
		return ResponseEntity.ok(selectorCompanyiaEmpresaService.getSelectorCompanyiaEmpresa());
	}

}
