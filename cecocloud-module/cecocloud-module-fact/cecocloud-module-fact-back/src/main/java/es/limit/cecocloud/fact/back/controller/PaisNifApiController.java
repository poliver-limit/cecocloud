/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.fact.logic.api.dto.PaisNif;

/**
 * Controlador per al servei REST de gestió de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factPaisNifApicontroller")
@RequestMapping(GenericController.API_PATH + "/paisosNif")
public class PaisNifApiController extends AbstractIdentificableApiController<PaisNif,String> {

}
