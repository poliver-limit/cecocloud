/**
 * 
 */
package es.limit.cecocloud.lici.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.lici.logic.api.module.LiciModuleConfig;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(LiciModuleConfig.API_PATH + "/licitacions")
public class LicitacioApiController extends AbstractIdentificableApiController<Licitacio, Long> {

	@Override
	protected void completeDtoWithSession(Licitacio dto, Object userSession) {
		super.completeDtoWithSession(dto, userSession);
		dto.setEmpresa(GenericReference.toGenericReference(((UserSession) userSession).getE()));
	}

}
