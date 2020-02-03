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
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;

/**
 * Implementació del servei encarregat de gestionar la sincronització de la informació provinent
 * de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SincronitzacioServiceImpl implements SincronitzacioService {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private OperariRepository operariRepository;
	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	@Transactional
	public SincronitzacioIdentificadorResposta sincronitzarIdentificador(SincronitzacioIdentificadorPeticio peticio) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(peticio.getCodi());
		if (identificador.isPresent()) {
			SincronitzacioResposta operarisResposta = sincronitzarOperaris(
					identificador.get(),
					peticio.getOperaris());
			SincronitzacioResposta empresesResposta = sincronitzarEmpreses(
					identificador.get(),
					peticio.getEmpreses());
			return new SincronitzacioIdentificadorResposta(
					empresesResposta,
					operarisResposta);
		} else {
			throw new EntityNotFoundException("IdentificadorEntity#codi=" + peticio.getCodi());
		}
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
				// Actualitza la informació de l'operari
				operari.getEmbedded().setActiu(true);
				updateCount++;
			} else {
				// Si l'operari existeix a la BBDD i no a la informació de sincronització
				// Desactiva l'operari
				operari.getEmbedded().setActiu(false);
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
				// Crea l'operari a la BBDD
				Operari operari = new Operari();
				operari.setCodi(operariSync.getCodi());
				operari.setActiu(true);
				Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(operariSync.getUsuariCodi());
				operariRepository.save(
						OperariEntity.builder().
						embedded(operari).
						usuari(usuari.get()).
						identificador(identificador).
						build());
				createCount++;
			}
		}
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
	}

	private SincronitzacioResposta sincronitzarEmpreses(
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
				// Actualitza la informació de l'empresa
				empresa.getEmbedded().setNif(syncFound.getNif());
				empresa.getEmbedded().setNom(syncFound.getNom());
				empresa.getEmbedded().setActiva(true);
				updateCount++;
			} else {
				// Si l'empresa existeix a la BBDD i no a la informació de sincronització
				// Desactiva l'empresa
				empresa.getEmbedded().setActiva(false);
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
				// Crea l'empresa a la BBDD
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
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount,
				errorCount);
	}

	private boolean operariDbEqualsOperariSync(
			OperariEntity operariDb,
			SincronitzacioOperari operariSync) {
		return operariDb.getEmbedded().getCodi().equals(operariSync.getCodi());
	}

	private boolean empresaDbEqualsEmpresaSync(
			EmpresaEntity empresaDb,
			SincronitzacioEmpresa empresaSync) {
		return empresaDb.getEmbedded().getCodi().equals(empresaSync.getCodi());
	}

}
