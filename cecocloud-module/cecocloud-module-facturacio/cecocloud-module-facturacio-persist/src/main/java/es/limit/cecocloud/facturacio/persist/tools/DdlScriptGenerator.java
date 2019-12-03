/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.tools;

import es.limit.cecocloud.facturacio.persist.entity.ZonaEntity;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
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
				//CompanyiaEntity.class.getPackage().getName(),
				ZonaEntity.class.getPackage().getName(),
				SeccioEntity.class.getPackage().getName()};
	}

}
