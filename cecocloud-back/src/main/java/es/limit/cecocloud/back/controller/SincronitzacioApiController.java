/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de sincronització d'informació provinent de
 * CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(GenericController.API_PATH + "/sync")
public class SincronitzacioApiController {

	@Autowired
	private SincronitzacioService sincronitzacioService;

	@PostMapping(
			path = "/identificador",
			produces = "application/json")
	public ResponseEntity<SincronitzacioIdentificadorResposta> sincronitzarEmpresesOperaris(
			HttpServletRequest request,
			@RequestBody @Valid final SincronitzacioIdentificadorPeticio dto) {
		log.debug("Nova sincronització d'identificador(" +
				"dto=" + dto + ")");
		SincronitzacioIdentificadorResposta resposta = sincronitzacioService.sincronitzarIdentificador(dto);
		return ResponseEntity.ok(resposta);
	}

}
