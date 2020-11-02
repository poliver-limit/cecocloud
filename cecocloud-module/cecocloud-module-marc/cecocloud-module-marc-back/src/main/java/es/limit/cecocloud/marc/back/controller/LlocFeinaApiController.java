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
import es.limit.cecocloud.marc.logic.api.dto.LlocFeina;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;

/**
 * Controlador per al servei REST de configuració.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(MarcModule.API_PATH + "/llocsFeina")
public class LlocFeinaApiController extends AbstractIdentificableApiController<LlocFeina, Long> {

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return	"empresa.id==" + ((UserSession)userSession).getE() + ";" +
				"empresa.identificador.id==" + ((UserSession)userSession).getI();
	}

	@Override
	protected void processDto(HttpServletRequest request, LlocFeina dto, Object userSession, boolean isNew) {
		super.processDto(request, dto, userSession, isNew);
		dto.setEmpresa(GenericReference.toGenericReference(((UserSession)userSession).getE()));
	}

}
