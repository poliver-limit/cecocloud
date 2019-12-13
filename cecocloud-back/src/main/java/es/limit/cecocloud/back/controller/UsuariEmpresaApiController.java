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

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper.SelfLinkBuilder;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorEmpresaService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de relacions usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(GenericController.API_PATH + "/usuariEmpresa")
public class UsuariEmpresaApiController extends AbstractIdentificableApiController<UsuariIdentificadorEmpresa, String> {

	@Autowired
	private UsuariIdentificadorEmpresaService service;

	@Override
	protected UsuariIdentificadorEmpresaService getService() {
		return service;
	}
	
	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long companyiaId = ((UserSession)userSession).getC();
		return "empresa.identificador.companyia.id==" + companyiaId;
	}
	
	
	// Mètodes per a configurar els permisos (perfils) a nivell d'usuari-empresa
	@GetMapping(
			value = "/perfilTree",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<UsuariIdentificadorEmpresaPerfilTreeItem>>> selectionTree(
			HttpServletRequest request) {
		log.debug("Obtenint arbre de usuaris-empreses");
		return ResponseEntity.ok(
				toResources(
						getService().buildPerfilTree(),
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
