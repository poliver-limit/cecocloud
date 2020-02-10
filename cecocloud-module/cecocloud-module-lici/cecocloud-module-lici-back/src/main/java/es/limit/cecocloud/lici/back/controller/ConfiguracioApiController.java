/**
 * 
 */
package es.limit.cecocloud.lici.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.lici.logic.api.module.LiciModule;

/**
 * Controlador per al servei REST de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(LiciModule.API_PATH + "/configuracions")
public class ConfiguracioApiController extends AbstractIdentificableApiController<Configuracio,Long> {

}
