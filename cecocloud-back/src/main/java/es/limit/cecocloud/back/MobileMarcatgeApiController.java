/**
 * 
 */
package es.limit.cecocloud.back;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.MarcatgeMobil;
import es.limit.cecocloud.logic.api.service.MobileMarcatgeService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de l'aplicació mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + MobileMarcatgeApiController.API_CONTROLLER_PATH)
public class MobileMarcatgeApiController extends AbstractApiController {

	public static final String API_CONTROLLER_PATH = "/mobile/marcatge";

	@Autowired
	private MobileMarcatgeService mobileMarcatgeService;

	@PostMapping(
			path = "/marcatges",
			produces = "application/json")
	public ResponseEntity<MarcatgeMobil> marcatgeCreate(
			HttpServletRequest request,
			@RequestBody @Valid final MarcatgeMobil dto) {
		log.debug("Creant marcatge(" +
				"dto=" + dto + ")");
		MarcatgeMobil creat = mobileMarcatgeService.marcatgeCreate(dto);
		return ResponseEntity.ok(creat);
	}

	@GetMapping(
			path = "/empreses",
			produces = "application/json")
	public ResponseEntity<Resources<Resource<Empresa>>> find(
			HttpServletRequest request) {
		log.debug("Consulta d'empreses disponibles");
		return ResponseEntity.ok(
				this.toResources(
						mobileMarcatgeService.empresaFindAll()));
	}

}
