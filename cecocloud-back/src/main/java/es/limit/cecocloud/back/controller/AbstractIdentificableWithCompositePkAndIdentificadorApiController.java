/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.io.Serializable;

import es.limit.base.boot.back.controller.AbstractIdentificableWithCompositePkApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.IdentificableWithCompositePkAndIdentificador;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador base pels serveis REST dels recursos amb clau primària composta
 * i identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractIdentificableWithCompositePkAndIdentificadorApiController<D extends IdentificableWithCompositePkAndIdentificador<? extends Serializable>> extends AbstractIdentificableWithCompositePkApiController<D> {

	@Override
	protected void completeDtoWithSession(D dto, Object userSession, boolean isNew) {
		dto.setIdentificador(GenericReference.toGenericReference(((UserSession)userSession).getI()));
	}

	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		return "identificador.id==" + ((UserSession)userSession).getI();
	}

}
