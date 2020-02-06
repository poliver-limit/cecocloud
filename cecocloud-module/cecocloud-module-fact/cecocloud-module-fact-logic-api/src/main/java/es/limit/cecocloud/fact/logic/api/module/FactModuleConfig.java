/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.module;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.logic.api.module.Modul;

/**
 * Configuració del mòdul de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class FactModuleConfig {

	public static final String CODE = Modul.fact.name();
	public static final String API_PATH = GenericController.API_PATH + "/fact";

}
