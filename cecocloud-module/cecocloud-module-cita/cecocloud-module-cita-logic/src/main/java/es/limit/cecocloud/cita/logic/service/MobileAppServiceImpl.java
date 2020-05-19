/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppCita;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppEmpresa;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppFestiu;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHoraDisponible;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHorari;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPuntVenda;
import es.limit.cecocloud.cita.logic.api.exception.NotAvailableException;
import es.limit.cecocloud.cita.logic.api.service.MobileAppService;
import es.limit.cecocloud.cita.logic.helper.DisponibilitatHelper;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.cita.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.cita.persist.repository.CitaRepository;
import es.limit.cecocloud.cita.persist.repository.PuntVendaRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;
import es.limit.cecocloud.fact.persist.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei encarregat de gestionar les peticions de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class MobileAppServiceImpl implements MobileAppService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private PuntVendaRepository puntVendaRepository;
	@Autowired
	private CitaRepository citaRepository;
	@Autowired
	private DisponibilitatHelper disponibilitatHelper;

	@Override
	@Transactional(readOnly = true)
	public List<MobileAppEmpresa> empresaFind() {
		List<PuntVendaEntity> puntsVendaAmbCitaActiva = puntVendaRepository.findByEmbeddedCitaActivaTrue();
		List<EmpresaEntity> empresesAmbCitaActiva = puntVendaRepository.findEmpresesByEmbeddedCitaActivaTrue();
		List<MobileAppEmpresa> resposta = new ArrayList<MobileAppEmpresa>();
		if (!puntsVendaAmbCitaActiva.isEmpty()) {
			for (EmpresaEntity empresa: empresesAmbCitaActiva) {
				MobileAppEmpresa appEmpresa = new MobileAppEmpresa();
				appEmpresa.setIdentificadorCodi(empresa.getId().getIdentificadorCodi());
				appEmpresa.setCodi(empresa.getId().getCodi());
				appEmpresa.setNom(empresa.getEmbedded().getNomComercial());
				appEmpresa.setNif(empresa.getEmbedded().getNif());
				for (PuntVendaEntity puntVenda: puntsVendaAmbCitaActiva) {
					if (puntVenda.getEmpresa().getId().equals(empresa.getId())) {
						if (appEmpresa.getPuntsVenda() == null) {
							appEmpresa.setPuntsVenda(new ArrayList<MobileAppPuntVenda>());
						}
						MobileAppPuntVenda appPuntVenda = new MobileAppPuntVenda();
						appPuntVenda.setCodi(puntVenda.getId().getCodi());
						appPuntVenda.setNom(puntVenda.getEmbedded().getNom());
						appEmpresa.getPuntsVenda().add(appPuntVenda);
					}
				}
				resposta.add(appEmpresa);
			}
		}
		return resposta;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MobileAppFestiu> puntVendaFestiuFind(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			int any) throws EntityNotFoundException {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MobileAppHorari> puntVendaHorariFind(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			LocalDate data) throws EntityNotFoundException {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MobileAppHoraDisponible> puntVendaDisponibilitat(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			LocalDate data) throws EntityNotFoundException {
		Optional<PuntVendaEntity> puntVenda = puntVendaRepository.findById(
				new PuntVendaPk(
						identificadorCodi,
						empresaCodi,
						puntVendaCodi));
		log.debug("Càlcul de la disponibilitat de cites(" +
				"identificadorCodi=" + identificadorCodi + ", " + 
				"empresaCodi=" + empresaCodi + ", " + 
				"puntVendaCodi=" + puntVendaCodi + ", " + 
				"data=" + data + ")");
		return disponibilitatHelper.disponibilitat(puntVenda.get(), data);
	}

	@Override
	@Transactional
	public MobileAppCita create(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			MobileAppCita cita) throws NotAvailableException, EntityNotFoundException {
		Cita dto = new Cita();
		dto.setData(cita.getData());
		dto.setNom(cita.getNom());
		dto.setLlinatges(cita.getLlinatges());
		dto.setTelefon(cita.getTelefon());
		dto.setEmail(cita.getEmail());
		CitaPk pk = new CitaPk(
				identificadorCodi,
				empresaCodi,
				puntVendaCodi,
				0);
		WithIdentificadorAndCodiPk<String> empresaPk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				empresaCodi);
		Optional<EmpresaEntity> empresa = empresaRepository.findById(empresaPk);
		PuntVendaPk puntVendaPk = new PuntVendaPk(
				identificadorCodi,
				empresaCodi,
				puntVendaCodi);
		Optional<PuntVendaEntity> puntVenda = puntVendaRepository.findById(puntVendaPk);
		CitaEntity saved = citaRepository.save(CitaEntity.builder().
				pk(pk).
				embedded(dto).
				empresa(empresa.get()).
				puntVenda(puntVenda.get()).
				build());
		MobileAppCita resposta = new MobileAppCita();
		resposta.setCodi(saved.getEmbedded().getCodi());
		resposta.setData(saved.getEmbedded().getData());
		MobileAppEmpresa mobileEmpresa = new MobileAppEmpresa();
		mobileEmpresa.setIdentificadorCodi(identificadorCodi);
		mobileEmpresa.setCodi(empresaCodi);
		mobileEmpresa.setNif(empresa.get().getEmbedded().getNif());
		mobileEmpresa.setNom(empresa.get().getEmbedded().getNomComercial());
		resposta.setEmpresa(mobileEmpresa);
		MobileAppPuntVenda mobilePuntVenda = new MobileAppPuntVenda();
		mobilePuntVenda.setCodi(puntVendaCodi);
		mobilePuntVenda.setNom(puntVenda.get().getEmbedded().getNom());
		resposta.setPuntVenda(mobilePuntVenda);
		return resposta;
	}

	@Override
	@Transactional
	public void cancel(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			String codi) throws EntityNotFoundException {
		CitaEntity cita = getCitaFromCodi(
				identificadorCodi,
				empresaCodi,
				puntVendaCodi,
				codi);
		cita.getEmbedded().setAnulacioData(LocalDateTime.now());
	}

	private CitaEntity getCitaFromCodi(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			String codi) {
		CitaPk pk = CitaEntity.fromCodiToPk(codi);
		if (	pk.getIdentificadorCodi().equals(identificadorCodi) &&
				pk.getEmpresaCodi().equals(empresaCodi) &&
				pk.getPuntVendaCodi().equals(puntVendaCodi)) {
			return citaRepository.findById(pk).get();
		} else {
			throw new EntityNotFoundException();
		}
	}

}
