/**
 * 
 */
package es.limit.cecocloud.fact.logic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.limit.cecocloud.fact.persist.listener.EntityListenerHelper;

/**
 * S'inclou una instància de EntityListenerHelper a dins el
 * context d'Spring per a activar les anotacions @Autowired.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Configuration
public class EntityListenerHelperFactConfig {

	@Bean(name = "entityListenerHelperFacturacio")
	public EntityListenerHelper afegirEntityListenerHelper() {
		return EntityListenerHelper.getInstance();
	}

}
