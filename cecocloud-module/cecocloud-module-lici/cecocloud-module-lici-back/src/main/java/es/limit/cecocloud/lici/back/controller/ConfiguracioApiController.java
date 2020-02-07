/**
 * 
 */
package es.limit.cecocloud.lici.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.LinkRelation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.lici.logic.api.module.LiciModuleConfig;
import es.limit.cecocloud.lici.logic.api.service.ConfiguracioService;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(LiciModuleConfig.API_PATH + "/configuracions")
public class ConfiguracioApiController extends AbstractIdentificableApiController<Configuracio,Long> {

	
	@Override
	protected void completeDtoWithSession(Configuracio dto, Object userSession) {
		super.completeDtoWithSession(dto, userSession);
		dto.setEmpresa(GenericReference.toGenericReference(((UserSession)userSession).getE()));
	}

	
	

}
