/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.persist.tools;

import es.limit.cecocloud.ecom.persist.entity.ComptadorEntity;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.PaycometNotificationEntity;

/**
 * Utilitat per a la generació dels scripts SQL de creació de la BBDD.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DdlScriptGenerator extends es.limit.base.boot.persist.tools.DdlScriptGenerator {

	public static void main(String[] args) {
		//generate("org.hibernate.dialect.HSQLDialect", getAdditionalPackageNames());
		generate("org.hibernate.dialect.Oracle9iDialect", getAdditionalPackageNames());
//		generate("org.hibernate.dialect.PostgreSQLDialect", getAdditionalPackageNames());
	}

	private static String[] getAdditionalPackageNames() {
		return new String[] {
				ComptadorEntity.class.getPackage().getName(), // package amb entitats del mòdul de ecommerce
				OperariEntity.class.getPackage().getName(), // package amb entitats del mòdul de rrhh	
				PaycometNotificationEntity.class.getPackage().getName() // package amb entitats del mòdul de ecommerce	BACK!!!!			
		};
	}

}
