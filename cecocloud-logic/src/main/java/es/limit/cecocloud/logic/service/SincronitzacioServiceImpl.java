/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Empresa.EmpresaTipusEnum;
import es.limit.cecocloud.logic.api.dto.IdentificadorRecursOrigen;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaUsuari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresesResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioUsuari;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;
import es.limit.cecocloud.persist.repository.PerfilUsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei encarregat de gestionar la sincronització de la informació provinent
 * de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
@Slf4j
public class SincronitzacioServiceImpl implements SincronitzacioService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;
	@Autowired
	private UsuariIdentificadorEmpresaRepository usuariIdentificadorEmpresaRepository;
	@Autowired
	private OperariRepository operariRepository;
	@Autowired
	private OperariEmpresaRepository operariEmpresaRepository;
	@Autowired
	private PerfilUsuariIdentificadorEmpresaRepository perfilUsuariIdentificadorEmpresaRepository;

	@Override
	@Transactional
	public SincronitzacioIdentificadorResposta sincronitzarIdentificador(SincronitzacioIdentificadorPeticio peticio) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(peticio.getCodi());
		if (identificador.isPresent()) {
			identificador.get().getEmbedded().setDescripcio(peticio.getNom());
			SincronitzacioEmpresesResposta empresesResposta = sincronitzarEmpreses(
					identificador.get(),
					peticio.getEmpreses());
			SincronitzacioResposta usuarisResposta = sincronitzarUsuaris(
					identificador.get(),
					peticio.getUsuaris());
			SincronitzacioResposta operarisResposta = sincronitzarOperaris(
					identificador.get(),
					peticio.getOperaris());
			SincronitzacioResposta usuarisEmpresesResposta = sincronitzarUsuarisEmpreses(
					identificador.get(),
					peticio.getEmpreses());
			SincronitzacioResposta operarisEmpresesResposta = sincronitzarOperarisEmpreses(
					identificador.get(),
					peticio.getEmpreses());
			empresesResposta.setUsuaris(usuarisEmpresesResposta);
			empresesResposta.setOperaris(operarisEmpresesResposta);
			return new SincronitzacioIdentificadorResposta(
					empresesResposta,
					usuarisResposta,
					operarisResposta);
		} else {
			throw new EntityNotFoundException("IdentificadorEntity#codi=" + peticio.getCodi());
		}
	}

	private SincronitzacioEmpresesResposta sincronitzarEmpreses(
			IdentificadorEntity identificador,
			List<SincronitzacioEmpresa> empreses) {
		log.debug("Sincronitzant empreses per l'identificador (codi=" + identificador.getEmbedded().getCodi() + ")...");
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador);
		// S'esborren les empreses que existeixen a la BBDD i no a la informació de sincronització
		// i el seu orígen és SYNC
		for (EmpresaEntity empresa: emps) {
			SincronitzacioEmpresa syncFound = null;
			for (SincronitzacioEmpresa empresaSync: empreses) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					syncFound = empresaSync;
					break;
				}
			}
			if (syncFound == null && IdentificadorRecursOrigen.SYNC.equals(empresa.getEmbedded().getOrigen())) {
				log.debug("\tDesactivant l'empresa (codi=" + empresa.getEmbedded().getCodi() + ")");
				for (OperariEmpresaEntity operariEmpresa: operariEmpresaRepository.findByEmpresa(empresa)) {
					operariEmpresa.getEmbedded().setActiu(false);
				}
				empresa.getEmbedded().setActiva(false);
				deleteCount++;
			}
		}
		int canBeAddedCount = identificador.getEmbedded().getNumEmpreses() - identificador.getEmpresesCount() + deleteCount;
		// S'actualitzen les empreses que existeixen a la BBDD i a la informació de sincronització
		for (EmpresaEntity empresa: emps) {
			SincronitzacioEmpresa syncFound = null;
			for (SincronitzacioEmpresa empresaSync: empreses) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					syncFound = empresaSync;
					break;
				}
			}
			if (syncFound != null) {
				empresa.getEmbedded().setNif(syncFound.getNif());
				empresa.getEmbedded().setNom(syncFound.getNom());
				if (!empresa.getEmbedded().isActiva()) {
					if (canBeAddedCount > 0) {
						log.debug("\tActivant l'empresa (codi=" + empresa.getEmbedded().getCodi() + ")");
						empresa.getEmbedded().setActiva(true);
						updateCount++;
						canBeAddedCount--;
					} else {
						log.debug("\tERROR: l'empresa no s'ha pogut activar perquè s'ha arribat al màxim d'empreses actives (codi=" + empresa.getEmbedded().getCodi() + ", màxim=" + identificador.getEmbedded().getNumEmpreses() + ")");
						errorCount++;
					}
				} else {
					log.debug("\tModificant empresa (codi=" + empresa.getEmbedded().getCodi() + ")");
					updateCount++;
				}
			}
		}
		// Es creen les empreses que no existeixen a la BBDD i si a la informació de sincronització
		for (SincronitzacioEmpresa empresaSync: empreses) {
			EmpresaEntity dbFound = null;
			for (EmpresaEntity empresa: emps) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					dbFound = empresa;
					break;
				}
			}
			if (dbFound == null) {
				if (canBeAddedCount > 0) {
					log.debug("\tCreant l'empresa (codi=" + empresaSync.getCodi() + ")");
					Empresa empresa = new Empresa();
					empresa.setCodi(empresaSync.getCodi());
					empresa.setNif(empresaSync.getNif());
					empresa.setNom(empresaSync.getNom());
					empresa.setTipus(EmpresaTipusEnum.GESTIO);
					empresa.setOrigen(IdentificadorRecursOrigen.SYNC);
					empresa.setActiva(true);
					empresaRepository.save(
							EmpresaEntity.builder().
							embedded(empresa).
							identificador(identificador).
							build());
					createCount++;
					canBeAddedCount--;
				} else {
					log.debug("\tERROR: l'empresa no s'ha pogut afegir perquè s'ha arribat al màxim d'empreses actives (codi=" + empresaSync.getCodi() + ", màxim=" + identificador.getEmbedded().getNumEmpreses() + ")");
					errorCount++;
				}
			}
		}
		log.debug("...empreses sincronitzades per l'identificador (" +
				"codi=" + identificador.getEmbedded().getCodi() + ", " +
				"creats=" + createCount + ", " +
				"modificats=" + updateCount + ", " +
				"esborrats=" + deleteCount + ", " +
				"errors=" + errorCount + ")");
		return new SincronitzacioEmpresesResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount,
				null,
				null);
	}

	private SincronitzacioResposta sincronitzarUsuaris(
			IdentificadorEntity identificador,
			List<SincronitzacioUsuari> usuaris) {
		log.debug("Sincronitzant usuariIdentificadors per l'identificador (codi=" + identificador.getEmbedded().getCodi() + ")...");
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<UsuariIdentificadorEntity> usuidfs = usuariIdentificadorRepository.findByIdentificador(identificador);
		// S'esborren els usuari-identificador que existeixen a la BBDD i no a la informació de sincronització
		// i el seu orígen és SYNC
		for (UsuariIdentificadorEntity usuariIdentificador: usuidfs) {
			SincronitzacioUsuari syncFound = null;
			for (SincronitzacioUsuari usuariSync: usuaris) {
				if (usuariIdentificadorDbEqualsOperariSync(usuariIdentificador, usuariSync)) {
					syncFound = usuariSync;
					break;
				}
			}
			if (syncFound == null && IdentificadorRecursOrigen.SYNC.equals(usuariIdentificador.getEmbedded().getOrigen())) {
				log.debug("\tDesactivant l'usuariIdentificador (codi=" + usuariIdentificador.getUsuariCodi() + ")");
				for (UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa: usuariIdentificadorEmpresaRepository.findByUsuariIdentificador(usuariIdentificador)) {
					usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresa);
				}
				usuariIdentificador.getEmbedded().setActiu(false);
				deleteCount++;
			}
		}
		int canBeAddedCount = identificador.getEmbedded().getNumUsuaris() - identificador.getUsuarisCount() + deleteCount;
		// S'actualitzen els usuari-identificador que existeixen a la BBDD i a la informació de sincronització
		for (UsuariIdentificadorEntity usuariIdentificador: usuidfs) {
			SincronitzacioUsuari syncFound = null;
			for (SincronitzacioUsuari usuariSync: usuaris) {
				if (usuariIdentificadorDbEqualsOperariSync(usuariIdentificador, usuariSync)) {
					syncFound = usuariSync;
					break;
				}
			}
			if (syncFound != null) {
				if (!usuariIdentificador.getEmbedded().isActiu()) {
					if (canBeAddedCount > 0) {
						log.debug("\tActivant l'usuariIdentificador (codi=" + usuariIdentificador.getUsuariCodi() + ")");
						usuariIdentificador.getEmbedded().setActiu(true);
						updateCount++;
						canBeAddedCount--;
					} else {
						log.debug("\tERROR: l'usuariIdentificador no s'ha pogut activar perquè s'ha arribat al màxim d'usuaris actius (codi=" + usuariIdentificador.getUsuariCodi() + ", màxim=" + identificador.getEmbedded().getNumUsuaris() + "))");
						errorCount++;
					}
				} else {
					log.debug("\tModificant l'usuariIdentificador (codi=" + usuariIdentificador.getUsuariCodi() + ")");
					updateCount++;
				}
			}
		}
		// Es creen els usuari-identificador que no existeixen a la BBDD i si a la informació de sincronització
		for (SincronitzacioUsuari usuariSync: usuaris) {
			UsuariIdentificadorEntity dbFound = null;
			for (UsuariIdentificadorEntity usuariIdentificador: usuidfs) {
				if (usuariIdentificadorDbEqualsOperariSync(usuariIdentificador, usuariSync)) {
					dbFound = usuariIdentificador;
					break;
				}
			}
			if (dbFound == null) {
				if (canBeAddedCount > 0) {
					Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(usuariSync.getUsuariCodi());
					if (usuari.isPresent()) {
						log.debug("\tCreant l'usuariIdentificador (codi=" + usuariSync.getUsuariCodi() + ")");
						UsuariIdentificador usuariIdentificador = new UsuariIdentificador();
						usuariIdentificador.setOrigen(IdentificadorRecursOrigen.SYNC);
						usuariIdentificador.setActiu(true);
						usuariIdentificadorRepository.save(
								UsuariIdentificadorEntity.builder().
								embedded(usuariIdentificador).
								usuari(usuari.get()).
								identificador(identificador).
								build());
						createCount++;
						canBeAddedCount--;
					} else {
						log.debug("\tERROR: l'usuariIdentificador no s'ha pogut afegir perquè no s'ha trobat l'usuari especificat (codi=" + usuariSync.getUsuariCodi() + ")");
						errorCount++;
					}
				} else {
					log.debug("\tERROR: l'usuariIdentificador no s'ha pogut afegir perquè s'ha arribat al màxim d'usuaris actius (codi=" + usuariSync.getUsuariCodi() + ", màxim=" + identificador.getEmbedded().getNumUsuaris() + ")");
					errorCount++;
				}
			}
		}
		log.debug("...usuariIdentificadors sincronitzats per l'identificador (" +
				"codi=" + identificador.getEmbedded().getCodi() + ", " +
				"creats=" + createCount + ", " +
				"modificats=" + updateCount + ", " +
				"esborrats=" + deleteCount + ", " +
				"errors=" + errorCount + ")");
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
	}

	private SincronitzacioResposta sincronitzarOperaris(
			IdentificadorEntity identificador,
			List<SincronitzacioOperari> operaris) {
		log.debug("Sincronitzant operaris per l'identificador (codi=" + identificador.getEmbedded().getCodi() + ")...");
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<OperariEntity> opes = operariRepository.findByIdentificador(identificador);
		// S'esborren els operaris que existeixen a la BBDD i no a la informació de sincronització
		// i el seu orígen és SYNC
		for (OperariEntity operari: opes) {
			SincronitzacioOperari syncFound = null;
			for (SincronitzacioOperari operariSync: operaris) {
				if (operariDbEqualsOperariSync(operari, operariSync)) {
					syncFound = operariSync;
					break;
				}
			}
			if (syncFound == null && IdentificadorRecursOrigen.SYNC.equals(operari.getEmbedded().getOrigen())) {
				log.debug("\tDesactivant l'operari (codi=" + operari.getEmbedded().getCodi() + ", usuariCodi=" + operari.getUsuariCodi() + ")");
				for (OperariEmpresaEntity operariEmpresa: operariEmpresaRepository.findByOperari(operari)) {
					operariEmpresa.getEmbedded().setActiu(false);
				}
				operari.getEmbedded().setActiu(false);
				deleteCount++;
			}
		}
		int canBeAddedCount = identificador.getEmbedded().getNumOperaris() - identificador.getOperarisCount() + deleteCount;
		// S'actualitzen els operaris que existeixen a la BBDD i a la informació de sincronització
		for (OperariEntity operari: opes) {
			SincronitzacioOperari syncFound = null;
			for (SincronitzacioOperari operariSync: operaris) {
				if (operariDbEqualsOperariSync(operari, operariSync)) {
					syncFound = operariSync;
					break;
				}
			}
			if (syncFound != null) {
				if (!operari.getEmbedded().isActiu()) {
					if (canBeAddedCount > 0) {
						log.debug("\tActivant l'operari (codi=" + operari.getEmbedded().getCodi() + ", usuariCodi=" + operari.getUsuariCodi() + ")");
						operari.getEmbedded().setActiu(true);
						updateCount++;
						canBeAddedCount--;
					} else {
						log.debug("\tERROR: l'operari no s'ha pogut activar perquè s'ha arribat al màxim d'operaris actius (codi=" + operari.getEmbedded().getCodi() + ", usuariCodi=" + operari.getUsuariCodi() + ", màxim=" + identificador.getEmbedded().getNumOperaris() + ")");
						errorCount++;
					}
				} else {
					log.debug("\tModificant l'operari (codi=" + operari.getEmbedded().getCodi() + ", usuariCodi=" + operari.getUsuariCodi() + ")");
					updateCount++;
				}
			}
		}
		// Es creen els operaris que no existeixen a la BBDD i si a la informació de sincronització
		for (SincronitzacioOperari operariSync: operaris) {
			OperariEntity dbFound = null;
			for (OperariEntity operari: opes) {
				if (operariDbEqualsOperariSync(operari, operariSync)) {
					dbFound = operari;
					break;
				}
			}
			if (dbFound == null) {
				if (canBeAddedCount > 0) {
					Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(operariSync.getUsuariCodi());
					if (usuari.isPresent()) {
						log.debug("\tCreant l'operari (codi=" + operariSync.getCodi() + ", usuariCodi=" + operariSync.getUsuariCodi() + ")");
						Operari operari = new Operari();
						operari.setCodi(operariSync.getCodi());
						operari.setOrigen(IdentificadorRecursOrigen.SYNC);
						operari.setActiu(true);
						operariRepository.save(
								OperariEntity.builder().
								embedded(operari).
								usuari(usuari.get()).
								identificador(identificador).
								build());
						createCount++;
						canBeAddedCount--;
					} else {
						log.debug("\tERROR: l'operari no s'ha pogut afegir perquè no s'ha trobat l'usuari especificat (codi=" + operariSync.getCodi() + ", usuariCodi=" + operariSync.getUsuariCodi() + ")");
						errorCount++;
					}
				} else {
					log.debug("\tERROR: l'operari no s'ha pogut afegir perquè s'ha arribat al màxim d'operaris actius (codi=" + operariSync.getCodi() + ", usuariCodi=" + operariSync.getUsuariCodi() + ", màxim=" + identificador.getEmbedded().getNumOperaris() + ")");
					errorCount++;
				}
			}
		}
		log.debug("...operaris sincronitzats per l'identificador (" +
				"codi=" + identificador.getEmbedded().getCodi() + ", " +
				"creats=" + createCount + ", " +
				"modificats=" + updateCount + ", " +
				"esborrats=" + deleteCount + ", " +
				"errors=" + errorCount + ")");
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
	}

	private SincronitzacioResposta sincronitzarUsuarisEmpreses(
			IdentificadorEntity identificador,
			List<SincronitzacioEmpresa> empreses) {
		log.debug("Sincronitzant usuaris de les empreses per l'identificador (codi=" + identificador.getEmbedded().getCodi() + ")...");
		int createCount = 0;
		int deleteCount = 0;
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador);
		for (SincronitzacioEmpresa empresaSync: empreses) {
			log.debug("\tSincronitzant usuaris de l'empresa (codi=" + empresaSync.getCodi() + ")...");
			EmpresaEntity empresaDb = null;
			for (EmpresaEntity empresa: emps) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					empresaDb = empresa;
					break;
				}
			}
			if (empresaDb != null) {
				for (UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresaDb: usuariIdentificadorEmpresaRepository.findByEmpresa(empresaDb)) {
					boolean trobat = false;
					for (SincronitzacioEmpresaUsuari usuariSync: empresaSync.getUsuaris()) {
						if (usuariIdentificadorEmpresaDb.getUsuariCodi().equals(usuariSync.getUsuariCodi())) {
							trobat = true;
							break;
						}
					}
					if (!trobat) {
						log.debug("\t\tEsborrant l'usuari de l'empresa (codi=" + usuariIdentificadorEmpresaDb.getUsuariCodi() + ")");
						usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresaDb);
						deleteCount++;
					}
				}
				for (SincronitzacioEmpresaUsuari usuariSync: empresaSync.getUsuaris()) {
					Optional<UsuariIdentificadorEntity> usuariIdentificadorDb = usuariIdentificadorRepository.findByIdentificadorAndUsuariEmbeddedCodi(
							identificador,
							usuariSync.getUsuariCodi());
					// Només realitza alguna acció si l'usuari-identificador està actiu a la base de dades
					if (usuariIdentificadorDb.isPresent() && usuariIdentificadorDb.get().getEmbedded().isActiu()) {
						Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresaDb = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorAndEmpresa(
								usuariIdentificadorDb.get(),
								empresaDb);
						if (!usuariIdentificadorEmpresaDb.isPresent()) {
							log.debug("\t\tAfegint l'usuari a l'empresa (codi=" + usuariIdentificadorDb.get().getUsuariCodi() + ")");
							// Si l'usuari-identificador-empresa no existeix a la BBDD i si a la informació de sincronització
							// crea l'usuari-identificador-empresa a la BBDD
							UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.save(
									UsuariIdentificadorEmpresaEntity.builder().
									embedded(new UsuariIdentificadorEmpresa()).
									usuariIdentificador(usuariIdentificadorDb.get()).
									empresa(empresaDb).
									build());
							if (identificador.getPerfilDefecte() != null) {
								perfilUsuariIdentificadorEmpresaRepository.save(
										PerfilUsuariIdentificadorEmpresaEntity.builder().
										embedded(new PerfilUsuariIdentificadorEmpresa()).
										perfil(identificador.getPerfilDefecte()).
										usuariIdentificadorEmpresa(usuariIdentificadorEmpresa).
										build());
							}
							createCount++;
						} else {
							// Si l'usuari-identificador-empresa existeix a la BBDD i a la informació de sincronització
							// No fa res
						}
					}
				}
			}
			log.debug("...usuaris de l'empresa sincronitzats (codi=" + empresaSync.getCodi() + ")");
		}
		log.debug("...usuaris de les empreses sincronitzats per l'identificador (" +
				"codi=" + identificador.getEmbedded().getCodi() + ", " +
				"creats=" + createCount + ", " +
				"modificats=" + 0 + ", " +
				"esborrats=" + deleteCount + ", " +
				"errors=" + 0 + ")");
		return new SincronitzacioResposta(
				createCount,
				0,
				deleteCount,
				0);
	}

	private SincronitzacioResposta sincronitzarOperarisEmpreses(
			IdentificadorEntity identificador,
			List<SincronitzacioEmpresa> empreses) {
		log.debug("Sincronitzant operaris per a les empreses de l'identificador (codi=" + identificador.getEmbedded().getCodi() + ")");
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador);
		for (SincronitzacioEmpresa empresaSync: empreses) {
			log.debug("\tSincronitzant operaris de l'empresa (codi=" + empresaSync.getCodi() + ")...");
			EmpresaEntity empresaDb = null;
			for (EmpresaEntity empresa: emps) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					empresaDb = empresa;
					break;
				}
			}
			if (empresaDb != null) {
				for (OperariEmpresaEntity operariEmpresaDb: operariEmpresaRepository.findByEmpresa(empresaDb)) {
					boolean trobat = false;
					for (SincronitzacioEmpresaOperari operariSync: empresaSync.getOperaris()) {
						if (operariEmpresaDb.getOperariCodi().equals(operariSync.getCodi())) {
							trobat = true;
							break;
						}
					}
					if (!trobat) {
						log.debug("\t\tEsborrant l'operari de l'empresa (codi=" + operariEmpresaDb.getOperariCodi() + ")");
						operariEmpresaDb.getEmbedded().setActiu(false);
						deleteCount++;
					}
				}
				for (SincronitzacioEmpresaOperari operariSync: empresaSync.getOperaris()) {
					Optional<OperariEntity> operariDb = operariRepository.findByIdentificadorAndEmbeddedCodi(
							identificador,
							operariSync.getCodi());
					// Només realitza alguna acció si l'operari està actiu a la base de dades
					if (operariDb.isPresent() && operariDb.get().getEmbedded().isActiu()) {
						Optional<OperariEmpresaEntity> operariEmpresaDb = operariEmpresaRepository.findByOperariAndEmpresa(
								operariDb.get(),
								empresaDb);
						if (operariEmpresaDb.isPresent()) {
							// Si l'operari-empresa existeix a la BBDD i a la informació de sincronització
							// activa l'operari-empresa a la BBDD
							log.debug("\t\tActivant l'operari de l'empresa (codi=" + operariEmpresaDb.get().getOperariCodi() + ")");
							if (!operariEmpresaDb.get().getEmbedded().isActiu()) {
								operariEmpresaDb.get().getEmbedded().setActiu(true);
							}
							updateCount++;
						} else {
							// Si l'operari-empresa no existeix a la BBDD i si a la informació de sincronització
							// crea l'operari-empresa a la BBDD
							log.debug("\t\tCreant l'operari de l'empresa (codi=" + operariDb.get().getEmbedded().getCodi() + ")");
							operariEmpresaRepository.save(
									OperariEmpresaEntity.builder().
									embedded(new OperariEmpresa()).
									operari(operariDb.get()).
									empresa(empresaDb).
									build());
							createCount++;
						}
					}
				}
			}
			log.debug("...operaris de l'empresa sincronitzats (codi=" + empresaSync.getCodi() + ")");
		}
		log.debug("...operaris de les empreses sincronitzats per l'identificador (" +
				"codi=" + identificador.getEmbedded().getCodi() + ", " +
				"creats=" + createCount + ", " +
				"modificats=" + updateCount + ", " +
				"esborrats=" + deleteCount + ", " +
				"errors=" + 0 + ")");
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				0);
	}

	private boolean empresaDbEqualsEmpresaSync(
			EmpresaEntity empresaDb,
			SincronitzacioEmpresa empresaSync) {
		return empresaDb.getEmbedded().getCodi().equals(empresaSync.getCodi());
	}

	private boolean usuariIdentificadorDbEqualsOperariSync(
			UsuariIdentificadorEntity usuariIdentificadorDb,
			SincronitzacioUsuari usuariSync) {
		return usuariIdentificadorDb.getUsuari().getEmbedded().getCodi().equals(usuariSync.getUsuariCodi());
	}

	private boolean operariDbEqualsOperariSync(
			OperariEntity operariDb,
			SincronitzacioOperari operariSync) {
		return operariDb.getEmbedded().getCodi().equals(operariSync.getCodi());
	}

}
