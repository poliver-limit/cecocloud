/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomMagatzemPeriodeController")
@RequestMapping(EcomModuleConfig.API_PATH + "/magatzemsPeriode")
public class MagatzemPeriodeApiController extends AbstractIdentificableWithIdentificadorApiController<MagatzemPeriode> {

}
