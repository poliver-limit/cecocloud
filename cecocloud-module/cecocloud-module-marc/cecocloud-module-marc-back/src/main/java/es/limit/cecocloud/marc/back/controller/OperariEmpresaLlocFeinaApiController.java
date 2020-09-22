/**
 * 
 */
package es.limit.cecocloud.marc.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.marc.logic.api.dto.OperariEmpresaLlocFeina;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;

/**
 * Controlador per al servei REST de relacions d'operari-empresa amb lloc de feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcModule.API_PATH + "/operariEmpresaLlocsFeina")
public class OperariEmpresaLlocFeinaApiController extends AbstractIdentificableApiController<OperariEmpresaLlocFeina, Long> {

}
