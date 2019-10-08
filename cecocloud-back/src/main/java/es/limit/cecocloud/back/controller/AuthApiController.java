/**
 * 
 */
package es.limit.cecocloud.back.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.AuthResponse;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.AuthService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST per a gestionar el registre d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(value = AbstractIdentificableApiController.API_PATH + AuthApiController.API_CONTROLLER_PATH)
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
			@RequestBody @Valid final RefreshTokenMessage message) {
		log.debug("Refrescant token JWT (" +
				"token=" + message.getToken() + "," +
				"session=" + message.getSession() + ")");
		return ResponseEntity.ok(
				new AuthResponse(
						authService.tokenRefresh(
								message.getToken(),
								message.getSession()),
						"Bearer"));
	}

	@Getter @Setter
	private static class RefreshTokenMessage {
		@NotNull
		private String token;
		private UserSession session;
	}

}
