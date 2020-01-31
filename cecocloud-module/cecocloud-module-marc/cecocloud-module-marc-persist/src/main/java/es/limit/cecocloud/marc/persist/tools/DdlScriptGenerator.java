/**
 * 
 */
package es.limit.cecocloud.marc.persist.tools;

import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

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
				IdentificadorEntity.class.getPackage().getName(),
				MarcatgeEntity.class.getPackage().getName()};
	}

}
