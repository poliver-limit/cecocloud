/*
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import es.limit.cecocloud.rrhh.logic.api.dto.TipusComissio;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de tipusComisions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RequestMapping(RrhhModuleConfig.API_PATH + "/tipusComissions")
public class TipusComissioApiController extends AbstractIdentificableAmbIdentificadorApiController<TipusComissio> {

}
