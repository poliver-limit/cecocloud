/**
 * 
 */
package es.limit.cecocloud.back.controller;

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

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.MarcatgeMobil;
import es.limit.cecocloud.logic.api.dto.MarcatgeMobilConsulta;
import es.limit.cecocloud.logic.api.service.MobileMarcatgeService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de l'aplicació mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH + MobileMarcatgesApiController.API_CONTROLLER_PATH)
public class MobileMarcatgesApiController {

	public static final String API_CONTROLLER_PATH = "/mobile/marcatges";

	@Autowired
	private MobileMarcatgeService mobileMarcatgeService;

	@PostMapping(
			produces = "application/json")
	public ResponseEntity<MarcatgeMobil> create(
			HttpServletRequest request,
			@RequestBody @Valid final MarcatgeMobil dto) {
		log.debug("Creant marcatge(" +
				"dto=" + dto + ")");
		MarcatgeMobil creat = mobileMarcatgeService.create(dto);
		return ResponseEntity.ok(creat);
	}

	@GetMapping(
			produces = "application/json")
	public ResponseEntity<List<MarcatgeMobil>> find(
			HttpServletRequest request,
			@Valid final MarcatgeMobilConsulta consulta) {
		log.debug("Consulta de marcatges(" +
				"consulta=" + consulta + ")");
		return ResponseEntity.ok(mobileMarcatgeService.find(consulta));
	}

	@GetMapping(
			path = "/empreses",
			produces = "application/json")
	public ResponseEntity<List<Empresa>> empresesFind(
			HttpServletRequest request) {
		log.debug("Consulta d'empreses disponibles");
		return ResponseEntity.ok(mobileMarcatgeService.empresesFindAll());
	}

}
