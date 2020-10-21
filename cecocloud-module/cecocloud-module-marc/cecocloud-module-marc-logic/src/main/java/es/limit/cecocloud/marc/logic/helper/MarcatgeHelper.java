/**
 * 
 */
package es.limit.cecocloud.marc.logic.helper;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.marc.logic.api.dto.AcumulatInfo;
import es.limit.cecocloud.marc.logic.api.dto.Configuracio;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.persist.entity.ConfiguracioEntity;
import es.limit.cecocloud.marc.persist.entity.LlocFeinaEntity;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.repository.ConfiguracioRepository;
import es.limit.cecocloud.marc.persist.repository.LlocFeinaRepository;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * Funcionalitat comuna pels marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Component
public class MarcatgeHelper {

	@Autowired
	private ConfiguracioRepository configuracioRepository;
	@Autowired
	private LlocFeinaRepository llocFeinaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;

	public void processarCanviMarcatges(
			MarcatgeEntity entity,
			Date dataOriginal,
			boolean calcularValidesa) {
		log.debug("Processant canvis en el marcatge (" +
				"entity=" + entity + ", " +
				"dataOriginal=" + dataOriginal + ", " +
				"calcularValidesa=" + calcularValidesa + ")");
		OperariEmpresaEntity operariEmpresa = entity.getOperariEmpresa();
		if (calcularValidesa) {
			LlocFeinaEntity llocFeina = calcularForaLlocFeina(entity, operariEmpresa);
			calcularValidesa(entity, operariEmpresa.getEmpresa());
			entity.updateLlocFeina(llocFeina);
		}
		recalcularIntervals(
				dataOriginal,
				entity,
				operariEmpresa);
		recalcularAcumulatsAnyActual(operariEmpresa);
	}

	/**
	 * Retorna la informació dels acumulats donada una data.
	 * @param operariEmpresa la informació de l'operari-empresa.
	 * @param data la data de referència pel càlcul d'acumulats.
	 * @return la informació amb els acumulats.
	 */
	public AcumulatInfo getAcumulatsEnData(
			OperariEmpresaEntity operariEmpresa,
			Date data) {
		Calendar dataInici = getCalendarDataInici(data, false);
		Calendar dataFi = getCalendarDataFi(data, false);
		BigDecimal acumulatDia = marcatgeRepository.acumulatEntreDates(
				operariEmpresa,
				dataInici.getTime(),
				dataFi.getTime());
		dataInici.set(Calendar.DAY_OF_MONTH, 0);
		dataFi.set(Calendar.DAY_OF_MONTH, dataFi.getActualMaximum(Calendar.DAY_OF_MONTH));
		BigDecimal acumulatMes = marcatgeRepository.acumulatEntreDates(
				operariEmpresa,
				dataInici.getTime(),
				dataFi.getTime());
		dataInici.set(Calendar.DAY_OF_YEAR, 0);
		dataFi.set(Calendar.MONTH, Calendar.DECEMBER);
		dataFi.set(Calendar.DAY_OF_MONTH, 31);
		BigDecimal acumulatAny = marcatgeRepository.acumulatEntreDates(
				operariEmpresa,
				dataInici.getTime(),
				dataFi.getTime());
		return new AcumulatInfo(
				acumulatAny,
				acumulatMes,
				acumulatDia);
	}

