/**
 * 
 */
package es.limit.cecocloud.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.SincronitzacioCompanyia;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgeConsulta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de sincronització d'informació de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + SincronitzacioApiController.API_CONTROLLER_PATH)
public class SincronitzacioApiController {

	public static final String API_CONTROLLER_PATH = "/sync";

	@Autowired
	private SincronitzacioService sincronitzacioService;

	@PostMapping(
			path = "/empreses_operaris",
			produces = "application/json")
	public ResponseEntity<SincronitzacioResposta> sincronitzar(
			HttpServletRequest request,
			@RequestBody @Valid final SincronitzacioCompanyia dto) {
		log.debug("Nova sincronització(" +
				"dto=" + dto + ")");
		return ResponseEntity.ok(
				sincronitzacioService.sincronitzar(dto));
	}

	@GetMapping(
			path = "/marcatges",
			produces = "application/json")
	public ResponseEntity<List<SincronitzacioMarcatge>> marcatgeFind(
			HttpServletRequest request,
			@Valid final SincronitzacioMarcatgeConsulta consulta) {
		log.debug("Consulta de marcatges (" +
				"consulta=" + consulta + ")");
		List<SincronitzacioMarcatge> marcatges = sincronitzacioService.marcatgeFind(consulta);
		return ResponseEntity.ok(marcatges);
	}

}
