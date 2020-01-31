/**
 * 
 */
package es.limit.cecocloud.marc.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.marc.logic.api.dto.CompositePkTest;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;

/**
 * Controlador per al servei REST de gestió d'cpktests.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcModule.API_PATH + "/cpktest")
public class CpkTestApiController extends AbstractIdentificableApiController<CompositePkTest, String> {

}
