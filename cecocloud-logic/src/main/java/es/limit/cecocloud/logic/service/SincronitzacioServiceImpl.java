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
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresesResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioUsuari;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;

/**
 * Implementació del servei encarregat de gestionar la sincronització de la informació provinent
 * de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
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

	@Override
	@Transactional
	public SincronitzacioIdentificadorResposta sincronitzarIdentificador(SincronitzacioIdentificadorPeticio peticio) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(peticio.getCodi());
		if (identificador.isPresent()) {
			SincronitzacioEmpresesResposta empresesResposta = sincronitzarEmpreses(
					identificador.get(),
					peticio.getEmpreses());
			SincronitzacioResposta usuarisResposta = sincronitzarUsuaris(
					identificador.get(),
					peticio.getUsuaris());
			SincronitzacioResposta operarisResposta = sincronitzarOperaris(
					identificador.get(),
					peticio.getOperaris());
			SincronitzacioResposta operarisEmpresesResposta = sincronitzarOperarisEmpreses(
					identificador.get(),
					peticio.getEmpreses());
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
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		// TODO controlar el màxim autoritzat d'empreses segons la llicència
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador);
		for (EmpresaEntity empresa: emps) {
			SincronitzacioEmpresa syncFound = null;
			for (SincronitzacioEmpresa empresaSync: empreses) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					syncFound = empresaSync;
					break;
				}
			}
			if (syncFound != null) {
				// Si l'empresa existeix a la BBDD i a la informació de sincronització
				// actualitza la informació de l'empresa
				empresa.getEmbedded().setNif(syncFound.getNif());
				empresa.getEmbedded().setNom(syncFound.getNom());
				empresa.getEmbedded().setActiva(true);
				updateCount++;
			} else {
				// Si l'empresa existeix a la BBDD i no a la informació de sincronització
				// desactiva l'empresa
				empresa.getEmbedded().setActiva(false);
				for (OperariEmpresaEntity operariEmpresa: operariEmpresaRepository.findByEmpresa(empresa)) {
					operariEmpresa.getEmbedded().setActiu(false);
				}
				deleteCount++;
			}
		}
		for (SincronitzacioEmpresa empresaSync: empreses) {
			EmpresaEntity dbFound = null;
			for (EmpresaEntity empresa: emps) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					dbFound = empresa;
					break;
				}
			}
			if (dbFound == null) {
				// Si l'empresa no existeix a la BBDD i si a la informació de sincronització
				// crea l'empresa a la BBDD
				Empresa empresa = new Empresa();
				empresa.setCodi(empresaSync.getCodi());
				empresa.setNif(empresaSync.getNif());
				empresa.setNom(empresaSync.getNom());
				empresa.setTipus(EmpresaTipusEnum.GESTIO);
				empresa.setActiva(true);
				empresaRepository.save(
						EmpresaEntity.builder().
						embedded(empresa).
						identificador(identificador).
						build());
				createCount++;
			}
		}
		return new SincronitzacioEmpresesResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount,
				null);
	}

	private SincronitzacioResposta sincronitzarUsuaris(
			IdentificadorEntity identificador,
			List<SincronitzacioUsuari> usuaris) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<UsuariIdentificadorEntity> usuidfs = usuariIdentificadorRepository.findByIdentificador(identificador);
		for (UsuariIdentificadorEntity usuariIdentificador: usuidfs) {
			SincronitzacioUsuari syncFound = null;
			for (SincronitzacioUsuari usuariSync: usuaris) {
				if (usuariIdentificadorDbEqualsOperariSync(usuariIdentificador, usuariSync)) {
					syncFound = usuariSync;
					break;
				}
			}
			if (syncFound != null) {
				// Si l'operari existeix a la BBDD i a la informació de sincronització
				// actualitza la informació de l'operari
				usuariIdentificador.getEmbedded().setActiu(true);
				updateCount++;
			} else {
				// Si l'operari existeix a la BBDD i no a la informació de sincronització
				// desactiva l'usuariIdentificador de l'empresa
				usuariIdentificador.getEmbedded().setActiu(false);
				for (UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa: usuariIdentificadorEmpresaRepository.findByUsuariIdentificador(usuariIdentificador)) {
					usuariIdentificadorEmpresaRepository.delete(usuariIdentificadorEmpresa);
					//usuariIdentificadorEmpresa.getEmbedded().setActiu(false);
				}
				deleteCount++;
			}
		}
		for (SincronitzacioUsuari usuariSync: usuaris) {
			UsuariIdentificadorEntity dbFound = null;
			for (UsuariIdentificadorEntity usuariIdentificador: usuidfs) {
				if (usuariIdentificadorDbEqualsOperariSync(usuariIdentificador, usuariSync)) {
					dbFound = usuariIdentificador;
					break;
				}
			}
			if (dbFound == null) {
				// Si l'usuariIdentificador no existeix a la BBDD i si a la informació de sincronització
				// crea l'usuariIdentificador a la BBDD
				Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(usuariSync.getUsuariCodi());
				if (usuari.isPresent()) {
					UsuariIdentificador usuariIdentificador = new UsuariIdentificador();
					usuariIdentificador.setActiu(true);
					usuariIdentificadorRepository.save(
							UsuariIdentificadorEntity.builder().
							embedded(usuariIdentificador).
							usuari(usuari.get()).
							identificador(identificador).
							build());
					createCount++;
				} else {
					errorCount++;
				}
			}
		}
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
	}

	private SincronitzacioResposta sincronitzarOperaris(
			IdentificadorEntity identificador,
			List<SincronitzacioOperari> operaris) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<OperariEntity> opes = operariRepository.findByIdentificador(identificador);
		for (OperariEntity operari: opes) {
			SincronitzacioOperari syncFound = null;
			for (SincronitzacioOperari operariSync: operaris) {
				if (operariDbEqualsOperariSync(operari, operariSync)) {
					syncFound = operariSync;
					break;
				}
			}
			if (syncFound != null) {
				// Si l'operari existeix a la BBDD i a la informació de sincronització
				// actualitza la informació de l'operari
				operari.getEmbedded().setActiu(true);
				updateCount++;
			} else {
				// Si l'operari existeix a la BBDD i no a la informació de sincronització
				// desactiva l'operari
				operari.getEmbedded().setActiu(false);
				for (OperariEmpresaEntity operariEmpresa: operariEmpresaRepository.findByOperari(operari)) {
					operariEmpresa.getEmbedded().setActiu(false);
				}
				deleteCount++;
			}
		}
		for (SincronitzacioOperari operariSync: operaris) {
			OperariEntity dbFound = null;
			for (OperariEntity operari: opes) {
				if (operariDbEqualsOperariSync(operari, operariSync)) {
					dbFound = operari;
					break;
				}
			}
			if (dbFound == null) {
				// Si l'operari no existeix a la BBDD i si a la informació de sincronització
				// crea l'operari a la BBDD
				Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(operariSync.getUsuariCodi());
				if (usuari.isPresent()) {
					Operari operari = new Operari();
					operari.setCodi(operariSync.getCodi());
					operari.setActiu(true);
					operariRepository.save(
							OperariEntity.builder().
							embedded(operari).
							usuari(usuari.get()).
							identificador(identificador).
							build());
					createCount++;
				} else {
					errorCount++;
				}
			}
		}
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
	}

	private SincronitzacioResposta sincronitzarOperarisEmpreses(
			IdentificadorEntity identificador,
			List<SincronitzacioEmpresa> empreses) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador);
		for (SincronitzacioEmpresa empresaSync: empreses) {
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
							if (!operariEmpresaDb.get().getEmbedded().isActiu()) {
								operariEmpresaDb.get().getEmbedded().setActiu(true);
							}
							updateCount++;
						} else {
							// Si l'operari-empresa no existeix a la BBDD i si a la informació de sincronització
							// crea l'operari-empresa a la BBDD
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
		}
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
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
