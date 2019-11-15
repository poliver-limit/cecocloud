/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
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

import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.service.CompanyiaService;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioCompanyia;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioCompanyiaResposta;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatgesConsulta;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatgesEnviament;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marcatges.logic.api.service.SincronitzacioService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de sincronització d'informació de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(ApiControllerHelper.API_PATH + "/sync")
public class SincronitzacioApiController {

	@Autowired
	private SincronitzacioService sincronitzacioService;
	@Autowired
	private CompanyiaService companyiaService;

	@PostMapping(
			path = "/empreses_operaris",
			produces = "application/json")
	@PreAuthorize("hasPermission(getCompanyia(#dto.companyiaCodi), 'SYNC')")
	public ResponseEntity<SincronitzacioCompanyiaResposta> sincronitzarEmpresesOperaris(
			HttpServletRequest request,
			@RequestBody @Valid final SincronitzacioCompanyia dto) {
		log.debug("Nova sincronització(" +
				"dto=" + dto + ")");
		Companyia companyia = getCompanyia(dto.getCompanyiaCodi());
		SincronitzacioResposta identificadorsResposta = sincronitzacioService.sincronitzarIdentificadors(
				companyia.getId(),
				dto.getIdentificadors());
		SincronitzacioResposta empresesResposta = sincronitzacioService.sincronitzarEmpreses(
				companyia.getId(),
				dto.getEmpreses());
		SincronitzacioResposta operarisResposta = sincronitzacioService.sincronitzarOperaris(
				companyia.getId(),
				dto.getOperaris());
		return ResponseEntity.ok(
				new SincronitzacioCompanyiaResposta(
						identificadorsResposta,
						empresesResposta,
						operarisResposta));
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
		List<SincronitzacioMarcatge> marcatges = sincronitzacioService.marcatgeFind(
				getCompanyia(consulta.getCompanyiaCodi()).getId(),
				consulta.getEmpreses(),
				consulta.getDataInici(),
				consulta.getDataFi());
		return ResponseEntity.ok(marcatges);
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
		SincronitzacioResposta resposta = sincronitzacioService.marcatgeCreate(
				getCompanyia(marcatges.getCompanyiaCodi()).getId(),
				marcatges.getMarcatges());
		return ResponseEntity.ok(resposta);
	}

	private Companyia getCompanyia(String companyiaCodi) {
		Companyia companyia = companyiaService.findOneByRsqlQuery("codi==" + companyiaCodi);
		if (companyia != null) {
			return companyia;
		} else {
			throw new EntityNotFoundException("Companyia amb codi " + companyiaCodi);
		}
	}

}
