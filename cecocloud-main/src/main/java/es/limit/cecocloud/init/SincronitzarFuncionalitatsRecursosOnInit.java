/**
 * 
 */
package es.limit.cecocloud.init;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.service.FuncionalitatService;
import es.limit.cecocloud.logic.api.service.RecursService;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe per a activar la sincronització de funcionalitats i recursos al
 * iniciar l'aplicació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Component
public class SincronitzarFuncionalitatsRecursosOnInit {

	private static final boolean SINCRONITZAR = true;

	@Autowired
	private RecursService recursService;
	@Autowired
	private FuncionalitatService funcionalitatService;

	@EventListener(ApplicationStartedEvent.class)
	public void handleApplicationStartedEvent() {
		// Per a crear o modificar funcionalitats i recursos és necessari
		// que hi hagi un usuari autenticat.
		Authentication auth = new UsernamePasswordAuthenticationToken(
				"cecocloud",
				null,
				Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
		SecurityContextHolder.getContext().setAuthentication(auth);
		log.debug("Sincronitzant els recursos");
		if (SINCRONITZAR) {
			recursService.execute("sync", null);
		}
		log.debug("...recursos sincronitzats correctament");
		log.debug("Sincronitzant les funcionalitats...");
		if (SINCRONITZAR) {
			funcionalitatService.execute("sync", null);
		}
		log.debug("...funcionalitats sincronitzades correctament");
	}

}
