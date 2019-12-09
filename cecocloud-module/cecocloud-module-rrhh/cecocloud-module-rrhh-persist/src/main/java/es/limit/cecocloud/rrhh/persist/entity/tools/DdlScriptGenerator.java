/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity.tools;

import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;

/**
 * Utilitat per a la generació dels scripts SQL de creació de la BBDD.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DdlScriptGenerator extends es.limit.base.boot.persist.tools.DdlScriptGenerator {

	public static void main(String[] args) {
		//generate("org.hibernate.dialect.HSQLDialect", getAdditionalPackageNames());
		//generate("org.hibernate.dialect.Oracle9iDialect", getAdditionalPackageNames());
		generate("org.hibernate.dialect.PostgreSQLDialect", getAdditionalPackageNames());
	}

	private static String[] getAdditionalPackageNames() {
		return new String[] {				
				SeccioEntity.class.getPackage().getName() // package amb entitats del mòdul de recursos humans
		};
	}

}
