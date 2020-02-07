/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.module;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.module.Modul;

/**
 * Configuració del mòdul de recursos humans.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RrhhModuleConfig {

	public static final String CODE = Modul.rrhh.name();
	public static final String API_PATH = GenericController.API_PATH + "/rrhh";

}