	/**
	 * Calcula si el marcatge està a dins el lloc de feina i retorna el lloc
	 * de feina associat (si n'hi ha).
	 * Primer es comprova si hi ha cap lloc de feina associat a l'operari. Si
	 * no n'hi ha el marcatge es considera fet al lloc de feina i es retorna
	 * null.
	 * Si hi ha marcatges associats a l'operari es comprova si l'adreça IP del
	 * marcatge coincideix amb les adreces d'algun lloc de feina. Si coincideix
	 * aleshores es considera el marcatge fet a dins el lloc de feina i es
	 * retorna el lloc de feina associat.
	 * Si l'adreça IP del marcatge no coincideix amb les de cap lloc de feina
	 * aleshores es mira si el marcatge està geolocalitzat. Si no hi està es
	 * considera el marcatge fet fora del lloc de feina i es retorna null.
	 * Si el marcatge està geolocalitzat es cerca el lloc de feina més a prop
	 * del marcatge i es mira si la distància és menor a la distància màxima
	 * permesa pel lloc de feina. Si ho és aleshores es considera el marcatge
	 * fet a dins el lloc de feina i es retorna el lloc de feina associat. En
	 * cas contrari es considera el marcatge fet fora del lloc de feina i es
	 * retorna null.
	 * @param marcatge la informació del marcatge.
	 * @param operariEmpresa la informació de l'operari-empresa.
	 * @return el lloc de feina associat al marcatge o null si no n'hi ha.
	 */
	private LlocFeinaEntity calcularForaLlocFeina(
			MarcatgeEntity marcatgeEntity,
			OperariEmpresaEntity operariEmpresa) {
		log.debug("Cercant lloc de feina pel marcatge (marcatgeEntity=" + marcatgeEntity + ")");
		Marcatge marcatge = marcatgeEntity.getEmbedded();
		Set<LlocFeinaEntity> llocsFeina = llocFeinaRepository.findByOperariEmpresa(operariEmpresa);
		boolean llocFeinaFora;
		LlocFeinaEntity llocFeina = null;
		if (llocsFeina != null && !llocsFeina.isEmpty()) {
			llocFeina = llocFeinaAmbAdressaIp(marcatge.getAdressaIp(), operariEmpresa);
			if (llocFeina != null) {
				log.debug("Marcatge considerat dins el lloc de feina " +
						"per coincidència de l'adreça IP (" +
						"adressaIp=" + marcatge.getAdressaIp() + ", " +
						"llocFeina=" + llocFeina + ", " +
						"marcatgeEntity=" + marcatgeEntity + ")");
				llocFeinaFora = false;
			} else if (marcatge.getLatitud() != null && marcatge.getLongitud() != null) {
				llocFeina = llocFeinaAmbPosicioMesPropera(marcatge, operariEmpresa);
				double distanciaMaxima = llocFeina.getEmbedded().getDistanciaMaxima();
				double distancia = distanciaLatitudLongitud(
						marcatge.getLatitud().doubleValue(),
						marcatge.getLongitud().doubleValue(),
						0,
						llocFeina.getEmbedded().getLatitud().doubleValue(),
						llocFeina.getEmbedded().getLongitud().doubleValue(),
						0);
				llocFeinaFora = distancia > distanciaMaxima;
				if (llocFeinaFora) {
					log.debug("Marcatge considerat fora del lloc de feina més proper (" +
							"llocFeina=" + llocFeina + ", " +
							"distancia=" + distancia + ", " +
							"distanciaMaxima=" + distanciaMaxima + ", " +
							"marcatgeEntity=" + marcatgeEntity + ")");
				} else {
					log.debug("Marcatge considerat a dins el lloc de feina més proper (" +
							"llocFeina=" + llocFeina + ", " +
							"distancia=" + distancia + ", " +
							"distanciaMaxima=" + distanciaMaxima + ", " +
							"marcatgeEntity=" + marcatgeEntity + ")");
				}
			} else {
				llocFeinaFora = true;
			}
		} else {
			log.debug("Marcatge considerat dins el lloc de feina " +
					"perquè l'operari no te llocs de feina assignats (" +
					"marcatgeEntity=" + marcatgeEntity + ")");
			llocFeinaFora = false;
		}
		marcatge.setLlocFeinaFora(llocFeinaFora);
		return llocFeina;
	}

