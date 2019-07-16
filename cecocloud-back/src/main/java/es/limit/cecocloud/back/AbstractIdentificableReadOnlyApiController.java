/**
 * 
 */
package es.limit.cecocloud.back;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.Serializable;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.GenericService;

/**
 * Mètodes bàsics per als controladors REST de només lectura que
 * gestionen entitats que depenen d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public abstract class AbstractIdentificableReadOnlyApiController<D extends Identificable<ID>, ID extends Serializable> extends AbstractApiController<D> {

	@GetMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<Resource<D>> getOne(
			HttpServletRequest request,
			@PathVariable @DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN) final ID resourceId) {
		logger.debug("Obtenint entitat (" +
				"resourceId=" + resourceId + ")");
		try  {
			D dto = getService().getOne(resourceId);
			return ResponseEntity.ok(
					toResource(
							dto,
							getResourceWithIdLink(dto.getId(), Link.REL_SELF),
							getProfileLink("profile")));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(
			produces = "application/json")
	public ResponseEntity<PagedResources<Resource<D>>> find(
			HttpServletRequest request,
			@RequestParam(value = "query", required = false) final String query,
			final Pageable pageable) {
		logger.debug("Consulta d'entitats amb filtre i paginació (" +
				"query=" + query + ", " +
				"pageable=" + pageable + ")");
		Page<D> pagina = getService().findPageByRsqlQuery(
				query,
				pageable);
		return ResponseEntity.ok(
				toPagedResources(
						pagina,
						getApiLink(Link.REL_SELF),
						getProfileLink("profile")));
	}

	@SuppressWarnings("unchecked")
	protected Link getResourceWithIdLink(Object id, String rel) {
		Link link = linkTo(methodOn(getClass()).getOne(null, null)).withRel(rel);
		if (id != null) {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(link.getHref());
			link = new Link(uriBuilder.buildAndExpand(id).toString());
		}
		return link;
	}
	protected Link getApiLink(String rel) {
		return linkTo(methodOn(getClass()).find(null, null, null)).withRel(rel);
	}
	protected Link getProfileLink(String rel) {
		return linkTo(methodOn(ProfileApiController.class).getOne(null, getResourceNameFromDtoClass())).withRel(rel);
	}

	private String getResourceNameFromDtoClass() {
		String simpleName = getDtoClass().getSimpleName();
		return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
	}

	protected abstract GenericService<D, ID> getService();

	private static final Logger logger = LoggerFactory.getLogger(AbstractIdentificableReadOnlyApiController.class);

}
