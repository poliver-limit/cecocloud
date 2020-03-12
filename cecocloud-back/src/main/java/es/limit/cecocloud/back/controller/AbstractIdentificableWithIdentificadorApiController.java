/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.cecocloud.logic.api.dto.IdentificableWithIdentificador;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador base pels serveis REST dels recursos amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractIdentificableWithIdentificadorApiController<D extends IdentificableWithIdentificador<ID>, ID extends Serializable> extends AbstractIdentificableApiController<D, ID> {

	@Override
	protected void completeDtoWithSession(D dto, Object userSession, boolean isNew) {
		dto.setIdentificador(GenericReference.toGenericReference(((UserSession)userSession).getI()));
	}

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return "identificador.id==" + ((UserSession)userSession).getI();
	}

}
