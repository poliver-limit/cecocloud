/*
 * 
 */
package es.limit.cecocloud.lici.logic.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.lici.logic.api.dto.MergeResult;
import es.limit.cecocloud.lici.logic.api.service.LicitacioService;
import es.limit.cecocloud.lici.logic.helper.LicitacioHelper;
import es.limit.cecocloud.lici.logic.helper.LicitacioInfonaliaHelper;
import es.limit.cecocloud.lici.logic.helper.PlataformaContractacioHelper;
import es.limit.cecocloud.lici.logic.helper.PlataformaContractacioHelper.LicitacioPlataformaContractacio;
import es.limit.cecocloud.lici.persist.entity.ConfiguracioEntity;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;
import es.limit.cecocloud.lici.persist.repository.ConfiguracioRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei encarregat de gestionar licitacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class LicitacioServiceImpl extends AbstractGenericServiceImpl<Licitacio, LicitacioEntity, Long> implements LicitacioService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private ConfiguracioRepository configuracioRepository;
	@Autowired
	private PlataformaContractacioHelper plataformaContractacioHelper;
	@Autowired
	private LicitacioHelper licitacioHelper;
	@Autowired
	private LicitacioInfonaliaHelper licitacioInfonaliaHelper;

	// Cada dia a les 4 de la matinada
	@Scheduled(cron = "0 0 4 * * *")
	public void scheduledUpdate() {
		List<EmpresaEntity> empreses = empresaRepository.findAll();
		for (EmpresaEntity empresa: empreses) {
			updateLicitacionsDiaActual(empresa);
		}
	}

	// Cada dia a les 5 de la matinada i cada dues hores
	@Scheduled(cron = "0 0 5/2 * * *") 
	public void scheduledUpdateInfonalia() {
		// 1. Obtenir noves licitacions de infonalia
		List<Licitacio> licitacions = licitacioInfonaliaHelper.obtenirNovesLicitacions();
		if (!licitacions.isEmpty()) {
			// 2. Assignam les licitacions a les empreses
			List<EmpresaEntity> empreses = empresaRepository.findAll();
			for (EmpresaEntity empresa: empreses) {
				updateLicitacionsInfonalia(licitacions, empresa);
			}
		}
	}

	private static final String XML_URL = "https://contrataciondelestado.es/sindicacion/sindicacion_643/licitacionesPerfilesContratanteCompleto3.atom";

	private MergeResult updateLicitacionsDiaActual(EmpresaEntity empresa) {
		MergeResult mergeResult = new MergeResult();
		long t0 = System.currentTimeMillis();
		Optional<ConfiguracioEntity> configuracio = configuracioRepository.findByEmpresa(empresa);
		if (configuracio.isPresent() && configuracio.get().getEmbedded().isSincronitzacioActiva()) {
			String filtreProvincia = configuracio.get().getEmbedded().getFiltreProvincia();
			String filtreCpv = configuracio.get().getEmbedded().getFiltreCpv();
			List<LicitacioPlataformaContractacio> licitacions = null;
			try {
				licitacions = plataformaContractacioHelper.getLicitacionsPerActualitzar(
						XML_URL,
						filtreProvincia,
						filtreCpv,
						null,
						getDataAvuiMitjanit());
			} catch (Exception ex) {
				log.error("Error al obtenir actualització de les licitacions de la plataforma de contractació ", ex);
			}
			if (licitacions != null) {
				int createdCount = 0;
				int updatedCount = 0;
				int errorCount = 0;
				log.debug("Refrescant " + licitacions.size() + " licitacions");
				for (LicitacioPlataformaContractacio licitacio: licitacions) {
					try {
						boolean created = licitacioHelper.updateLicitacio(empresa, licitacio);
						if (created) {
							createdCount++;
						} else {
							updatedCount++;
						}
					} catch (Exception ex) {
						log.error("Error al actualitzar la licitació " + licitacio.getResum(), ex);
						errorCount++;
					}
				}
				mergeResult.setCreated(createdCount);
				mergeResult.setUpdated(updatedCount);
				mergeResult.setError(errorCount);
				mergeResult.setTotal(licitacions.size());
				mergeResult.setTimeElapsedMs(System.currentTimeMillis() - t0);
			}
		}
		return mergeResult;
	}

	private MergeResult updateLicitacionsInfonalia(List<Licitacio> licitacions, EmpresaEntity empresa) {
		MergeResult mergeResult = new MergeResult();
		long t0 = System.currentTimeMillis();
		Optional<ConfiguracioEntity> configuracio = configuracioRepository.findByEmpresa(empresa);
		if (configuracio.isPresent() && configuracio.get().getEmbedded().isSincronitzacioActiva()) {
			String filtreProvincia = configuracio.get().getEmbedded().getFiltreProvincia();
			@SuppressWarnings("unused")
			boolean filtrar = false;
			if (filtreProvincia != null) {
				filtreProvincia = filtreProvincia.toUpperCase();
				filtrar = filtreProvincia.startsWith("ES");
			}
			if (licitacions != null) {
				int createdCount = 0;
				int updatedCount = 0;
				int errorCount = 0;
				log.debug("Refrescant " + licitacions.size() + " licitacions");
				for (Licitacio licitacio : licitacions) {						
					try {								 
						boolean created = licitacioHelper.updateLicitacioInfonalia(empresa, licitacio);
						if (created) {
							createdCount++;
						} else {
							updatedCount++;
						}
					} catch (Exception ex) {
						log.error("Error al actualitzar la licitació " + licitacio.getResum(), ex);
						errorCount++;
					}
				}
				mergeResult.setCreated(createdCount);
				mergeResult.setUpdated(updatedCount);
				mergeResult.setError(errorCount);
				mergeResult.setTotal(licitacions.size());
				mergeResult.setTimeElapsedMs(System.currentTimeMillis() - t0);
			}
		}
		return mergeResult;
	}

	private Date getDataAvuiMitjanit() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
