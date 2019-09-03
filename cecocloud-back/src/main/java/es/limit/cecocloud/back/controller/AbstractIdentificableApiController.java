/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.io.Serializable;
import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.rest.webmvc.json.patch.JsonPatchPatchConverter;
import org.springframework.data.rest.webmvc.json.patch.Patch;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.logic.api.dto.util.Identificable;
import lombok.extern.slf4j.Slf4j;

/**
 * Mètodes bàsics per als controladors REST que gestionen entitats
 * que depenen d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
public abstract class AbstractIdentificableApiController<D extends Identificable<ID>, ID extends Serializable> extends AbstractIdentificableReadOnlyApiController<D, ID> {

	@Autowired
	protected ObjectMapper objectMapper;
	@Autowired
	private SmartValidator validator;

	@GetMapping(
			value = "/new",
			produces = "application/json")
	public ResponseEntity<Resource<D>> getNew(
			HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		log.debug("Obtenint nova instància");
		@SuppressWarnings("unchecked")
		D newInstance = ((Class<D>)getDtoClass()).newInstance();
		return ResponseEntity.ok(
				toResource(
						newInstance,
						getProfileLink("profile")));
	}

	@PostMapping(
			produces = "application/json")
	public ResponseEntity<Resource<D>> create(
			HttpServletRequest request,
			@RequestBody @Valid final D dto) {
		log.debug("Creant entitat (" +
				"dto=" + dto + ")");
		D creat = getService().create(dto);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).
				path("/{id}").
	            buildAndExpand(creat.getId()).
	            toUri();
		return ResponseEntity.created(uri).body(
				toResource(creat));
	}

	@PutMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<Resource<D>> update(
			HttpServletRequest request,
			@PathVariable /*@DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN)*/ final ID resourceId,
			@RequestBody @Valid final D dto,
			@RequestParam(required = false) boolean validate) {
		if (!validate) {
			log.debug("Modificant entitat (" +
					"resourceId=" + resourceId + ", " +
					"dto=" + dto + ")");
			D modificat = getService().update(
					resourceId,
					dto);
			return ResponseEntity.ok(toResource(modificat));
		} else {
			log.debug("Validant entitat per modificació (" +
					"resourceId=" + resourceId + ", " +
					"dto=" + dto + ")");
			return ResponseEntity.ok(null);
		}
	}

	@PatchMapping(
			value = "/{resourceId}",
			produces = "application/json")
	public ResponseEntity<Resource<D>> patch(
			HttpServletRequest request,
			@PathVariable /*@DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN)*/ final ID resourceId,
			@RequestBody final JsonNode jsonNode,
			BindingResult bindingResult) throws MethodArgumentNotValidException {
		log.debug("Pedaçant entitat (" +
				"resourceId=" + resourceId + ", " +
				"jsonNode=" + jsonNode + ")");
		Patch patch = new JsonPatchPatchConverter(objectMapper).convert(jsonNode);
		@SuppressWarnings("unchecked")
		D patchedDto = patch.apply(
				getService().getOne(resourceId),
				(Class<D>)getDtoClass());
		validator.validate(
				patchedDto,
				bindingResult,
				Default.class);
	    if (bindingResult.hasErrors()) {
	    	throw new MethodArgumentNotValidException(
	    			new MethodParameter(
	    					new Object() {}.getClass().getEnclosingMethod(),
	    					2),
	    			bindingResult);
	    } else {
			D modificat = getService().update(
					resourceId,
					patchedDto);
			Resource<D> resource = toResource(modificat);
			return ResponseEntity.ok(resource);
	    }
	}

	@DeleteMapping(value = "/{resourceId}")
	public ResponseEntity<?> delete(
			HttpServletRequest request,
			@PathVariable /*@DateTimeFormat(pattern = PATHVARIABLE_DATEFORMAT_PATTERN)*/ final ID resourceId) {
		log.debug("Esborrant entitat (" +
				"resourceId=" + resourceId + ")");
		getService().delete(resourceId);
		return ResponseEntity.ok().build();
	}

}
