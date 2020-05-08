/**
 * 
 */
package es.limit.cecocloud.cita.persist.tools;

import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.fact.persist.entity.VehicleEntity;
import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;

/**
 * Utilitat per a la generació dels scripts SQL de creació de la BBDD.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DdlScriptGenerator extends es.limit.base.boot.persist.tools.DdlScriptGenerator {

	public static void main(String[] args) {
		//generate("org.hibernate.dialect.HSQLDialect", getAdditionalPackageNames());
		//generate("es.limit.base.boot.persist.tools.BaseBootOracle9iDialect", getAdditionalPackageNames());
		generate("es.limit.base.boot.persist.tools.BaseBootPostgreSQLDialect", getAdditionalPackageNames());
	}

	private static String[] getAdditionalPackageNames() {
		return new String[] {
				CitaEntity.class.getPackage().getName(), // package amb entitats del mòdul de cites
				VehicleEntity.class.getPackage().getName(), // package amb entitats del mòdul de facturació
				SeccioEntity.class.getPackage().getName() // package amb entitats del mòdul de recursos humans
		};
	}

}