	/**
	 * Recalcula la validesa d'un marcatge. Per a que un marcatge sigui vàlid
	 * ha de passar:
	 * - Que el marcatge no estigui fora del lloc de feina.
	 * - Que el marcatge no sigui offline o que sigui offline i el paràmetre
	 * validacioOfflineAutomatica estigui activat.
	 * @param marcatge la informació del marcatge.
	 * @param empresa la informació de l'empresa.
	 */
	private void calcularValidesa(
			MarcatgeEntity marcatgeEntity,
			EmpresaEntity empresa) {
		Optional<ConfiguracioEntity> configuracioEntity = configuracioRepository.findByEmpresa(empresa);
		Configuracio configuracio = configuracioEntity.isPresent() ? configuracioEntity.get().getEmbedded() : null;
		// Mira si el marcatge és invàlid per fora de línia
		boolean invalidForaLinia = false;
		if (marcatgeEntity.getEmbedded().isForaLinia()) {
			invalidForaLinia = true;
			// Si la configuració te habilitada la validació automàtica de marcatges fora de línia
			// aleshores el marcatge és vàlid maldament sigui fora de línia.
			if (configuracio != null && configuracio.getValidacioOfflineAutomatica() != null && configuracio.getValidacioOfflineAutomatica()) {
				invalidForaLinia = false;
			}
		}
		// Mira si el marcatge és invàlid per fora del lloc de feina
		boolean invalidForaLlocFeina = marcatgeEntity.getEmbedded().isLlocFeinaFora();
		// Per a que el marcatge sigui vàlid no ha de ser fora de línia ni fora del lloc
		// de feina.
		boolean validat = !invalidForaLinia && !invalidForaLlocFeina;
		if (validat) {
			log.debug("Marcatge considerat vàlid (marcatgeEntity=" + marcatgeEntity + ")");
		} else {
			log.debug("Marcatge considerat invàlid (" +
					"marcatgeEntity=" + marcatgeEntity + ", " +
					"invalidForaLinia=" + invalidForaLinia + ", " +
					"invalidForaLlocFeina=" + invalidForaLlocFeina + ")");
		}
		marcatgeEntity.getEmbedded().setValidat(validat);
		if (validat) {
			marcatgeEntity.getEmbedded().setValidatData(new Date());
		}
	}

