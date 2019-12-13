/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModule;

/**
 * Controlador per al servei REST de gestió de la entitat Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("OperariRrhhController")
@RequestMapping(RrhhModule.API_PATH + "/operaris")
public class OperariApiController extends AbstractIdentificableApiController<Operari, String> {

}
