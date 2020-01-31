/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador;
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
	private IdentificadorService identificadorService;

	@Override
	protected void completeDtoWithSession(D dto, Object userSession) {
		Identificador identificador = identificadorService.getOne(((UserSession)userSession).getI());
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
	}

}
