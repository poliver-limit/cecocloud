/**
 * 
 */
package es.limit.cecocloud.cita.back.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaRangHorari;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaRangHorariRequest;
import es.limit.cecocloud.cita.logic.api.module.CitaModule;
import es.limit.cecocloud.cita.logic.api.service.PuntVendaService;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorAndEmpresaApiController;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorApiController;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de punts de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController("citaPuntVendaApiController")
@RequestMapping(CitaModule.API_PATH + "/puntVendes")
public class PuntVendaApiController extends AbstractIdentificableWithIdentificadorApiController<PuntVenda> {

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
	protected void completeDtoWithSession(PuntVenda dto, Object userSession, boolean isNew) {
		super.completeDtoWithSession(dto, userSession, isNew);
		dto.setEmpresa(
				AbstractIdentificableWithIdentificadorAndEmpresaApiController.getEmpresaGenericReferenceFromSession(
						empresaService,
						dto,
						userSession));
	}

	@GetMapping(value = "/{resourceId}/rangHorari")
	@PreAuthorize("hasPermission(#resourceId, this.getDtoClassName(), 'READ')")
	public ResponseEntity<PuntVendaRangHorari> rangHorari(
			HttpServletRequest request,
			@PathVariable final String resourceId,
			@Valid final PuntVendaRangHorariRequest rangHorariRequest) {
		log.debug("Consultant rang horari (" +
				"resourceId=" + resourceId + ")");
		try {
			return ResponseEntity.ok(
					((PuntVendaService)getService()).getRangHorari(resourceId, rangHorariRequest));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

}
