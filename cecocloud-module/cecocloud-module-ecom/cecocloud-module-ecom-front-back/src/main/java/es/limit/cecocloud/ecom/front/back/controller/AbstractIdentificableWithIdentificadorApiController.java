/**
 * 
 */
package es.limit.cecocloud.ecom.front.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.IdentificadorService;

/**
 * Controlador base pels serveis REST dels recursos amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractIdentificableWithIdentificadorApiController<D extends IdentificableWithIdentificador<?>> extends AbstractIdentificableApiController<D, String> {

	@Autowired
	protected IdentificadorService identificadorService;

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		Identificador identificador = identificadorService.getOne(((UserSession)userSession).getI());
		return "identificador.id==" + identificador.getCodi();
	}

	@Override
	protected void completeDtoWithSession(D dto, Object userSession, boolean isNew) {
		Identificador identificador = identificadorService.getOne(((UserSession)userSession).getI());
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
	}

}
