/**
 * 
 */
package es.limit.cecocloud.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
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

	private static final boolean SINCRONITZAR = false;

	@Autowired
	private FuncionalitatService funcionalitatService;
	@Autowired
	private RecursService recursService;

	@EventListener(ApplicationStartedEvent.class)
	public void handleApplicationStartedEvent() {
		log.info("Sincronitzant les funcionalitats...");
		if (SINCRONITZAR) {
			funcionalitatService.execute("sync", null);
		}
		log.info("...funcionalitats sincronitzades correctament");
		log.info("Sincronitzant els recursos");
		if (SINCRONITZAR) {
			recursService.execute("sync", null);
		}
		log.info("...recursos sincronitzats correctament");
	}

}
