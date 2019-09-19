/**
 * 
 */
package es.limit.cecocloud.back.acl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionCacheOptimizer;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.domain.ConsoleAuditLogger;
import org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Configuració de les ACLs de Spring Security.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Configuration
@EnableAutoConfiguration
public class AclConfig {

	private static final String CLASS_IDENTITY_QUERY_ORACLE = "SELECT ACL_CLASS_SQ.CURRVAL FROM DUAL";
	private static final String SID_IDENTITY_QUERY_ORACLE = "SELECT ACL_SID_SQ.CURRVAL FROM DUAL";
	private static final String CLASS_IDENTITY_QUERY_POSTGRES = "select currval(pg_get_serial_sequence('acl_class', 'id'))";
	private static final String SID_IDENTITY_QUERY_POSTGRES = "select currval(pg_get_serial_sequence('acl_sid', 'id'))";
	private static final String CLASS_IDENTITY_QUERY_HYPERSONIC = "call identity()";
	private static final String SID_IDENTITY_QUERY_HYPERSONIC = "call identity()";

	@Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

	@Autowired
	private DataSource dataSource;

	@Bean
	public EhCacheBasedAclCache aclCache() {
		return new EhCacheBasedAclCache(
				aclEhCacheFactoryBean().getObject(),
				permissionGrantingStrategy(),
				aclAuthorizationStrategy());
	}

	@Bean
	public EhCacheFactoryBean aclEhCacheFactoryBean() {
		EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
		ehCacheFactoryBean.setCacheManager(aclCacheManager().getObject());
		ehCacheFactoryBean.setCacheName("aclCache");
		return ehCacheFactoryBean;
	}

	@Bean
	public EhCacheManagerFactoryBean aclCacheManager() {
		return new EhCacheManagerFactoryBean();
	}

	@Bean
	public PermissionGrantingStrategy permissionGrantingStrategy() {
		return new DefaultPermissionGrantingStrategy(new ConsoleAuditLogger());
	}

	@Bean
	public AclAuthorizationStrategy aclAuthorizationStrategy() {
		return new AclAuthorizationStrategy() {
			@Override
			public void securityCheck(Acl acl, int changeType) {
				if ((SecurityContextHolder.getContext() == null)
						|| (SecurityContextHolder.getContext().getAuthentication() == null)
						|| !SecurityContextHolder.getContext().getAuthentication()
								.isAuthenticated()) {
					throw new AccessDeniedException(
							"Authenticated principal required to operate with ACLs");
				}
			}
		};
	}

	@Bean
	public MethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler() {
		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		AclPermissionEvaluator permissionEvaluator = new AclPermissionEvaluator(aclService());
		permissionEvaluator.setPermissionFactory(permissionFactory());
		expressionHandler.setPermissionEvaluator(permissionEvaluator);
		expressionHandler.setPermissionCacheOptimizer(new AclPermissionCacheOptimizer(aclService()));
		return expressionHandler;
	}

	@Bean
	public LookupStrategy lookupStrategy() {
		BasicLookupStrategy lookupStrategy = new BasicLookupStrategy(
				dataSource,
				aclCache(),
				aclAuthorizationStrategy(),
				new ConsoleAuditLogger());
		lookupStrategy.setPermissionFactory(permissionFactory());
		return lookupStrategy;
	}

	@Bean
	public PermissionFactory permissionFactory() {
		return new ExtendedPermissionFactory();
	}

	@Bean
	public JdbcMutableAclService aclService() {
		// S'han hagut de modificar els mètodes retrieveObjectIdentityPrimaryKey i findChildren per a
		// solucionar errors en les consultes quan el tipus de base de dades és PostgreSQL. Si forçam
		// que l'identificador del ObjectIdentity sigui un String dona error al executar la consulta
		// dient que no es pot convertir un bigint al tipus varchar.
		JdbcMutableAclService jdbcMutableAclService = new JdbcMutableAclService(dataSource, lookupStrategy(), aclCache()) {
			protected Long retrieveObjectIdentityPrimaryKey(ObjectIdentity oid) {
				return super.retrieveObjectIdentityPrimaryKey(
						new ObjectIdentityImpl(
								oid.getType(),
								oid.getIdentifier().toString()));
			}
			public List<ObjectIdentity> findChildren(ObjectIdentity parentIdentity) {
				return super.findChildren(
						new ObjectIdentityImpl(
								parentIdentity.getType(),
								parentIdentity.getIdentifier().toString()));
			}
		};
		// Les consultes per a obtenir els ids son diferents per a cada base de dades.
		if (hibernateDialect.toLowerCase().contains("oracle")) {
			jdbcMutableAclService.setClassIdentityQuery(CLASS_IDENTITY_QUERY_ORACLE);
	        jdbcMutableAclService.setSidIdentityQuery(SID_IDENTITY_QUERY_ORACLE);
		} else if (hibernateDialect.toLowerCase().contains("postgres")) {
			jdbcMutableAclService.setClassIdentityQuery(CLASS_IDENTITY_QUERY_POSTGRES);
	        jdbcMutableAclService.setSidIdentityQuery(SID_IDENTITY_QUERY_POSTGRES);
		} else if (hibernateDialect.toLowerCase().contains("hsql")) {
			jdbcMutableAclService.setClassIdentityQuery(CLASS_IDENTITY_QUERY_HYPERSONIC);
	        jdbcMutableAclService.setSidIdentityQuery(SID_IDENTITY_QUERY_HYPERSONIC);
		}
        return jdbcMutableAclService;
	}

}
