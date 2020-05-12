package es.limit.cecocloud.cita.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.module.CitaModule;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorAndEmpresaApiController;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorApiController;
import es.limit.cecocloud.logic.api.service.EmpresaService;

/**
 * Controlador per al servei REST de gestió de recursos de tipus cita.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(CitaModule.API_PATH + "/cites")
public class CitaApiController extends AbstractIdentificableWithIdentificadorApiController<Cita> {

	@Autowired
	protected EmpresaService empresaService;

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return AbstractIdentificableWithIdentificadorAndEmpresaApiController.staticAdditionalRsqlFilter(
				identificadorService,
				empresaService,
				userSession);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void completeDtoWithSession(Cita dto, Object userSession, boolean isNew) {
		super.completeDtoWithSession(dto, userSession, isNew);
		dto.setEmpresa(
				AbstractIdentificableWithIdentificadorAndEmpresaApiController.getEmpresaGenericReferenceFromSession(
						empresaService,
						dto,
						userSession));
	}

}
