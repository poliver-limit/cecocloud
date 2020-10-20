/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.marc.logic.api.dto.AcumulatInfo;
import es.limit.cecocloud.marc.logic.api.dto.AcumulatMobilConsulta;
import es.limit.cecocloud.marc.logic.api.dto.Configuracio;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobil;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobilConsulta;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.marc.logic.api.service.MobileMarcatgeService;
import es.limit.cecocloud.marc.logic.helper.MarcatgeHelper;
import es.limit.cecocloud.marc.persist.entity.ConfiguracioEntity;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.repository.ConfiguracioRepository;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei encarregat de processar els marcatges fets des de
 * l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class MobileMarcatgeServiceImpl implements MobileMarcatgeService {

	@Autowired
	private OperariRepository operariRepository;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private OperariEmpresaRepository operariEmpresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;
	@Autowired
	private ConfiguracioRepository configuracioRepository;
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private MarcatgeHelper marcatgeHelper;

	@Override
	@Transactional
	public MarcatgeMobil create(MarcatgeMobil marcatgeMobil) {
		if (marcatgeMobil.getIdentificadorCodi() != null && marcatgeMobil.getEmpresaCodi() != null) {
			Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(
					marcatgeMobil.getIdentificadorCodi());
			Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorAndEmbeddedCodi(
					identificador.get(),
					marcatgeMobil.getEmpresaCodi());
			OperariEmpresaEntity operariEmpresa = getOperariEmpresaPerMarcatge(empresa.get());
			log.info("Rebut marcatge de l'app mòbil (" +
					"operariEmpresa=" + operariEmpresa.getEmbedded() + ", " +
					"data=" + marcatgeMobil.getData() + ", " +
					"dataActual=" + new Date() + ")");
			Marcatge marcatge = new Marcatge();
			marcatge.setData(marcatgeMobil.getData());
			marcatge.setOrigen(MarcatgeOrigen.MOBIL);
			marcatge.setLatitud(marcatgeMobil.getLatitud());
			marcatge.setLongitud(marcatgeMobil.getLongitud());
			marcatge.setPrecisio(marcatgeMobil.getPrecisio());
			marcatge.setForaLinia(marcatgeMobil.isOffline());
			marcatge.setAdressaIp(request.getRemoteAddr());
			MarcatgeEntity entity = MarcatgeEntity.builder().
					operariEmpresa(operariEmpresa).
					embedded(marcatge).
					build();
			marcatgeHelper.processarCanviMarcatges(
					entity,
					marcatgeMobil.getData(),
					true);
			return toMarcatgeMobil(
					marcatgeMobil.getIdentificadorCodi(),
					marcatgeMobil.getEmpresaCodi(),
					marcatgeRepository.save(entity));
		} else {
			throw new IllegalArgumentException("S'ha enviat un marcatge sense empresa");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<MarcatgeMobil> find(MarcatgeMobilConsulta consulta) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(
				consulta.getIdentificadorCodi());
		Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorAndEmbeddedCodi(
				identificador.get(),
				consulta.getEmpresaCodi());
		OperariEmpresaEntity operariEmpresa = getOperariEmpresaPerMarcatge(empresa.get());
		Calendar dataFi = Calendar.getInstance();
		dataFi.setTime(consulta.getData());
		dataFi.set(Calendar.HOUR_OF_DAY, 23);
		dataFi.set(Calendar.MINUTE, 59);
		dataFi.set(Calendar.SECOND, 59);
		dataFi.set(Calendar.MILLISECOND, 999);
		List<MarcatgeEntity> marcatges = marcatgeRepository.findByOperariEmpresaAndBetweenDatesMobile(
				operariEmpresa,
				consulta.getData(),
				false,
				dataFi.getTime());
		return marcatges.stream().map(marcatge -> toMarcatgeMobil(consulta.getIdentificadorCodi(), consulta.getEmpresaCodi(), marcatge)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<SincronitzacioEmpresa> empresesFindDisponiblesPerUsuariActual() {
		List<EmpresaEntity> empreses = operariEmpresaRepository.findByOperariUsuariEmbeddedCodiAndEmpresaEmbeddedActivaTrue(
				authenticationHelper.getPrincipalName());
		List<SincronitzacioEmpresa> resposta = new ArrayList<SincronitzacioEmpresa>();
		for (EmpresaEntity empresa: empreses) {
			SincronitzacioEmpresa empresaSync = new SincronitzacioEmpresa();
			empresaSync.setIdentificadorCodi(empresa.getIdentificador().getEmbedded().getCodi());
			empresaSync.setCodi(empresa.getEmbedded().getCodi());
			empresaSync.setNom(empresa.getEmbedded().getNom());
			empresaSync.setNif(empresa.getEmbedded().getNif());
			Optional<ConfiguracioEntity> configuracioEntity = configuracioRepository.findByEmpresa(empresa);
			Configuracio configuracio = configuracioEntity.isPresent() ? configuracioEntity.get().getEmbedded() : null;
			boolean offlinePermes = false;
			if (configuracio != null && configuracio.getOfflinePermes() != null && configuracio.getOfflinePermes()) {
				offlinePermes = true;
			}
			empresaSync.setOfflinePermes(offlinePermes);
			boolean mostrarTempsAcumulat = false;
			if (configuracio != null && configuracio.getMostrarTempsAcumulat() != null && configuracio.getMostrarTempsAcumulat()) {
				mostrarTempsAcumulat = true;
			}
			empresaSync.setMostrarTempsAcumulat(mostrarTempsAcumulat);
			resposta.add(empresaSync);
		}
		return resposta;
	}

	@Override
	@Transactional(readOnly = true)
	public AcumulatInfo acumulatFind(AcumulatMobilConsulta consulta) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(
				consulta.getIdentificadorCodi());
		Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorAndEmbeddedCodi(
				identificador.get(),
				consulta.getEmpresaCodi());
		OperariEmpresaEntity operariEmpresa = getOperariEmpresaPerMarcatge(empresa.get());
		return marcatgeHelper.getAcumulatsEnData(operariEmpresa, consulta.getData());
	}

	private OperariEmpresaEntity getOperariEmpresaPerMarcatge(EmpresaEntity empresa) {
		Optional<OperariEntity> operari = operariRepository.findByIdentificadorAndEmbeddedActiuAndUsuariEmbeddedCodi(
				empresa.getIdentificador(),
				true,
				authenticationHelper.getPrincipalName());
		Optional<OperariEmpresaEntity> operariEmpresa = operariEmpresaRepository.findByOperariAndEmpresaAndEmbeddedActiu(
				operari.get(),
				empresa,
				true);
		return operariEmpresa.get();
	}

	private MarcatgeMobil toMarcatgeMobil(
			String identificadorCodi,
			String empresaCodi,
			MarcatgeEntity marcatge) {
		MarcatgeMobil marcatgeMobil = new MarcatgeMobil();
		marcatgeMobil.setIdentificadorCodi(identificadorCodi);
		marcatgeMobil.setEmpresaCodi(empresaCodi);
		marcatgeMobil.setData(marcatge.getEmbedded().getData());
		marcatgeMobil.setLatitud(marcatge.getEmbedded().getLatitud());
		marcatgeMobil.setLongitud(marcatge.getEmbedded().getLongitud());
		marcatgeMobil.setPrecisio(marcatge.getEmbedded().getPrecisio());
		marcatgeMobil.setOffline(marcatge.getEmbedded().isForaLinia());
		marcatgeMobil.setOffline(marcatge.getEmbedded().isForaLinia());
		marcatgeMobil.setLlocFeinaFora(marcatge.getEmbedded().isLlocFeinaFora());
		marcatgeMobil.setValidat(marcatge.getEmbedded().isValidat());
		marcatgeMobil.setIntervalDuracio(marcatge.getEmbedded().getIntervalDuracio());
		boolean intervalObert = (marcatge.getEmbedded().getIntervalObert() != null) ? marcatge.getEmbedded().getIntervalObert() : false;
		marcatgeMobil.setIntervalObert(intervalObert);
		marcatgeMobil.setIntervalFinal(marcatge.getEmbedded().getIntervalDuracio() != null);
		return marcatgeMobil;
	}

}
