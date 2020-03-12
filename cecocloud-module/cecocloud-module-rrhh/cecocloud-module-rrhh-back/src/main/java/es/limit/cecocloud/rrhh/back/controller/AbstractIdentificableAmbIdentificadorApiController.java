/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.rrhh.logic.api.dto.IdentificableWithIdentificador;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractIdentificableAmbIdentificadorApiController<D extends IdentificableWithIdentificador<?>> extends AbstractIdentificableApiController<D, String> {

	@Autowired
	private IdentificadorService identificadorService;

	@Override
	protected void completeDtoWithSession(D dto, Object userSession, boolean isNew) {
		Identificador identificador = identificadorService.getOne(((UserSession)userSession).getI());
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
	}

}
