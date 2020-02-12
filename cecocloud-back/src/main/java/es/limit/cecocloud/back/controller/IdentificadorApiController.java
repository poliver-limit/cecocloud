/**
 * 
 */
package es.limit.cecocloud.back.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithPermissionsApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.service.UsuariService;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.service.FuncionalitatIdentificadorService;

/**
 * Controlador per al servei REST de gestió de recursos de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/identificadors")
public class IdentificadorApiController extends AbstractIdentificableWithPermissionsApiController<Identificador, Long> {

	@Autowired 
	private UsuariService usuariService;
	@Autowired 
	private FuncionalitatIdentificadorService funcionalitatIdentificadorService;
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Override
	protected void completeDtoWithSession(Identificador dto, Object userSession) {
		super.completeDtoWithSession(dto, userSession);
		// Afegim l'usuari propietari
		if (dto.getPropietari() == null) {
			String usuariCodi = authenticationHelper.getPrincipalName();
			Usuari usuari = usuariService.findOneByRsqlQuery("codi==\"" + usuariCodi + "\"");
			GenericReference<Usuari, Long> propietari = GenericReference.toGenericReference(usuari.getId());
			propietari.setDescription(usuari.getNomComplet());
			dto.setPropietari(propietari);
		}
	}

	@GetMapping(
			value = "/{resourceId}/funcionalitats",
			produces = "application/json")
	@PreAuthorize("hasPermission(0, this.getDtoClassName(), 'READ')")
	public ResponseEntity<CollectionModel<EntityModel<Funcionalitat>>> findFuncionalitats(
			@PathVariable final Long resourceId) {
		List<Funcionalitat> funcionalitats = funcionalitatIdentificadorService.funcionalitatFindByIdentificadorId(resourceId);
		return ResponseEntity.ok(
				toResources(
						funcionalitats,
						getClass(),
						getDefaultResourceLinksBuilder()));
	}

	@Override
	protected Link[] additionalLinks(Long id) {
		Link funcionalitatsLink = linkTo(methodOn(getClass()).findFuncionalitats(id)).withRel(LinkRelation.of("funcionalitats"));
		return new Link[] {funcionalitatsLink};
	}

}
