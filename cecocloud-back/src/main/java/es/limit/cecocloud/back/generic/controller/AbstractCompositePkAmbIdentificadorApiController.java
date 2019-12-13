/**
 * 
 */
package es.limit.cecocloud.back.generic.controller;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.generic.dto.CompositePkAmbIdentificador;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractCompositePkAmbIdentificadorApiController<D extends CompositePkAmbIdentificador<?>> extends AbstractIdentificableApiController<D, String> {

	@Override
	protected void completeDtoWithSession(D dto, Object userSession) {
		dto.setIdentificador(GenericReference.toGenericReference(((UserSession)userSession).getI()));
	}
	
	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		return "identificador.id==" + ((UserSession)userSession).getI();
	}

}
