/**
 * 
 */
package es.limit.cecocloud.lici.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.back.controller.AbstractIdentificableWithIdentificadorApiController;
import es.limit.cecocloud.lici.logic.api.module.LiciModuleConfig;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;

/**
 * Controlador per al servei REST de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(LiciModuleConfig.API_PATH + "/configuracions")
public class ConfiguracioApiController extends AbstractIdentificableApiController<Configuracio,Long> {

}