	/**
	 * Recalcula els intervals després de crear / modificar un marcatge. Els
	 * intervals només es recalculen si el marcatge modificat és vàlid. Si el
	 * marcatge modificat no és vàlid no ha de tenir cap efecte sobre els
	 * intervals.
	 * Només recalcula els intervals des de l'inici de l'any.
	 * Si l'any actual no te cap interval calculat recalcula tots els intervals
	 * des de l'inici de l'any.
	 * @param dataOriginal la data del marcatge abans de ser modificada. Si
	 * és una creació dataOriginal coincidirà amb data del marcatgeModificat.
	 * @param marcatgeModificat el marcatge creat / modificat.
	 * @param operariEmpresa la informació de l'operari-empresa.
	 */
	private void recalcularIntervals(
			Date dataOriginal,
			MarcatgeEntity marcatgeModificat,
			OperariEmpresaEntity operariEmpresa) {
		// Només recalcula els intervals si el marcatge modificat és vàlid.
		if (marcatgeModificat.getEmbedded().isValidat()) {
			Date marcatgeModificatData = marcatgeModificat.getEmbedded().getData();
			log.debug("Recalculant intervals canvis en el marcatge (" +
					"marcatgeModificat=" + marcatgeModificatData + ", " +
					"operariEmpresa=" + operariEmpresa + ", " +
					"dataOriginal=" + dataOriginal + ")");
			Optional<ConfiguracioEntity> configuracioEntity = configuracioRepository.findByEmpresa(operariEmpresa.getEmpresa());
			Configuracio configuracio = configuracioEntity.isPresent() ? configuracioEntity.get().getEmbedded() : null;
			Integer maxDistanciaInterval = configuracio != null ? configuracio.getMaxDistanciaInterval() : null;
			Date dataIniciAny = getCalendarDataInici(marcatgeModificatData, true).getTime();
			Date dataFiAny = getCalendarDataFi(marcatgeModificatData, true).getTime();
			MarcatgeEntity darrerMarcatgeAnyActual = getDarrerMarcatgeValidAnyActual(
					operariEmpresa,
					false);
			if (darrerMarcatgeAnyActual != null) {
				// 1.- Cercam el marcatge just anterior al marcatge del qual hem de recalcular
				// pista: select marcatges where data < dataCalculada order by data desc limit 1;
				// a on dataCalculada = min(dataOriginal, marcatgeModificat.data);
				Date dataCalculada = dataOriginal.before(marcatgeModificatData) ? dataOriginal : marcatgeModificatData;
				BigDecimal acumulatAny = marcatgeRepository.acumulatEntreDates(
						operariEmpresa,
						dataIniciAny,
						dataFiAny);
				// Si l'any actual no te cap interval calculat posa el valor de la data
				// calculada a l'inici de l'any per a forçar el càlcul de tots els
				// intervals de l'any del marcatge.
				if (acumulatAny == null || acumulatAny.intValue() == 0) {
					dataCalculada = dataIniciAny;
				}
				MarcatgeEntity marcatgeAnterior = marcatgeRepository.findFirstByOperariEmpresaAndEmbeddedDataGreaterThanEqualAndEmbeddedDataLessThanAndEmbeddedValidatTrueOrderByEmbeddedDataDesc(
						operariEmpresa,
						dataIniciAny,
						dataCalculada);
				log.debug("Marcatge anterior en l'any actual (" +
						"marcatgeModificat=" + marcatgeModificatData + ", " +
						"operariEmpresa=" + operariEmpresa + ", " +
						"marcatgeAnterior=" + marcatgeAnterior + ")");
				// 2.- Obtenim la llista de marcatges amb data entre marcatgeAnterior.data i dataFiAny
				// eliminant el marcatgeModificat.
				// pista: select marcatges where data >= marcatgeAnterior.data and validat = true and id<>marcatgeModificat.id order by data asc;
				// El marcatge modificat s'ha d'eliminar perquè la consulta retornarà
				// el marcatge que hi ha a la base de dades i no el modificat i això
				// trastocaria el càlcul d'intervals.
				List<MarcatgeEntity> marcatges = marcatgeRepository.findByOperariEmpresaAndBetweenDatesExcludingIdOrderByEmbeddedDataAsc(
						operariEmpresa,
						dataCalculada,
						dataFiAny,
						marcatgeModificat.getId() == null,
						marcatgeModificat.getId());
				// 3.- Recórrer els marcatges recalculant els intervals
				MarcatgeEntity intervalAnterior = (marcatgeAnterior != null && marcatgeAnterior.getIntervalAnterior() == null) ? marcatgeAnterior : null;
				if (!marcatges.isEmpty()) {
					log.debug("Recalculant intervals dels marcatges entre dates (" +
							"marcatgeModificat=" + marcatgeModificatData + ", " +
							"operariEmpresa=" + operariEmpresa + ", " +
							"dataInici=" + dataCalculada + ", " +
							"dataFi=" + dataFiAny + ", " +
							"count=" + marcatges.size() + ")");
					boolean marcatgeModificatProcessat = false;
					for (MarcatgeEntity marcatge: marcatges) {
						// Revisam el lloc en la llista de marcatges a on aniria el marcatgeModificat
						// i el processam com si estigués a dins la llista.
						if (dataEntreMarcatges(marcatgeModificatData, intervalAnterior, marcatge)) {
							intervalAnterior = recalcularIntervalRetornantIntervalAnterior(
									intervalAnterior,
									marcatgeModificat,
									maxDistanciaInterval);
							marcatgeModificatProcessat = true;
						}
						intervalAnterior = recalcularIntervalRetornantIntervalAnterior(
								intervalAnterior,
								marcatge,
								maxDistanciaInterval);
					}
					// Miram si ja hem processat el marcatgeModificat amb la llista de marcatges
					if (!marcatgeModificatProcessat) {
						// Si no miram si el darrer marcatge de la llista és un interval obert
						MarcatgeEntity darrer = marcatges.get(marcatges.size() - 1);
						if (darrer.getIntervalAnterior() == null) {
							if (dataEntreMarcatges(marcatgeModificatData, darrer, null)) {
								recalcularIntervalRetornantIntervalAnterior(
										darrer,
										marcatgeModificat,
										maxDistanciaInterval);
							}
						}
					}
				} else {
					log.debug("No s'han trobat marcatges en l'interval, recalculant només l'interval del marcatge actual (" +
							"marcatgeModificat=" + marcatgeModificatData + ", " +
							"operariEmpresa=" + operariEmpresa + ", " +
							"dataInici=" + dataCalculada + ", " +
							"dataFi=" + dataFiAny + ", " +
							"count=" + marcatges.size() + ")");
					if (dataEntreMarcatges(marcatgeModificatData, intervalAnterior, marcatgeModificat)) {
						recalcularIntervalRetornantIntervalAnterior(
								intervalAnterior,
								marcatgeModificat,
								maxDistanciaInterval);
					}
				}
			} else {
				log.debug("Detectat primer marcatge de l'any actual, no recalculam cap interval (" +
						"marcatgeModificat=" + marcatgeModificatData + ", " +
						"operariEmpresa=" + operariEmpresa + ")");
				// TODO tractar el primer marcatge de l'any.
				// Per a que tot quadri l'any anterior ha d'acabar amb un
				// interval tancat. Si l'any anterior acaba amb un marcatge
				// obert s'ha d'insertar un marcatge addicional el darrer segon
				// de l'any anterior i un marcatge addicional el primer segon
				// de l'any actual.
			}
		}
	}

