/**
 * 
 */
package es.limit.cecocloud.back;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.RegistreUsuari;
import es.limit.cecocloud.logic.api.dto.RegistreValidate;
import es.limit.cecocloud.logic.api.service.RegistreService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST per a gestionar el registre d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + RegistreApiController.API_CONTROLLER_PATH)
public class RegistreApiController {

	public static final String API_CONTROLLER_PATH = "/registres";

	@Autowired
	private RegistreService registreService;

	@PostMapping(
			produces = "application/json")
	public ResponseEntity<?> create(
			HttpServletRequest request,
			@RequestBody @Valid final RegistreUsuari dto) {
		log.debug("Creant registre d'usuaris(" +
				"dto=" + dto + ")");
		registreService.create(dto);
		return ResponseEntity.ok().build();
	}

	@PostMapping(
			path = "/{email}/reset",
			produces = "application/json")
	public ResponseEntity<?> reset(
			HttpServletRequest request,
			@PathVariable final String email) {
		log.debug("Iniciant recuperació de contrasenya (" +
				"email=" + email + ")");
		registreService.contrasenyaRecover(email);
		return ResponseEntity.ok().build();
	}

	@PostMapping(
			path = "/validate",
			produces = "application/json")
	public ResponseEntity<?> validate(
			HttpServletRequest request,
			@RequestBody @Valid final RegistreValidate dto) {
		log.debug("Validant registre d'usuari (" +
				"dto=" + dto + ")");
		registreService.validate(dto);
		return ResponseEntity.ok().build();
	}

}
