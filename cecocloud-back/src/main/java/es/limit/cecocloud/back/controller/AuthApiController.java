/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.AuthResponse;
import es.limit.cecocloud.logic.api.service.AuthService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST per a gestionar el registre d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(value = AbstractApiController.API_PATH + AuthApiController.API_CONTROLLER_PATH)
public class AuthApiController {

	public static final String API_CONTROLLER_PATH = "/auth";

	@Autowired
	private AuthService authService;

	@GetMapping(
			path = "/check/{token}",
			produces = "application/json")
	public ResponseEntity<Boolean> check(
			@PathVariable final String token) {
		log.debug("Validant token JWT (" +
				"token=" + token + ")");
		return ResponseEntity.ok(authService.tokenCheck(token));
	}

	@PostMapping(
			path = "/refresh",
			produces = "application/json")
	public ResponseEntity<AuthResponse> refresh(
			@RequestParam(value = "token") final String token) {
		log.debug("Refrescant token JWT (" +
				"token=" + token + ")");
		return ResponseEntity.ok(
				new AuthResponse(
						authService.tokenRefresh(token),
						"Bearer"));
	}

}
