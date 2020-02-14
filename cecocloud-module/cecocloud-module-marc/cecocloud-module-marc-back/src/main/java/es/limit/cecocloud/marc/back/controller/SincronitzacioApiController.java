/**
 * 
 */
package es.limit.cecocloud.marc.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatgesConsulta;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatgesEnviament;
import es.limit.cecocloud.marc.logic.api.module.MarcModule;
import es.limit.cecocloud.marc.logic.api.service.SincronitzacioService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de sincronització d'informació de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController("marcSincronitzacioApiController")
@RequestMapping(MarcModule.API_PATH + "/sync")
public class SincronitzacioApiController {

	@Autowired
	private SincronitzacioService sincronitzacioService;

	@GetMapping(
			path = "/marcatges/empreses",
			produces = "application/json")
	@PreAuthorize("hasPermission(getCompanyia(#consulta.companyiaCodi), 'SYNC')")
	public ResponseEntity<List<SincronitzacioEmpresa>> consultaEmpreses(
			HttpServletRequest request) {
		log.debug("Consulta d'empreses");
		return ResponseEntity.ok(
				sincronitzacioService.empresaFind());
	}

	@GetMapping(
			path = "/marcatges",
			produces = "application/json")
	@PreAuthorize("hasPermission(getCompanyia(#consulta.companyiaCodi), 'SYNC')")
	public ResponseEntity<List<SincronitzacioMarcatge>> consultaMarcatges(
			HttpServletRequest request,
			@Valid final SincronitzacioMarcatgesConsulta consulta) {
		log.debug("Consulta de marcatges (" +
				"consulta=" + consulta + ")");
		return ResponseEntity.ok(
				sincronitzacioService.marcatgeFind(
						consulta.getIdentificadorCodi(),
						consulta.getDataInici(),
						consulta.getDataFi()));
	}

	@PostMapping(
			path = "/marcatges",
			produces = "application/json")
	@PreAuthorize("hasPermission(getCompanyia(#marcatges.companyiaCodi), 'SYNC')")
	public ResponseEntity<SincronitzacioResposta> sincronitzarMarcatges(
			HttpServletRequest request,
			@RequestBody @Valid final SincronitzacioMarcatgesEnviament marcatges) {
		log.debug("Enviament de marcatges (" +
				"marcatges=" + marcatges + ")");
		return ResponseEntity.ok(
				sincronitzacioService.marcatgeCreate(
						marcatges.getIdentificadorCodi(),
						marcatges.getMarcatges()));
	}

}
