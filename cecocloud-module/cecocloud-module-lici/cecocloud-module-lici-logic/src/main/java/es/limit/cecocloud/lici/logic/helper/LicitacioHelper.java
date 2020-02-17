/**
 * 
 */
package es.limit.cecocloud.lici.logic.helper;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.lici.logic.api.dto.Avis;
import es.limit.cecocloud.lici.logic.api.dto.Cpv;
import es.limit.cecocloud.lici.logic.api.dto.Document;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.lici.logic.helper.PlataformaContractacioHelper.LicitacioPlataformaContractacio;
import es.limit.cecocloud.lici.persist.entity.CpvEntity;
import es.limit.cecocloud.lici.persist.entity.DocumentEntity;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;
import es.limit.cecocloud.lici.persist.repository.CpvRepository;
import es.limit.cecocloud.lici.persist.repository.DocumentRepository;
import es.limit.cecocloud.lici.persist.repository.LicitacioRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Helper per a l'actualització de licitacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class LicitacioHelper {

	@Autowired
	private LicitacioRepository licitacioRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private CpvRepository cpvRepository;

	@Transactional
	public boolean updateLicitacio(
			EmpresaEntity empresa,
			LicitacioPlataformaContractacio licitacio) {
		boolean created = false;
		Optional<LicitacioEntity> optionalLicitacioEntity = licitacioRepository.findById(licitacio.getId());
		LicitacioEntity licitacioEntity = null;
		if (!optionalLicitacioEntity.isPresent()) {
			logger.debug("Creant licitació (resum=" + licitacio.getResum() + ", dataActualitzacio=" + licitacio.getDataActualitzacio() + ")");
			licitacioEntity = licitacioRepository.save(
					LicitacioEntity.builder().
					embedded(licitacio).
					empresa(empresa).
					build());
			created = true;
		} else {
			logger.debug("Actualitzant licitació (resum=" + licitacio.getResum() + ", dataActualitzacio=" + licitacio.getDataActualitzacio() + ")");
			licitacioEntity = optionalLicitacioEntity.get();
			licitacioEntity.update(licitacio);
		}
		updateLicitacioDocuments(licitacio, licitacioEntity);
		updateLicitacioCpvs(licitacio, licitacioEntity);
		updateLicitacioAvisos(licitacio, licitacioEntity);
		return created;
	}

	public static void printLicitacio(LicitacioPlataformaContractacio licitacio) {
		System.out.println(">>> id: " + licitacio.getId());
		System.out.println("    uri: " + licitacio.getUri());
		System.out.println("    dataActualitzacio: " + licitacio.getDataActualitzacio());
		System.out.println("    resum: " + licitacio.getResum());
		System.out.println("    expedientId: " + licitacio.getExpedientId());
		System.out.println("    expedientEstat: [" + licitacio.getExpedientEstat() + "] " + licitacio.getExpedientEstatDescripcio());
		System.out.println("    unitatTipus: [" + licitacio.getUnitatTipus() + "] " + licitacio.getUnitatTipusDescripcio());
		System.out.println("    unitatDir3Codi: " + licitacio.getUnitatDir3Codi());
		System.out.println("    unitatNom: " + licitacio.getUnitatNom());
		System.out.println("    projecteTitol: " + licitacio.getProjecteTitol());
		System.out.println("    projecteTipus: [" + licitacio.getProjecteTipus() + "] " + licitacio.getProjecteTipusDescripcio());
		System.out.println("    projecteSubTipus: [" + licitacio.getProjecteSubTipus() + "] " + licitacio.getProjecteSubTipusDescripcio());
		if (licitacio.getCpvs() != null) {
			System.out.println("    projecteCpvs:");
			for (Cpv cpv: licitacio.getCpvs()) {
				System.out.println("        [" + cpv.getCodi() + "] " + cpv.getDescripcio());
			}
		}
		System.out.println("    projecteImportSenseTaxes: " + licitacio.getProjecteImportSenseTaxes() + " " + licitacio.getProjecteMoneda());
		System.out.println("    projecteImportTotal: " + licitacio.getProjecteImportTotal() + " " + licitacio.getProjecteMoneda());
		System.out.println("    projectePais: [" + licitacio.getProjectePaisCodi() + "] " + licitacio.getProjectePaisDescripcio());
		System.out.println("    projecteProvincia: [" + licitacio.getProjecteProvinciaCodi() + "] " + licitacio.getProjecteProvinciaDescripcio());
		System.out.println("    projecteTerminiExecucio: " + licitacio.getProjecteTerminiExecucioNum() + " " + licitacio.getProjecteTerminiExecucioUnitat());
		System.out.println("    procedimentTipus: [" + licitacio.getProjecteTipus() + "] " + licitacio.getProjecteTipusDescripcio());
		System.out.println("    urgenciaTipus: [" + licitacio.getProjecteTipus() + "] " + licitacio.getProjecteTipusDescripcio());
		System.out.println("    dataLimit: " + licitacio.getDataLimit());
		printDocument("documentTecnic", licitacio.getDocumentTecnic());
		printDocument("documentAdministratiu", licitacio.getDocumentAdministratiu());
		if (licitacio.getDocumentsAddicionals() != null) {
			for (es.limit.cecocloud.lici.logic.api.dto.Document document: licitacio.getDocumentsAddicionals()) {
				printDocument("documentAddicional", document);
			}
		}
		if (licitacio.getAvisos() != null) {
			for (Avis avis: licitacio.getAvisos()) {
				printAvis(avis);
			}
		}
		System.out.println();
	}
	private static void printDocument(
			String documentTipus,
			es.limit.cecocloud.lici.logic.api.dto.Document document) {
		if (document != null) {
			System.out.println("    " + documentTipus + ":");
			System.out.println("        nom: " + document.getNom());
			System.out.println("        uri: " + document.getUri());
			System.out.println("        hash: " + document.getHash());
		}
	}
	private static void printAvis(Avis avis) {
		if (avis != null) {
			System.out.println("    avis:");
			System.out.println("        tipus: [" + avis.getTipus() + "] " + avis.getTipusDescripcio());
			System.out.println("        llocPublicacio: " + avis.getLlocPublicacio());
			System.out.println("        data: " + avis.getData());
		}
	}

	private void updateLicitacioDocuments(
			LicitacioPlataformaContractacio licitacio,
			LicitacioEntity entity) {
		List<DocumentEntity> documentEntities = documentRepository.findByLicitacio(entity);
		if (licitacio.getDocumentTecnic() != null) {
			updateLicitacioDocument(
					entity,
					licitacio.getDocumentTecnic(),
					documentEntities);
		}
		if (licitacio.getDocumentAdministratiu() != null) {
			updateLicitacioDocument(
					entity,
					licitacio.getDocumentAdministratiu(),
					documentEntities);
		}
		if (licitacio.getDocumentsAddicionals() != null) {
			for (Document document: licitacio.getDocumentsAddicionals()) {
				updateLicitacioDocument(
						entity,
						document,
						documentEntities);
			}
		}
		for (DocumentEntity documentEntity: documentEntities) {
			boolean trobat = false;
			if (licitacio.getDocumentTecnic() != null) {
				trobat = documentEntity.getEmbedded().getNom().equals(licitacio.getDocumentTecnic().getNom());
			}
			if (!trobat && licitacio.getDocumentAdministratiu() != null) {
				trobat = documentEntity.getEmbedded().getNom().equals(licitacio.getDocumentAdministratiu().getNom());
			}
			if (!trobat && licitacio.getDocumentsAddicionals() != null) {
				for (Document document: licitacio.getDocumentsAddicionals()) {
					if (documentEntity.getEmbedded().getNom().equals(document.getNom())) {
						trobat = true;
						break;
					}
				}
			}
			if (!trobat) {
				documentRepository.delete(documentEntity);
			}
		}
	}
	private void updateLicitacioDocument(
			LicitacioEntity licitacio,
			Document document,
			List<DocumentEntity> documentEntities) {
		DocumentEntity trobat = null;
		for (DocumentEntity documentEntity: documentEntities) {
			if (documentEntity.getEmbedded().getCodi().equals(document.getCodi())) {
				trobat = documentEntity;
				break;
			}
		}
		if (trobat == null) {
			logger.debug("Creant document " + document.getTipus() + ": " + document.getNom());
			documentRepository.save(
					DocumentEntity.builder().
					embedded(document).
					licitacio(licitacio).
					build());
		} else {
			logger.debug("Actualitzant document " + document.getTipus() + ": " + document.getNom());
			trobat.update(document);
		}
	}

	private void updateLicitacioCpvs(
			LicitacioPlataformaContractacio licitacio,
			LicitacioEntity entity) {
		List<CpvEntity> cpvEntities = cpvRepository.findByLicitacio(entity);
		if (licitacio.getCpvs() != null) {
			for (Cpv cpv: licitacio.getCpvs()) {
				updateLicitacioCpv(
						entity,
						cpv,
						cpvEntities);
			}
		}
	}
	private void updateLicitacioCpv(
			LicitacioEntity licitacio,
			Cpv cpv,
			List<CpvEntity> cpvEntities) {
		CpvEntity trobat = null;
		for (CpvEntity cpvEntity: cpvEntities) {
			if (cpvEntity.getEmbedded().getCodi().equals(cpv.getCodi())) {
				trobat = cpvEntity;
				break;
			}
		}
		if (trobat == null) {
			logger.debug("Creant CPV: [" + cpv.getCodi() + "] " + cpv.getDescripcio());
			cpvRepository.save(
					CpvEntity.builder().
					embedded(cpv).
					licitacio(licitacio).
					build());
		} else {
			logger.debug("Modificant CPV: [" + cpv.getCodi() + "] " + cpv.getDescripcio());
			trobat.update(cpv);
		}
	}

	private void updateLicitacioAvisos(
			Licitacio licitacio,
			LicitacioEntity entity) {
		// TODO
	}

	public static String getIdFromLicitacio(Licitacio licitacio) {
		if (licitacio != null) {
			return licitacio.getCodi().substring(licitacio.getCodi().lastIndexOf("/") + 1);
		} else {
			return null;
		}
	}
	
	
	// MÉTODES PER AFEGUIR LES LICITACIONS REBUDES DE LA PLATAFORMA DE INFONALIA /////////////////////////
	
	@Transactional
	public boolean updateLicitacioInfonalia(
			EmpresaEntity empresa,
			Licitacio licitacio) {
		boolean created = false;
		Optional<LicitacioEntity> optionalLicitacioEntity = licitacioRepository.findById(licitacio.getId());
		LicitacioEntity licitacioEntity = null;
		if (!optionalLicitacioEntity.isPresent()) {
			logger.debug("Creant licitació (resum=" + licitacio.getResum() + ", dataActualitzacio=" + licitacio.getDataActualitzacio() + ")");
			licitacioEntity = licitacioRepository.save(
					LicitacioEntity.builder().
					embedded(licitacio).
					empresa(empresa).
					build());
			created = true;
		} else {
			logger.debug("Actualitzant licitació (resum=" + licitacio.getResum() + ", dataActualitzacio=" + licitacio.getDataActualitzacio() + ")");
			licitacioEntity = optionalLicitacioEntity.get();
			licitacioEntity.update(licitacio);
		}		
		return created;
	}	

	private static final Logger logger = LoggerFactory.getLogger(LicitacioHelper.class);

}
