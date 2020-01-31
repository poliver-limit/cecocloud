/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import java.util.ArrayList;
import java.util.Date;
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
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen;
import es.limit.cecocloud.marc.logic.api.dto.Operari;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marc.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.entity.OperariEntity;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.marc.persist.repository.OperariRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

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
	private MarcatgeRepository marcatgeRepository;
	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	@Transactional
	public SincronitzacioIdentificadorResposta sincronitzarIdentificador(SincronitzacioIdentificadorPeticio peticio) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(peticio.getCodi());
		if (identificador.isPresent()) {
			SincronitzacioResposta empresesResposta = sincronitzarEmpreses(
					identificador.get(),
					peticio.getEmpreses());
			SincronitzacioResposta operarisResposta = sincronitzarOperaris(
					identificador.get(),
					peticio.getOperaris());
			return new SincronitzacioIdentificadorResposta(
					empresesResposta,
					operarisResposta);
		} else {
			throw new EntityNotFoundException("IdentificadorEntity#codi=" + peticio.getCodi());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<SincronitzacioMarcatge> marcatgeFind(
			String identificadorCodi,
			Date dataInici,
			Date dataFi) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador.get());
		List<SincronitzacioMarcatge> resposta = new ArrayList<SincronitzacioMarcatge>();
		if (!emps.isEmpty()) {
			List<MarcatgeEntity> marcatges = marcatgeRepository.findByEmpresaInAndBetweenDatesSync(
					emps,
					dataInici,
					dataFi == null,
					dataFi);
			for (MarcatgeEntity marcatge: marcatges) {
				SincronitzacioMarcatge sm = new SincronitzacioMarcatge();
				Operari smUsuariEmpresa = marcatge.getOperari().getEmbedded();
				EmpresaEntity smEmpresa = marcatge.getOperari().getEmpresa();
				sm.setEmpresaCodi(smEmpresa.getEmbedded().getCodi());
				sm.setOperariCodi(smUsuariEmpresa.getCodi());
				sm.setData(marcatge.getEmbedded().getData());
				sm.setLatitud(marcatge.getEmbedded().getLatitud());
				sm.setLongitud(marcatge.getEmbedded().getLongitud());
				resposta.add(sm);
			}
		}
		return resposta;
	}

	@Override
	@Transactional
	public SincronitzacioResposta marcatgeCreate(
			String identificadorCodi,
			List<SincronitzacioMarcatge> marcatges) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
		int createCount = 0;
		if (marcatges != null) {
			for (SincronitzacioMarcatge marcatge: marcatges) {
				Optional<OperariEntity> operari = operariRepository.findByEmpresaIdentificadorAndEmpresaEmbeddedCodiAndEmbeddedCodi(
						identificador.get(),
						marcatge.getEmpresaCodi(),
						marcatge.getOperariCodi());
				MarcatgeEntity marcatgeExistent = marcatgeRepository.findByOperariAndEmbeddedData(
						operari.get(),
						marcatge.getData());
				if (marcatgeExistent == null) {
					Marcatge embedded = new Marcatge();
					embedded.setData(marcatge.getData());
					embedded.setLatitud(marcatge.getLatitud());
					embedded.setLongitud(marcatge.getLongitud());
					embedded.setOrigen(MarcatgeOrigen.CECOGEST);
					marcatgeRepository.save(
							MarcatgeEntity.builder().
							operari(operari.get()).
							embedded(embedded).
							build());
					createCount++;
				}
			}
		}
		return new SincronitzacioResposta(
				createCount,
				0,
				0,
				0);
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

	private SincronitzacioResposta sincronitzarOperaris(
			IdentificadorEntity identificador,
			List<SincronitzacioOperari> operaris) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		List<OperariEntity> opes = operariRepository.findByEmpresaIdentificador(identificador);
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
				operari.getEmbedded().setDataInici(new Date());
				operari.getEmbedded().setDataFi(null);
				updateCount++;
			} else {
				// Si l'operari existeix a la BBDD i no a la informació de sincronització
				// Desactiva l'operari
				operari.getEmbedded().setDataFi(new Date());
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
				operari.setDataInici(new Date());
				Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorAndEmbeddedCodi(
						identificador,
						operariSync.getEmpresaCodi());
				Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(operariSync.getUsuariCodi());
				operariRepository.save(
						OperariEntity.builder().
						embedded(operari).
						empresa(empresa.get()).
						usuari(usuari.get()).
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

	private boolean empresaDbEqualsEmpresaSync(
			EmpresaEntity empresaDb,
			SincronitzacioEmpresa empresaSync) {
		return empresaDb.getEmbedded().getCodi().equals(empresaSync.getCodi());
	}

	private boolean operariDbEqualsOperariSync(
			OperariEntity operariDb,
			SincronitzacioOperari operariSync) {
		return operariDb.getEmpresa().getEmbedded().getCodi().equals(operariSync.getEmpresaCodi())
				&& operariDb.getEmbedded().getCodi().equals(operariSync.getCodi());
	}

}
