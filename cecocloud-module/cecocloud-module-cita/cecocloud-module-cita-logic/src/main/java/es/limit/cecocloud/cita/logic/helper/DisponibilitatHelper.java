/**
 * 
 */
package es.limit.cecocloud.cita.logic.helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.cita.logic.api.dto.MobileAppHoraDisponible;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.cita.persist.entity.FestiuEntity;
import es.limit.cecocloud.cita.persist.entity.FestiuGrupEntity;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;
import es.limit.cecocloud.cita.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.cita.persist.repository.CitaRepository;
import es.limit.cecocloud.cita.persist.repository.FestiuRepository;
import es.limit.cecocloud.cita.persist.repository.HorariIntervalRepository;
import es.limit.cecocloud.cita.persist.repository.HorariRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Helper per a calcular la disponibilitat de cites.
 * 
 * @author Limit Tecnologies
 */
@Slf4j
@Component
public class DisponibilitatHelper {

	@Autowired
	private FestiuRepository festiuRepository;
	@Autowired
	private HorariRepository horariRepository;
	@Autowired
	private HorariIntervalRepository horariIntervalRepository;
	@Autowired
	private CitaRepository citaRepository;

	public List<MobileAppHoraDisponible> disponibilitat(
			PuntVendaEntity puntVenda,
			LocalDate data) throws EntityNotFoundException {
		if (isCitaActiva(puntVenda)) {
			if (!isFestiu(puntVenda, data)) {
				List<MobileAppHoraDisponible> horesDisponibles = new ArrayList<MobileAppHoraDisponible>();
				int intervalMinuts = puntVenda.getEmbedded().getCitaIntervalMinuts() != null ? puntVenda.getEmbedded().getCitaIntervalMinuts() : 5;
				int numPlaces = puntVenda.getEmbedded().getCitaNumPlaces() != null ? puntVenda.getEmbedded().getCitaNumPlaces() : 1;
				List<HorariIntervalEntity> intervalsHorariActual = getHorariIntervals(puntVenda, data, true);
				if (intervalsHorariActual != null && !intervalsHorariActual.isEmpty()) {
					boolean esAvui = data.isEqual(LocalDate.now());
					for (HorariIntervalEntity horariInterval: intervalsHorariActual) {
						log.debug("    Generant hores disponibles de l'interval " + horariInterval.getEmbedded().getHoraInici() + " - " + horariInterval.getEmbedded().getHoraFi());
						LocalTime hora = horariInterval.getEmbedded().getHoraInici();
						int tamanyInicial = horesDisponibles.size();
						do {
							if (!esAvui || hora.isAfter(LocalTime.now())) {
								MobileAppHoraDisponible horaDisponible = new MobileAppHoraDisponible();
								horaDisponible.setHora(hora);
								horaDisponible.setDuradaEnMinuts(intervalMinuts);
								horaDisponible.setPlaces(numPlaces);
								horesDisponibles.add(horaDisponible);
							}
							hora = hora.plusMinutes(intervalMinuts);
						} while (hora.compareTo(horariInterval.getEmbedded().getHoraFi()) < 0);
						log.debug("    L'interval " + horariInterval.getEmbedded().getHoraInici() + " - " + horariInterval.getEmbedded().getHoraFi() + " ha generat un total de " + (horesDisponibles.size() - tamanyInicial) + " hores disponibles");
					}
				}
				log.debug("    Total d'hores disponibles generades per a tots els intervals: " + horesDisponibles.size());
				List<CitaEntity> citesConfirmades = citaRepository.findByPuntVendaAndEmbeddedDataBetweenAndAnulacioDataNullSortByEmbeddedData(
						puntVenda,
						data.atStartOfDay(),
						data.atTime(23, 59, 59));
				log.debug("    Processant " + citesConfirmades.size() + " cites confirmades");
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
					log.debug("    Ja s'han donades totes les hores disponibles");
					horesDisponibles.clear();
				}
				List<MobileAppHoraDisponible> horesFinals = horesDisponibles.stream().filter(h -> h.getPlaces() > 0).collect(Collectors.toList());
				log.debug("    Després de processar les cites ja donades s'han eliminat un total de " + (horesDisponibles.size() - horesFinals.size()) + " hores disponibles");
				log.debug("    Retornant " + horesFinals.size() + " hores disponibles");
				for (MobileAppHoraDisponible horaDisponible: horesDisponibles) {
					log.debug("        " + horaDisponible.getHora() + " (" + horaDisponible.getDuradaEnMinuts() + " min, " + horaDisponible.getPlaces() + " places)");
				}
				return horesFinals;
			} else {
				// Si entra aquí vol dir que la data cau en dia festiu
				log.debug("    El dia " + data + " és festiu");
			}
		}
		return new ArrayList<MobileAppHoraDisponible>();
	}

	public List<HorariIntervalEntity> getHorariIntervals(
			PuntVendaEntity puntVenda,
			LocalDate data,
			boolean comprovarDataPosteriorActual) {
		List<HorariEntity> horaris = horariRepository.findByPuntVenda(puntVenda);
		HorariEntity horariActiu = null;
		for (HorariEntity horari: horaris) {
			LocalDate dataInici = horari.getEmbedded().getDataInici();
			LocalDate dataFi = horari.getEmbedded().getDataFi();
			if ((data.isEqual(dataInici) || data.isAfter(dataInici)) && (data.isEqual(dataFi) || data.isBefore(dataFi))) {
				horariActiu = horari;
				break;
			}
		}
		boolean dataCorrecta = true;
		if (comprovarDataPosteriorActual) {
			dataCorrecta = !data.isBefore(LocalDate.now());
		}
		if (horariActiu != null && dataCorrecta) {
			// Només es retornen intervals si hi ha un horari actiu i si la data
			// de la disponibilitat no és anterior a la data d'avui.
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

	private boolean isCitaActiva(PuntVendaEntity puntVenda) {
		return puntVenda.getEmbedded().getCitaActiva() != null && puntVenda.getEmbedded().getCitaActiva();
	}

	private boolean isFestiu(
			PuntVendaEntity puntVenda,
			LocalDate data) {
		boolean isFestiu = false;
		int anyActual = LocalDate.now().getYear();
		FestiuGrupEntity festiuGrup = puntVenda.getFestiuGrup();
		List<FestiuEntity> festius = festiuRepository.findByFestiuGrup(festiuGrup);
		for (FestiuEntity festiu: festius) {
			Integer festiuAny = festiu.getEmbedded().getAny();
			if (festiuAny == null || festiuAny.equals(LocalDate.now().getYear())) {
				LocalDate festiuDiaMes = festiu.getEmbedded().getDiaMes();
				if (data.isEqual(festiuDiaMes.withYear(anyActual))) {
					isFestiu = true;
					break;
				}
			}
		}
		return isFestiu;
	}

}
