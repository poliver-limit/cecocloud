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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.ApiControllerHelper;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.service.CompanyiaService;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioCompanyia;
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
	public ResponseEntity<SincronitzacioResposta> sincronitzarEmpresesOperaris(
			HttpServletRequest request,
			@RequestBody @Valid final SincronitzacioCompanyia dto) {
		log.debug("Nova sincronització(" +
				"dto=" + dto + ")");
		SincronitzacioResposta resposta = sincronitzacioService.sincronitzar(
				getCompanyiaId(dto.getCompanyiaCodi()),
				dto.getEmpreses());
		return ResponseEntity.ok(resposta);
	}

	@GetMapping(
			path = "/marcatges",
			produces = "application/json")
	public ResponseEntity<List<SincronitzacioMarcatge>> consultaMarcatges(
			HttpServletRequest request,
			@Valid final SincronitzacioMarcatgesConsulta consulta) {
		log.debug("Consulta de marcatges (" +
				"consulta=" + consulta + ")");
		List<SincronitzacioMarcatge> marcatges = sincronitzacioService.marcatgeFind(
				getCompanyiaId(consulta.getCompanyiaCodi()),
				consulta.getEmpreses(),
				consulta.getDataInici(),
				consulta.getDataFi());
		return ResponseEntity.ok(marcatges);
	}

	@PostMapping(
			path = "/marcatges",
			produces = "application/json")
	public ResponseEntity<SincronitzacioResposta> sincronitzarMarcatges(
			HttpServletRequest request,
			@RequestBody @Valid final SincronitzacioMarcatgesEnviament marcatges) {
		log.debug("Enviament de marcatges (" +
				"marcatges=" + marcatges + ")");
		SincronitzacioResposta resposta = sincronitzacioService.marcatgeCreate(
				getCompanyiaId(marcatges.getCompanyiaCodi()),
				marcatges.getMarcatges());
		return ResponseEntity.ok(resposta);
	}

	private Long getCompanyiaId(String companyiaCodi) {
		Companyia companyia = companyiaService.findOneByRsqlQuery("codi==" + companyiaCodi);
		if (companyia != null) {
			return companyia.getId();
		} else {
			throw new EntityNotFoundException("Companyia amb codi " + companyiaCodi);
		}
	}

}
