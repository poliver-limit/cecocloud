/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.cita.logic.api.dto.MobileAppCita;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppEmpresa;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppFestiu;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHoraDisponible;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHorari;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppPuntVenda;
import es.limit.cecocloud.cita.logic.api.exception.NotAvailableException;
import es.limit.cecocloud.cita.logic.api.service.MobileAppService;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;
import es.limit.cecocloud.cita.persist.repository.CitaRepository;
import es.limit.cecocloud.cita.persist.repository.HorariIntervalRepository;
import es.limit.cecocloud.cita.persist.repository.HorariRepository;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.fact.persist.repository.PuntVendaRepository;

/**
 * Implementació del servei encarregat de gestionar les peticions de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MobileAppServiceImpl implements MobileAppService {

	@Autowired
	private PuntVendaRepository puntVendaRepository;
	@Autowired
	private CitaRepository citaRepository;
	@Autowired
	private HorariRepository horariRepository;
	@Autowired
	private HorariIntervalRepository horariIntervalRepository;

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
					if (puntVenda.getEmpresa().equals(empresa)) {
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
		List<MobileAppHoraDisponible> resposta = new ArrayList<MobileAppHoraDisponible>();
		if (isCitaActivaForDate(puntVenda.get(), data)) {
			List<HorariIntervalEntity> intervalsHorariActual = getHorariIntervals(puntVenda.get(), data);
			if (intervalsHorariActual != null && !intervalsHorariActual.isEmpty()) {
				int intervalMinuts = puntVenda.get().getEmbedded().getCitaIntervalMinuts() != null ? puntVenda.get().getEmbedded().getCitaIntervalMinuts() : 5;
				int numPlaces = puntVenda.get().getEmbedded().getCitaNumPlaces() != null ? puntVenda.get().getEmbedded().getCitaNumPlaces() : 1;
				for (HorariIntervalEntity horariInterval: intervalsHorariActual) {
					LocalTime hora = horariInterval.getEmbedded().getHoraInici();
					do {
						MobileAppHoraDisponible horaDisponible = new MobileAppHoraDisponible();
						horaDisponible.setHora(hora);
						horaDisponible.setDuradaEnMinuts(intervalMinuts);
						horaDisponible.setPlaces(numPlaces);
						resposta.add(horaDisponible);
						hora.plusMinutes(intervalMinuts);
					} while (hora.compareTo(horariInterval.getEmbedded().getHoraFi()) < 0);
				}
				
			}
			List<CitaEntity> citesMateixaData = citaRepository.findByPuntVendaAndEmbeddedDataBetweenSortByEmbeddedData(
					puntVenda.get(),
					data.atStartOfDay(),
					data.atTime(23, 59, 59));
			for (CitaEntity cita: citesMateixaData) {
				LocalTime citaHora = cita.getEmbedded().getData().toLocalTime();
				for (MobileAppHoraDisponible horaDisponible: resposta) {
					if (citaHora.truncatedTo(ChronoUnit.MINUTES).equals(horaDisponible.getHora().truncatedTo(ChronoUnit.MINUTES))) {
						if (horaDisponible.getPlaces() > 0) {
							horaDisponible.setPlaces(horaDisponible.getPlaces() - 1);
						}
					}
				}
			}
		}
		return resposta.stream().filter(h -> h.getPlaces() > 0).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public MobileAppCita create(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			MobileAppCita cita) throws NotAvailableException, EntityNotFoundException {
		return null;
	}

	private boolean isCitaActivaForDate(
			PuntVendaEntity puntVenda,
			LocalDate date) {
		LocalDate dataInici = puntVenda.getEmbedded().getCitaDataInici();
		LocalDate dataFi = puntVenda.getEmbedded().getCitaDataFi();
		return	dataInici == null ||
				(dataInici != null && dataFi == null && (date.equals(dataInici) || date.isAfter(dataInici))) ||
				(dataInici != null && dataFi != null && (date.equals(dataInici) || date.equals(dataFi) || (date.isAfter(dataInici) && date.isBefore(dataFi))));
	}

	private List<HorariIntervalEntity> getHorariIntervals(
			PuntVendaEntity puntVenda,
			LocalDate date) {
		List<HorariEntity> horaris = horariRepository.findByPuntVenda(puntVenda);
		HorariEntity horariActiu = null;
		for (HorariEntity horari: horaris) {
			LocalDate dataInici = horari.getEmbedded().getDataInici();
			LocalDate dataFi = horari.getEmbedded().getDataFi();
			if ((date.isEqual(dataInici) || date.isAfter(dataInici)) && (date.isEqual(dataFi) || date.isBefore(dataFi))) {
				horariActiu = horari;
				break;
			}
		}
		if (horariActiu != null) {
			List<HorariIntervalEntity> horariIntervals = horariIntervalRepository.findByHorari(horariActiu);
			horariIntervals.sort(new Comparator<HorariIntervalEntity>() {
				@Override
				public int compare(HorariIntervalEntity o1, HorariIntervalEntity o2) {
					return o1.getEmbedded().getHoraInici().compareTo(o2.getEmbedded().getHoraInici());
				}
			});
			return horariIntervals;
		} else {
			return null;
		}
	}

}
