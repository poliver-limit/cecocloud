/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithCompositePkApiController;
import es.limit.base.boot.back.controller.ApiControllerHelper.SelfLinkBuilder;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorEmpresaService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió relacions usuariIdentificador-Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(GenericController.API_PATH + "/usuariIdentificadorEmpreses")
public class UsuariIdentificadorEmpresaApiController extends AbstractIdentificableWithCompositePkApiController<UsuariIdentificadorEmpresa> {

	// Mètodes per a obtenir les empreses a les que té accés l'usuari autenticat
	@GetMapping(
			value = "/selectionTree",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<IdentificadorEmpresaSelectionTreeItem>>> selectionTree(
			HttpServletRequest request) {
		log.debug("Obtenint arbre de usuaris-idf-empreses");
		return ResponseEntity.ok(
				toResources(
						((UsuariIdentificadorEmpresaService)getService()).buildSelectionTree(),
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

	// Mètodes per a configurar els permisos (perfils) a nivell d'usuari-empresa
	@GetMapping(
			value = "/perfilTree",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<UsuariIdentificadorEmpresaPerfilTreeItem>>> perfilTree(
			HttpServletRequest request) {
		log.debug("Obtenint arbre de usuaris-idf-empreses");
		return ResponseEntity.ok(
				toResources(
						((UsuariIdentificadorEmpresaService)getService()).buildPerfilTree(),
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

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		Long identificadorId = ((UserSession)userSession).getI();
		return "empresa.identificador.id==" + identificadorId;
	}

}
