/**
 * 
 */
package es.limit.cecocloud.back.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Configuració de la seguretat a nivell de mètode emprant ACLs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AclMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

	@Autowired
	private MethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler;

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		return defaultMethodSecurityExpressionHandler;
	}

}
