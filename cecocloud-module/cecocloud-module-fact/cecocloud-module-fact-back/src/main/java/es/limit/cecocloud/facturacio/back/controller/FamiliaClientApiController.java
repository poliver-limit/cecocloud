/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.facturacio.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de famílies clients.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/familiaClients")
public class FamiliaClientApiController extends AbstractIdentificableWithIdentificadorApiController<FamiliaClient> {

}
