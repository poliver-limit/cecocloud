/**
 * 
 */
package es.limit.cecocloud.marcatges.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.marcatges.logic.api.dto.CompositePkTest;
import es.limit.cecocloud.marcatges.logic.api.module.MarcatgesModule;

/**
 * Controlador per al servei REST de gestió d'cpktests.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcatgesModule.API_PATH + "/cpktest")
public class CpkTestApiController extends AbstractIdentificableApiController<CompositePkTest, String> {

}
