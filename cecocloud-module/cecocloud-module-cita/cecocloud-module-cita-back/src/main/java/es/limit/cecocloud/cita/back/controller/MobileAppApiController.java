/**
 * 
 */
package es.limit.cecocloud.cita.back.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.cita.logic.api.dto.MobileAppCita;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppEmpresa;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppFestiu;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHoraDisponible;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHorari;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPeticioAnulacio;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPeticioCita;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPeticioDisponibilitat;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPeticioFestius;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPeticioHoraris;
import es.limit.cecocloud.cita.logic.api.module.CitaModule;
import es.limit.cecocloud.cita.logic.api.service.MobileAppService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de l'aplicació mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController
@RequestMapping(CitaModule.API_PATH + "/mobile")
public class MobileAppApiController {

	@Autowired
	private MobileAppService mobileAppService;

	@GetMapping(
			path = "/empreses",
			produces = "application/json")
	public ResponseEntity<List<MobileAppEmpresa>> empresaFind(
			HttpServletRequest request) {
		log.debug("Consulta d'empreses amb sol·licitud de cita activada");
		return ResponseEntity.ok(mobileAppService.empresaFind());
	}

	@GetMapping(
			path = "/puntVenda/festius",
			produces = "application/json")
	public ResponseEntity<List<MobileAppFestiu>> puntVendaFestius(
			HttpServletRequest request,
			@Valid final MobileAppPeticioFestius peticio) {
		log.debug("Consulta de festius d'un punt de venda per a un any determinat (" +
				"identificadorCodi=" + peticio.getIdentificadorCodi() + ", " +
				"empresaCodi=" + peticio.getEmpresaCodi() + ", " +
				"puntVendaCodi=" + peticio.getPuntVendaCodi() + ", " +
				"any=" + peticio.getAny() + ")");
		try {
			return ResponseEntity.ok(mobileAppService.puntVendaFestiuFind(
					peticio.getIdentificadorCodi(),
					peticio.getEmpresaCodi(),
					peticio.getPuntVendaCodi(),
					peticio.getAny()));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(
			path = "/puntVenda/horaris",
			produces = "application/json")
	public ResponseEntity<List<MobileAppHorari>> puntVendaHoraris(
			HttpServletRequest request,
			@Valid final MobileAppPeticioHoraris peticio) {
		log.debug("Consulta d'horaris d'un punt de venda per a una data determinada (" +
				"identificadorCodi=" + peticio.getIdentificadorCodi() + ", " +
				"empresaCodi=" + peticio.getEmpresaCodi() + ", " +
				"puntVendaCodi=" + peticio.getPuntVendaCodi() + ", " +
				"data=" + peticio.getData() + ")");
		try {
			return ResponseEntity.ok(mobileAppService.puntVendaHorariFind(
					peticio.getIdentificadorCodi(),
					peticio.getEmpresaCodi(),
					peticio.getPuntVendaCodi(),
					peticio.getData()));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(
			path = "/puntVenda/disponibilitat",
			produces = "application/json")
	public ResponseEntity<List<MobileAppHoraDisponible>> puntVendaDisponibilitat(
			HttpServletRequest request,
			@Valid final MobileAppPeticioDisponibilitat peticio) {
		log.debug("Consulta de la disponibilitat d'hores d'un punt de venda per a una data determinada (" +
				"identificadorCodi=" + peticio.getIdentificadorCodi() + ", " +
				"empresaCodi=" + peticio.getEmpresaCodi() + ", " +
				"puntVendaCodi=" + peticio.getPuntVendaCodi() + ", " +
				"data=" + peticio.getData() + ")");
		try {
			return ResponseEntity.ok(mobileAppService.puntVendaDisponibilitat(
					peticio.getIdentificadorCodi(),
					peticio.getEmpresaCodi(),
					peticio.getPuntVendaCodi(),
					peticio.getData()));
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(
			produces = "application/json")
	public ResponseEntity<MobileAppCita> create(
			HttpServletRequest request,
			@RequestBody @Valid final MobileAppPeticioCita peticio) {
		log.debug("Petició de creació de cita (" +
				"identificadorCodi=" + peticio.getIdentificadorCodi() + ", " +
				"empresaCodi=" + peticio.getEmpresaCodi() + ", " +
				"puntVendaCodi=" + peticio.getPuntVendaCodi() + ", " +
				"cita=" + peticio.getCita() + ")");
		try {
			MobileAppCita cita = mobileAppService.create(
					peticio.getIdentificadorCodi(),
					peticio.getEmpresaCodi(),
					peticio.getPuntVendaCodi(),
					peticio.getCita());
			return ResponseEntity.ok(cita);
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(
			produces = "application/json")
	public ResponseEntity<?> cancel(
			HttpServletRequest request,
			@RequestBody @Valid final MobileAppPeticioAnulacio peticio) {
		log.debug("Petició de creació de cita (" +
				"identificadorCodi=" + peticio.getIdentificadorCodi() + ", " +
				"empresaCodi=" + peticio.getEmpresaCodi() + ", " +
				"puntVendaCodi=" + peticio.getPuntVendaCodi() + ", " +
				"codi=" + peticio.getCodi() + ")");
		try {
			mobileAppService.cancel(
					peticio.getIdentificadorCodi(),
					peticio.getEmpresaCodi(),
					peticio.getPuntVendaCodi(),
					peticio.getCodi());
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

}
