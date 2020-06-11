/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de CaixaMoviment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomCaixaMovimentController")
@RequestMapping(EcomModuleConfig.API_PATH + "/caixesMoviment")
public class CaixaMovimentApiController extends AbstractIdentificableWithIdentificadorApiController<CaixaMoviment> {

}
