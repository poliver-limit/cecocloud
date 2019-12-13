/**
 * 
 */
package es.limit.cecocloud.back.generic.controller;

import java.io.Serializable;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.generic.dto.IdentificableAmbIdentificador;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractIdentificableAmbIdentificadorApiController<D extends IdentificableAmbIdentificador<ID>, ID extends Serializable> extends AbstractIdentificableApiController<D, ID> {

	@Override
	protected void completeDtoWithSession(D dto, Object userSession) {
		dto.setIdentificador(GenericReference.toGenericReference(((UserSession)userSession).getI()));
	}
	
	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		return "identificador.id==" + ((UserSession)userSession).getI();
	}

}
