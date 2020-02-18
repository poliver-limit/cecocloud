/**
 * 
 */
package es.limit.cecocloud.lici.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.lici.logic.api.module.LiciModule;
import es.limit.cecocloud.lici.logic.api.service.LicitacioService;

/**
 * Controlador per al servei REST de licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(LiciModule.API_PATH + "/licitacions")
public class LicitacioApiController extends AbstractIdentificableApiController<Licitacio, Long> {

	@Autowired
	LicitacioService licitacioService;
	
	@Override
	protected void completeDtoWithSession(Licitacio dto, Object userSession, boolean isNew) {
		super.completeDtoWithSession(dto, userSession, isNew);
		dto.setEmpresa(GenericReference.toGenericReference(((UserSession) userSession).getE()));
	}
	
}
