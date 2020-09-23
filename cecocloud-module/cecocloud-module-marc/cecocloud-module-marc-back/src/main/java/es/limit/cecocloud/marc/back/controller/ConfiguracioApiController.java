/**
 * 
 */
package es.limit.cecocloud.marc.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.marc.logic.api.dto.Configuracio;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;

/**
 * Controlador per al servei REST de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("marcConfiguracioApiController")
@RequestMapping(MarcModule.API_PATH + "/configuracions")
public class ConfiguracioApiController extends AbstractIdentificableApiController<Configuracio, Long> {

	@Override
	protected void processDto(HttpServletRequest request, Configuracio dto, Object userSession, boolean isNew) {
		super.processDto(request, dto, userSession, isNew);
		dto.setEmpresa(GenericReference.toGenericReference(((UserSession)userSession).getE()));
	}

}
