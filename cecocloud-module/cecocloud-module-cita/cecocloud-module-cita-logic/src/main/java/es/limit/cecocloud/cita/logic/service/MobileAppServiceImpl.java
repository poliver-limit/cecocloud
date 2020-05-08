/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;
import es.limit.cecocloud.cita.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.cita.persist.repository.CitaRepository;
import es.limit.cecocloud.cita.persist.repository.HorariIntervalRepository;
import es.limit.cecocloud.cita.persist.repository.HorariRepository;
import es.limit.cecocloud.cita.persist.repository.PuntVendaRepository;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;

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
		List<MobileAppHoraDisponible> horesDisponibles = new ArrayList<MobileAppHoraDisponible>();
		if (isCitaActiva(puntVenda.get())) {
			int intervalMinuts = puntVenda.get().getEmbedded().getCitaIntervalMinuts() != null ? puntVenda.get().getEmbedded().getCitaIntervalMinuts() : 5;
			int numPlaces = puntVenda.get().getEmbedded().getCitaNumPlaces() != null ? puntVenda.get().getEmbedded().getCitaNumPlaces() : 1;
			List<HorariIntervalEntity> intervalsHorariActual = getHorariIntervals(puntVenda.get(), data);
			if (intervalsHorariActual != null && !intervalsHorariActual.isEmpty()) {
				for (HorariIntervalEntity horariInterval: intervalsHorariActual) {
					LocalTime hora = horariInterval.getEmbedded().getHoraInici();
					do {
						MobileAppHoraDisponible horaDisponible = new MobileAppHoraDisponible();
						horaDisponible.setHora(hora);
						horaDisponible.setDuradaEnMinuts(intervalMinuts);
						horaDisponible.setPlaces(numPlaces);
						horesDisponibles.add(horaDisponible);
						hora.plusMinutes(intervalMinuts);
					} while (hora.compareTo(horariInterval.getEmbedded().getHoraFi()) < 0);
				}
			}
			List<CitaEntity> citesConfirmades = citaRepository.findByPuntVendaAndEmbeddedDataBetweenAndAnulacioDataNullSortByEmbeddedData(
					puntVenda.get(),
					data.atStartOfDay(),
					data.atTime(23, 59, 59));
			// Es verifica si s'han donat totes les cites possibles per aquesta
			// data
			if (citesConfirmades.size() < horesDisponibles.size() * numPlaces) {
				// Si entra aquí vol dir que encara no s'han donat totes les
				// cites disponibles per aquesta data
				for (CitaEntity cita: citesConfirmades) {
					// Cerca la hora disponible que coincideix amb l'hora de la
					// cita
					MobileAppHoraDisponible horaDisponibleIgual = null;
					LocalTime citaHora = cita.getEmbedded().getData().toLocalTime();
					for (MobileAppHoraDisponible horaDisponible: horesDisponibles) {
						if (citaHora.truncatedTo(ChronoUnit.MINUTES).equals(horaDisponible.getHora().truncatedTo(ChronoUnit.MINUTES))) {
							horaDisponibleIgual = horaDisponible;
							break;
						}
					}
					MobileAppHoraDisponible horaDisponibleSeleccionada = null;
					if (horaDisponibleIgual != null && horaDisponibleIgual.getPlaces() > 0) {
						horaDisponibleSeleccionada = horaDisponibleIgual;
					} else {
						// Si no hi ha cap hora disponible que coincideixi amb
						// l'hora de la cita es selecciona l'hora disponible
						// més aprop amb places.
						long distanciaMinima = Long.MAX_VALUE;
						for (MobileAppHoraDisponible horaDisponible: horesDisponibles) {
							if (horaDisponible.getPlaces() > 0) {
								long distancia = citaHora.truncatedTo(ChronoUnit.MINUTES).until(horaDisponible.getHora().truncatedTo(ChronoUnit.MINUTES), ChronoUnit.MINUTES);
								if (distancia < distanciaMinima) {
									horaDisponibleSeleccionada = horaDisponible;
								}
							}
						}
					}
					// Decrementar el nombre de places disponibles de l'hora
					// seleccionada
					horaDisponibleSeleccionada.setPlaces(horaDisponibleSeleccionada.getPlaces() - 1);
				}
			} else {
				// Si entra aquí vol dir que ja s'han donat totes les cites
				// disponibles per aquesta data
				horesDisponibles.clear();
			}
		}
		return horesDisponibles.stream().filter(h -> h.getPlaces() > 0).collect(Collectors.toList());
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
		CitaPk pk = new CitaPk(
				identificadorCodi,
				empresaCodi,
				puntVendaCodi,
				0);
		CitaEntity saved = citaRepository.save(CitaEntity.builder().
				pk(pk).
				embedded(dto).
				build());
		MobileAppCita resposta = new MobileAppCita();
		resposta.setCodi(saved.getEmbedded().getCodi());
		resposta.setData(saved.getEmbedded().getData());
		MobileAppEmpresa empresa = new MobileAppEmpresa();
		empresa.setIdentificadorCodi(saved.getId().getIdentificadorCodi());
		empresa.setCodi(saved.getEmpresa().getEmbedded().getCodi());
		empresa.setNif(saved.getEmpresa().getEmbedded().getNif());
		empresa.setNom(saved.getEmpresa().getEmbedded().getNomComercial());
		resposta.setEmpresa(empresa);
		MobileAppPuntVenda puntVenda = new MobileAppPuntVenda();
		puntVenda.setCodi(saved.getPuntVenda().getEmbedded().getCodi());
		puntVenda.setNom(saved.getPuntVenda().getEmbedded().getNom());
		resposta.setPuntVenda(puntVenda);
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

	private boolean isCitaActiva(PuntVendaEntity puntVenda) {
		return puntVenda.getEmbedded().getCitaActiva() != null && puntVenda.getEmbedded().getCitaActiva();
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