	private boolean dataEntreMarcatges(
			Date data,
			MarcatgeEntity marcatge1,
			MarcatgeEntity marcatge2) {
		Date data1 = marcatge1 != null ? marcatge1.getEmbedded().getData() : null;
		Date data2 = marcatge2 != null ? marcatge2.getEmbedded().getData() : null;
		boolean resultat;
		if (data1 != null && data2 == null) {
			resultat = data.equals(data1) || data.after(data1);
		} else if (data1 == null && data2 != null) {
			resultat = data.before(data2) || data.equals(data2);
		} else if (data1 != null && data2 != null) {
			resultat = data.equals(data1) || (data.after(data1) && data.before(data2)) || data.equals(data2);
		} else {
			resultat = true;
		}
		return resultat;
	}

	private MarcatgeEntity recalcularIntervalRetornantIntervalAnterior(
			MarcatgeEntity marcatgeIntervalAnterior,
			MarcatgeEntity marcatge,
			Integer maxDistanciaInterval) {
		Date marcatgeData = marcatge.getEmbedded().getData();
		Date intervalAnteriorData = (marcatgeIntervalAnterior != null) ? marcatgeIntervalAnterior.getEmbedded().getData() : null;
		log.debug("Revisant interval pel marcatge (" +
				"marcatgeIntervalAnterior=" + intervalAnteriorData + ", " +
				"marcatge=" + marcatgeData + ", " +
				"maxDistanciaInterval=" + maxDistanciaInterval + ")");
		if (marcatgeIntervalAnterior != null) {
			boolean diferenciaMassaGrossa = false;
			long diferenciaMilisegons = Math.abs(marcatgeData.getTime() - intervalAnteriorData.getTime());
			if (maxDistanciaInterval != null) {
				double diferenciaMinuts = diferenciaMilisegons / (double)60000;
				diferenciaMassaGrossa = diferenciaMinuts > (double)maxDistanciaInterval;
			}
			if (!diferenciaMassaGrossa) {
				marcatge.updateIntervalAnterior(marcatgeIntervalAnterior);
				long diferenciaSegons = diferenciaMilisegons / 1000;
				marcatge.getEmbedded().setIntervalDuracio(new BigDecimal(diferenciaSegons));
				marcatge.getEmbedded().setIntervalObert(false);
				log.debug("Nou interval tancat (" +
						"marcatgeIntervalAnterior=" + intervalAnteriorData + ", " +
						"marcatge=" + marcatgeData + ", " +
						"diferenciaSegons=" + diferenciaSegons + ")");
				return null;
			} else {
				marcatgeIntervalAnterior.getEmbedded().setIntervalDuracio(null);
				marcatgeIntervalAnterior.getEmbedded().setIntervalObert(true);
				marcatge.updateIntervalAnterior(null);
				marcatge.getEmbedded().setIntervalDuracio(null);
				marcatge.getEmbedded().setIntervalObert(false);
				log.debug("Nou interval obert (" +
						"marcatgeIntervalAnterior=" + intervalAnteriorData + ")");
			}
		} else {
			marcatge.updateIntervalAnterior(null);
			marcatge.getEmbedded().setIntervalDuracio(null);
			marcatge.getEmbedded().setIntervalObert(false);
		}
		return marcatge;
	}

