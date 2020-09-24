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

/**
 * Funcionalitat comuna pels marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
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
		OperariEmpresaEntity operariEmpresa = entity.getOperariEmpresa();
		LlocFeinaEntity llocFeina = calcularForaLlocFeina(entity, operariEmpresa);
		if (calcularValidesa) {
			calcularValidesa(entity, operariEmpresa.getEmpresa());
		}
		entity.updateLlocFeina(llocFeina);
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
		Marcatge marcatge = marcatgeEntity.getEmbedded();
		Set<LlocFeinaEntity> llocsFeina = llocFeinaRepository.findByOperariEmpresa(operariEmpresa);
		boolean llocFeinaFora;
		LlocFeinaEntity llocFeina = null;
		if (llocsFeina != null && !llocsFeina.isEmpty()) {
			llocFeina = llocFeinaAmbAdressaIp(marcatge.getAdressaIp(), operariEmpresa);
			if (llocFeina != null) {
				llocFeinaFora = false;
			} else if (marcatge.getLatitud() != null && marcatge.getLongitud() != null) {
				llocFeina = llocFeinaAmbPosicio(marcatge, operariEmpresa);
				double distanciaMaxima = llocFeina.getEmbedded().getDistanciaMaxima();
				double distancia = distanciaLatitudLongitud(
						marcatge.getLatitud().doubleValue(),
						marcatge.getLongitud().doubleValue(),
						0,
						llocFeina.getEmbedded().getLatitud().doubleValue(),
						llocFeina.getEmbedded().getLongitud().doubleValue(),
						0);
				llocFeinaFora = distancia > distanciaMaxima;
			} else {
				llocFeinaFora = true;
			}
		} else {
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
		// Valida el marcatge si la configuració te habilitada la validació automàtica de marcatges fora de línia
		boolean validat = true;
		if (marcatgeEntity.getEmbedded().isForaLinia()) {
			validat = false;
			if (configuracio != null && configuracio.getValidacioOfflineAutomatica() != null && configuracio.getValidacioOfflineAutomatica()) {
				validat = true;
			}
		}
		// Els marcatges fets fora del lloc de feina es consideren no vàlids 
		if (marcatgeEntity.getEmbedded().isLlocFeinaFora()) {
			validat = false;
		}
		marcatgeEntity.getEmbedded().setValidat(validat);
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
			Optional<ConfiguracioEntity> configuracioEntity = configuracioRepository.findByEmpresa(operariEmpresa.getEmpresa());
			Configuracio configuracio = configuracioEntity.isPresent() ? configuracioEntity.get().getEmbedded() : null;
			Integer maxDistanciaInterval = configuracio != null ? configuracio.getMaxDistanciaInterval() : null;
			// 1.- Cercam el marcatge just anterior al marcatge del qual hem de recalcular
			// pista: select marcatges where data < dataCalculada order by data desc limit 1;
			// a on dataCalculada = min(dataOriginal, marcatgeModificat.data);
			Date marcatgeModificatData = marcatgeModificat.getEmbedded().getData();
			Date dataIniciAny = getCalendarDataInici(marcatgeModificatData, true).getTime();
			Date dataFiAny = getCalendarDataFi(marcatgeModificatData, true).getTime();
			Date dataCalculada = dataOriginal.before(marcatgeModificatData) ? dataOriginal : marcatgeModificatData;
			MarcatgeEntity darrerMarcatgeAnyActual = getDarrerMarcatgeValidAnyActual(
					operariEmpresa,
					false);
			if (darrerMarcatgeAnyActual != null) {
				if (	darrerMarcatgeAnyActual.getEmbedded().getAcumulatAny() == null && 
						darrerMarcatgeAnyActual.getEmbedded().getAcumulatMes() == null && 
						darrerMarcatgeAnyActual.getEmbedded().getAcumulatDia() == null) {
					// Si l'any actual no te cap interval calculat força el valor de la data
					// calculada a l'inici de l'any.
					dataCalculada = dataIniciAny;
				}
				MarcatgeEntity marcatgeAnterior = marcatgeRepository.findFirstByOperariEmpresaAndEmbeddedDataGreaterThanEqualAndEmbeddedDataLessThanAndEmbeddedValidatTrueOrderByEmbeddedDataDesc(
						operariEmpresa,
						dataIniciAny,
						dataCalculada);
				// 2.- Obtenim la llista de marcatges amb data entre marcatgeAnterior.data i dataFiAny
				// eliminant el marcatgeModificat.
				// pista: select marcatges where data >= marcatgeAnterior.data and validat = true and id<>marcatgeModificat.id order by data asc;
				// El marcatge modificat s'ha d'eliminar perquè la consulta retornarà
				// el marcatge que hi ha a la base de dades i no el modificat i això
				// trastocaria el càlcul d'intervals.
				List<MarcatgeEntity> marcatges = marcatgeRepository.findByOperariEmpresaAndEmbeddedDataGreaterThanEqualAndEmbeddedDataLessThanEqualAndEmbeddedValidatTrueAndIdNotOrderByEmbeddedDataAsc(
						operariEmpresa,
						dataCalculada,
						dataFiAny,
						marcatgeModificat.getId());
				// 3.- Recórrer els marcatges recalculant els intervals
				MarcatgeEntity intervalAnterior = (marcatgeAnterior != null && marcatgeAnterior.getIntervalAnterior() == null) ? marcatgeAnterior : null;
				if (!marcatges.isEmpty()) {
					for (MarcatgeEntity marcatge: marcatges) {
						// Revisam el lloc en la llista de marcatges a on aniria el marcatgeModificat
						// i el processam com si estigués a dins la llista.
						if (dataEntreMarcatges(marcatgeModificatData, intervalAnterior, marcatge)) {
							intervalAnterior = recalcularIntervalRetornantIntervalAnterior(
									intervalAnterior,
									marcatgeModificat,
									maxDistanciaInterval);
						}
						intervalAnterior = recalcularIntervalRetornantIntervalAnterior(
								intervalAnterior,
								marcatgeModificat,
								maxDistanciaInterval);
					}
				} else {
					if (dataEntreMarcatges(marcatgeModificatData, intervalAnterior, marcatgeModificat)) {
						intervalAnterior = recalcularIntervalRetornantIntervalAnterior(
								intervalAnterior,
								marcatgeModificat,
								maxDistanciaInterval);
					}
				}
			} else {
				// TODO tractar el primer marcatge de l'any.
				// Per a que tot quadri l'any anterior ha d'acabar amb un
				// interval tancat. Si l'any anterior acaba amb un marcatge
				// obert s'ha d'insertar un marcatge addicional el darrer segon
				// de l'any anterior i un marcatge addicional el primer segon
				// de l'any actual.
			}
		}
	}

	private MarcatgeEntity recalcularIntervalRetornantIntervalAnterior(
			MarcatgeEntity intervalAnterior,
			MarcatgeEntity marcatge,
			Integer maxDistanciaInterval) {
		if (intervalAnterior != null) {
			boolean diferenciaMassaGrossa = false;
			long diferenciaMilisegons = Math.abs(marcatge.getEmbedded().getData().getTime() - intervalAnterior.getEmbedded().getData().getTime());
			if (maxDistanciaInterval != null) {
				double diferenciaMinuts = diferenciaMilisegons / (double)60000;
				diferenciaMassaGrossa = diferenciaMinuts > (double)maxDistanciaInterval;
			}
			if (!diferenciaMassaGrossa) {
				marcatge.updateIntervalAnterior(intervalAnterior);
				long diferenciaSegons = diferenciaMilisegons / 1000;
				marcatge.getEmbedded().setIntervalDuracio(new BigDecimal(diferenciaSegons));
				return null;
			}
		}
		return marcatge;
	}

	/**
	 * Recalcula els acumulats de l'any/mes/dia actual. Aquests acumulats
	 * sempre es trobaran en el darrer marcatge de l'any per l'operari.
	 * @param operariEmpresa la informació de l'operari-empresa.
	 */
	private void recalcularAcumulatsAnyActual(OperariEmpresaEntity operariEmpresa) {
		MarcatgeEntity darrerMarcatgeAnyActual = getDarrerMarcatgeValidAnyActual(
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
				acumulatInfo.getAcumulatDia());
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
	private LlocFeinaEntity llocFeinaAmbPosicio(
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

	private boolean dataEntreMarcatges(
			Date data,
			MarcatgeEntity marcatge1,
			MarcatgeEntity marcatge2) {
		Date data2 = marcatge2.getEmbedded().getData();
		if (marcatge1 == null) {
			return data.before(data2) || data.equals(data2);
		} else {
			Date data1 = marcatge1.getEmbedded().getData();
			return data.after(data1) && data.before(data2) || data.equals(data1) || data.equals(data2);
		}
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
		marcatgeRepository.netejarAcumulatsEntreDates(
				operariEmpresa,
				iniciAny.getTime(),
				fiAny.getTime());
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

	/* Propostes de SQL per a calcular intervals. Problema: no hi ha forma de tenir en compte
	els intervals que queden oberts.

	- Solució SQL postgresql:
	SELECT
	    int1.id,
	    int1.operari_id,
	    int1.data,
	    int2.data,
	    int2.data - int1.data temps
	from (
	select sq2.id, sq2.operari_id, sq2.data, sq2.seq from (select sq1.id, sq1.operari_id, sq1.data, row_number() over() seq, mod(row_number() over(), 2) odd from (
	select id, operari_id, data from marcatge where operari_id = 3 order by data) sq1) sq2
	where odd = 1) int1, (
	select sq2.id, sq2.operari_id, sq2.data, sq2.seq from (select sq1.id, sq1.operari_id, sq1.data, row_number() over() seq, mod(row_number() over(), 2) odd from (
	select id, operari_id, data from marcatge where operari_id = 3 order by data) sq1 WHERE id <> 3) sq2
	where odd = 1) int2
	where int1.seq = int2.seq;
	
	- Solució SQL oracle:
	SELECT
	    int1.id,
	    int1.operariemp_id,
	    int1.DATA,
	    int2.DATA,
	    (int2.DATA - int1.data) AS temps,
	    extract(day from (int2.DATA - int1.data)) dies,
	    extract(hour from (int2.DATA - int1.data)) hores,
	    extract(minute from (int2.DATA - int1.data)) minuts,
	    extract(second from (int2.DATA - int1.data)) segons
	FROM (
	SELECT id, operariemp_id, DATA, seq FROM (
	SELECT id, operariemp_id, data, rownum seq, MOD(rownum, 2) odd FROM (
	select id, operariemp_id, data from cecocloud.tmar_marcatge where operariemp_id = 123983 order by DATA))
	WHERE odd = 1) int1, (
	SELECT id, operariemp_id, DATA, seq FROM (
	SELECT id, operariemp_id, data, rownum seq, MOD(rownum, 2) odd FROM (
	select id, operariemp_id, data from cecocloud.tmar_marcatge where operariemp_id = 123983 order by DATA) WHERE id <> 124015)
	WHERE odd = 1) int2
	WHERE int1.seq = int2.seq;
	*/

}
