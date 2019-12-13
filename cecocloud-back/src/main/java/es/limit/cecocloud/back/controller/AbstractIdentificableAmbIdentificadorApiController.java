/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.IdentificableAmbIdentificador;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public class AbstractIdentificableAmbIdentificadorApiController<D extends IdentificableAmbIdentificador<ID>, ID extends Serializable> extends AbstractIdentificableApiController<D, ID> {

	@Override
	protected void completeDtoWithSession(D dto, Object userSession) {
		dto.setIdentificador(GenericReference.toGenericReference(((UserSession)userSession).getI()));
	}

}