	/**
	 * Recalcula els acumulats de l'any/mes/dia actual. Aquests acumulats
	 * sempre es trobaran en el darrer marcatge de l'any per l'operari.
	 * @param operariEmpresa la informació de l'operari-empresa.
	 */
	private void recalcularAcumulatsAnyActual(OperariEmpresaEntity operariEmpresa) {
		/*MarcatgeEntity darrerMarcatgeAnyActual = getDarrerMarcatgeValidAnyActual(
				operariEmpresa,
				true);
		AcumulatInfo acumulatInfo = getAcumulatsEnData(
				operariEmpresa,
				darrerMarcatgeAnyActual.getEmbedded().getData());
		darrerMarcatgeAnyActual.getEmbedded().setAcumulatAny(
				acumulatInfo.getAcumulatAny());
		darrerMarcatgeAnyActual.getEmbedded().setAcumulatMes(
				acumulatInfo.getAcumulatMes());
		darrerMarcatgeAnyActual.getEmbedded().setAcumulatDia(
				acumulatInfo.getAcumulatDia());*/
	}

	private LlocFeinaEntity llocFeinaAmbAdressaIp(
			String adressaIp,
			OperariEmpresaEntity operariEmpresa) {
		LlocFeinaEntity llocFeinaTrobat = null;
		Set<LlocFeinaEntity> llocsFeina = llocFeinaRepository.findByOperariEmpresa(operariEmpresa);
		if (llocsFeina != null && !llocsFeina.isEmpty()) {
			for (LlocFeinaEntity llocFeina: llocsFeina) {
				String adrecesIpPermeses = llocFeina.getEmbedded().getAdrecesIpPermeses();
				if (adrecesIpPermeses != null) {
					if (adrecesIpPermeses.contains(",")) {
						for (String part: adrecesIpPermeses.split(",")) {
							if (ipAddressMatches(adressaIp, part.trim())) {
								llocFeinaTrobat = llocFeina;
								break;
							}
						}
					} else {
						if (ipAddressMatches(adressaIp, adrecesIpPermeses.trim())) {
							llocFeinaTrobat = llocFeina;
							break;
						}
					}
				}
			}
		}
		return llocFeinaTrobat;
	}

	/**
	 * Retorna el lloc de feina més a prop del marcatge.
	 * @param marcatge la informació del marcatge.
	 * @param operariEmpresa la informació de l'operari-empresa.
	 * @return el lloc de feina més a prop o null si no n'hi ha cap de definit.
	 */
	private LlocFeinaEntity llocFeinaAmbPosicioMesPropera(
			Marcatge marcatge,
			OperariEmpresaEntity operariEmpresa) {
		LlocFeinaEntity llocFeinaMesAprop = null;
		Set<LlocFeinaEntity> llocsFeina = llocFeinaRepository.findByOperariEmpresa(operariEmpresa);
		if (llocsFeina != null && !llocsFeina.isEmpty()) {
			double distancia = Double.MAX_VALUE;
			for (LlocFeinaEntity llocFeina: llocsFeina) {
				double distanciaLlocFeina = distanciaLatitudLongitud(
						marcatge.getLatitud().doubleValue(),
						marcatge.getLongitud().doubleValue(),
						0,
						llocFeina.getEmbedded().getLatitud().doubleValue(),
						llocFeina.getEmbedded().getLongitud().doubleValue(),
						0);
				if (distanciaLlocFeina < distancia) {
					llocFeinaMesAprop = llocFeina;
					distancia = distanciaLlocFeina;
				}
			}
		}
		return llocFeinaMesAprop;
	}

	/**
	 * Calcula la distància entre dos punts donada la latitud i longitud de
	 * cada punt. També es te en compte la diferència d'alçada entre els dos
	 * punts.
	 * Funció basada en el mètode Haversine.
	 * Si no es vol tenir en compte la elevació es pot passar el valor 0 com
	 * a valor d'elevació pels dos punts.
	 * @param lat1 latitud del punt 1.
	 * @param lon1 longitud del punt 1.
	 * @param el1 elevació del punt 1.
	 * @param lat2 latitud del punt 2.
	 * @param lon2 longitud del punt 2.
	 * @param el2 elevació del punt 2.
	 * @return La distància en metres.
	 */
	private double distanciaLatitudLongitud(
			double lat1,
			double lon1,
			double el1,
			double lat2,
			double lon2,
			double el2) {
		final int R = 6371; // Radi de la terra en metres
		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
				Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
				Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // Converteix en metres
		double height = el1 - el2;
		distance = Math.pow(distance, 2) + Math.pow(height, 2);
		return Math.sqrt(distance);
	}

