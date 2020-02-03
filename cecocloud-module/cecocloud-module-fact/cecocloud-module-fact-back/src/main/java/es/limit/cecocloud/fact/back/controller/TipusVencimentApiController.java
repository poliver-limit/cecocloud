/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/tipusVenciments")
public class TipusVencimentApiController extends AbstractIdentificableWithIdentificadorApiController<TipusVenciment> {

}