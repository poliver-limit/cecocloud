/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithPermissionsApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.base.boot.back.controller.ApiControllerHelper.SelfLinkBuilder;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.CompanyiaSelectionTreeItem;
import es.limit.cecocloud.logic.api.service.CompanyiaService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/companyies")
public class CompanyiaApiController extends AbstractIdentificableWithPermissionsApiController<Companyia, Long> {

	@Autowired
	private CompanyiaService service;

	@Override
	protected CompanyiaService getService() {
		return service;
	}

	@GetMapping(
			value = "/selectionTree",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<CompanyiaSelectionTreeItem>>> selectionTree(
			HttpServletRequest request) {
		log.debug("Obtenint arbre de companyies");
		return ResponseEntity.ok(
				toResources(
						getService().buildSelectionTree(),
						getClass(),
						new SelfLinkBuilder() {
							@Override
							public Link build(Class<?> apiControllerClass, Object... params) {
								return getSelfLink(params);
							}
						},
						getApiLink(Link.REL_SELF),
						getProfileLink("profile")));
	}

}