	private boolean ipAddressMatches(String ipAddress, String subnet) {
	    IpAddressMatcher ipAddressMatcher = new IpAddressMatcher(subnet);
	    return ipAddressMatcher.matches(ipAddress);
	}

	private MarcatgeEntity getDarrerMarcatgeValidAnyActual(
			OperariEmpresaEntity operariEmpresa,
			boolean netejarAcumulats) {
		Calendar iniciAny = getCalendarDataInici(null, true);
		Calendar fiAny = getCalendarDataFi(null, true);
		/*marcatgeRepository.netejarAcumulatsEntreDates(
				operariEmpresa,
				iniciAny.getTime(),
				fiAny.getTime());*/
		return marcatgeRepository.findFirstByOperariEmpresaAndEmbeddedDataBetweenAndEmbeddedValidatTrueOrderByEmbeddedDataDesc(
				operariEmpresa,
				iniciAny.getTime(),
				fiAny.getTime());
	}

	private Calendar getCalendarDataInici(Date data, boolean iniciAny) {
		Calendar dataInici = Calendar.getInstance();
		if (data != null) {
			dataInici.setTime(data);
		}
		if (iniciAny) {
			dataInici.set(Calendar.DAY_OF_YEAR, 1);
		}
		dataInici.set(Calendar.HOUR_OF_DAY, 0);
		dataInici.set(Calendar.MINUTE, 0);
		dataInici.set(Calendar.SECOND, 0);
		dataInici.set(Calendar.MILLISECOND, 0);
		return dataInici;
	}

	private Calendar getCalendarDataFi(Date data, boolean fiAny) {
		Calendar dataFi = Calendar.getInstance();
		if (data != null) {
			dataFi.setTime(data);
		}
		if (fiAny){
			dataFi.set(Calendar.MONTH, Calendar.DECEMBER);
			dataFi.set(Calendar.DAY_OF_MONTH, 31);
		}
		dataFi.set(Calendar.HOUR_OF_DAY, 23);
		dataFi.set(Calendar.MINUTE, 59);
		dataFi.set(Calendar.SECOND, 59);
		dataFi.set(Calendar.MILLISECOND, 999);
		return dataFi;
	}

	/*
	-- Netejar intervals:
	UPDATE
		CECOCLOUD.TMAR_MARCATGE
	SET INTERVAL_DURACIO = NULL, INTERVAL_ANTERIOR_ID = NULL, INTERVAL_OBERT = NULL;
	
	-- Consulta intervals:
	SELECT 
		CASE M.INTERVAL_OBERT WHEN 1 THEN M.DATA ELSE M2.DATA END DATA_INICI,
		CASE M.INTERVAL_OBERT WHEN 1 THEN NULL ELSE M.DATA END DATA_FI,
		M.INTERVAL_OBERT, 
		M.INTERVAL_DURACIO, 
		M.FORA_LINIA, 
		M.LLOC_FORA, 
		M.VALIDAT 
	FROM 
		CECOCLOUD.TMAR_MARCATGE M,
		CECOCLOUD.TMAR_MARCATGE M2
	WHERE 
		M.OPERARIEMP_ID = 230046
	AND (M.INTERVAL_ANTERIOR_ID IS NOT NULL OR M.INTERVAL_OBERT = 1)
	AND M.INTERVAL_ANTERIOR_ID = M2.ID(+)
	ORDER BY
		M.DATA ASC;
	
	--Consulta id operari-empresa
	SELECT
		OEM.ID,
		OPE.CODI,
		USU.CODI,
		USU.NOM,
		USU.LLINATGES
	FROM
		CECOCLOUD.OPERARI_EMPRESA OEM,
		CECOCLOUD.OPERARI OPE,
		CECOCLOUD.EMPRESA EMP,
		CECOCLOUD.IDENTIFICADOR IDE,
		CECOCLOUD.USUARI USU
	WHERE
		OEM.OPERARI_ID = OPE.ID
	AND OEM.EMPRESA_ID = EMP.ID
	AND EMP.IDENTIFICADOR_ID = IDE.ID
	AND OPE.USUARI_ID = USU.ID
	AND IDE.CODI = 'LIM' -- Limit
	AND EMP.CODI = 'PRO2' -- Limit Tecnologies
	AND OPE.CODI = '000001';
	 */

}
