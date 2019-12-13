/**
 * 
 */
package es.limit.cecocloud.back.generic.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithPermissionsApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.generic.dto.IdentificableAmbIdentificador;

/**
 * Mètodes bàsics per als controladors REST que gestionen entitats
 * que depenen d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public abstract class AbstractIdentificableAmbIdentificadorWithPermissionsApiController<D extends IdentificableAmbIdentificador<ID>, ID extends Serializable> extends AbstractIdentificableWithPermissionsApiController<D, ID> {

	@Override
	protected void completeDtoWithSession(D dto, Object userSession) {
		dto.setIdentificador(GenericReference.toGenericReference(((UserSession)userSession).getI()));
	}
	
	@Override
	protected String additionalRsqlFilterFromSession(Object userSession) {
		return "identificador.id==" + ((UserSession)userSession).getI();
	}

}
