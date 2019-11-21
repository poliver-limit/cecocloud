/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Empresa.EmpresaTipusEnum;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.marcatges.logic.api.dto.Marcatge;
import es.limit.cecocloud.marcatges.logic.api.dto.MarcatgeOrigen;
import es.limit.cecocloud.marcatges.logic.api.dto.Operari;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioIdentificador;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marcatges.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.marcatges.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marcatges.persist.entity.OperariEntity;
import es.limit.cecocloud.marcatges.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.marcatges.persist.repository.OperariRepository;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.CompanyiaRepository;
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
	private CompanyiaRepository companyiaRepository;
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
	public SincronitzacioResposta sincronitzarIdentificadors(
			Long companyiaId,
			List<SincronitzacioIdentificador> identificadors) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		Optional<CompanyiaEntity> companyia = companyiaRepository.findById(companyiaId);
		List<IdentificadorEntity> idfs = identificadorRepository.findByCompanyia(companyia.get());
		for (IdentificadorEntity identificador: idfs) {
			SincronitzacioIdentificador syncFound = null;
			for (SincronitzacioIdentificador identificadorSync: identificadors) {
				if (identificadorDbEqualsIdentificadorSync(identificador, identificadorSync)) {
					syncFound = identificadorSync;
					break;
				}
			}
			if (syncFound != null) {
				// Si l'identificador existeix a la BBDD i a la informació de sincronització
				// Actualitza la informació de l'identificador
				identificador.getEmbedded().setNom(syncFound.getNom());
				identificador.getEmbedded().setActiu(true);
				updateCount++;
			} else {
				// Si l'identificador existeix a la BBDD i no a la informació de sincronització
				// Desactiva l'identificador
				identificador.getEmbedded().setActiu(false);
				deleteCount++;
			}
		}
		for (SincronitzacioIdentificador identificadorSync: identificadors) {
			IdentificadorEntity dbFound = null;
			for (IdentificadorEntity identificador: idfs) {
				if (identificadorDbEqualsIdentificadorSync(identificador, identificadorSync)) {
					dbFound = identificador;
					break;
				}
			}
			if (dbFound == null) {
				// Si l'identificador no existeix a la BBDD i si a la informació de sincronització
				// Crea l'identificador a la BBDD
				Identificador identificador = new Identificador();
				identificador.setCodi(identificadorSync.getCodi());
				identificador.setNom(identificadorSync.getNom());
				identificador.setActiu(true);
				identificadorRepository.save(
						IdentificadorEntity.builder().
						embedded(identificador).
						companyia(companyia.get()).
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

	@Override
	public SincronitzacioResposta sincronitzarEmpreses(
			Long companyiaId,
			List<SincronitzacioEmpresa> empreses) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		Optional<CompanyiaEntity> companyia = companyiaRepository.findById(companyiaId);
		List<EmpresaEntity> emps = empresaRepository.findByIdentificadorCompanyia(companyia.get());
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
				Optional<IdentificadorEntity> identificador = identificadorRepository.findById(empresaSync.getIdentificadorCodi());
				empresaRepository.save(
						EmpresaEntity.builder().
						embedded(empresa).
						identificador(identificador.get()).
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

	@Override
	public SincronitzacioResposta sincronitzarOperaris(
			Long companyiaId,
			List<SincronitzacioOperari> operaris) {
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		int errorCount = 0;
		Optional<CompanyiaEntity> companyia = companyiaRepository.findById(companyiaId);
		List<OperariEntity> opes = operariRepository.findByEmpresaIdentificadorCompanyia(companyia.get());
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
				Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorCompanyiaAndIdentificadorIdAndEmbeddedCodi(
						companyia.get(),
						operariSync.getIdentificadorCodi(),
						operariSync.getCodi());
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

	@Override
	@Transactional(readOnly = true)
	public List<SincronitzacioMarcatge> marcatgeFind(
			Long companyiaId,
			List<SincronitzacioEmpresa> empreses,
			Date dataInici,
			Date dataFi) {
		Optional<CompanyiaEntity> companyia = companyiaRepository.findById(companyiaId);
		List<EmpresaEntity> emps = empresaRepository.findByIdentificadorCompanyia(companyia.get());
		List<EmpresaEntity> empresesConsulta = new ArrayList<EmpresaEntity>();
		for (EmpresaEntity empresa: emps) {
			for (SincronitzacioEmpresa empresaSync: empreses) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					empresesConsulta.add(empresa);
					break;
				}
			}
		}
		List<SincronitzacioMarcatge> resposta = new ArrayList<SincronitzacioMarcatge>();
		if (!empresesConsulta.isEmpty()) {
			List<MarcatgeEntity> marcatges = marcatgeRepository.findByEmpresaInAndBetweenDatesSync(
					empresesConsulta,
					dataInici,
					dataFi == null,
					dataFi);
			for (MarcatgeEntity marcatge: marcatges) {
				SincronitzacioMarcatge sm = new SincronitzacioMarcatge();
				Operari smUsuariEmpresa = marcatge.getOperari().getEmbedded();
				EmpresaEntity smEmpresa = marcatge.getOperari().getEmpresa();
				sm.setIdentificadorCodi(smEmpresa.getIdentificador().getId());
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
			Long companyiaId,
			List<SincronitzacioMarcatge> marcatges) {
		Optional<CompanyiaEntity> companyia = companyiaRepository.findById(companyiaId);
		int createCount = 0;
		if (marcatges != null) {
			for (SincronitzacioMarcatge marcatge: marcatges) {
				Optional<OperariEntity> operari = operariRepository.findByEmpresaIdentificadorCompanyiaAndEmpresaIdentificadorIdAndEmpresaEmbeddedCodiAndEmbeddedCodi(
						companyia.get(),
						marcatge.getIdentificadorCodi(),
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

	private boolean identificadorDbEqualsIdentificadorSync(
			IdentificadorEntity identificadorDb,
			SincronitzacioIdentificador identificadorSync) {
		return identificadorDb.getEmbedded().getCodi().equals(identificadorSync.getCodi());
	}

	private boolean empresaDbEqualsEmpresaSync(
			EmpresaEntity empresaDb,
			SincronitzacioEmpresa empresaSync) {
		return empresaDb.getIdentificador().getId().equals(empresaSync.getIdentificadorCodi())
				&& empresaDb.getEmbedded().getCodi().equals(empresaSync.getCodi());
	}

	private boolean operariDbEqualsOperariSync(
			OperariEntity operariDb,
			SincronitzacioOperari operariSync) {
		return operariDb.getEmpresa().getIdentificador().getId().equals(operariSync.getIdentificadorCodi())
				&& operariDb.getEmpresa().getEmbedded().getCodi().equals(operariSync.getEmpresaCodi())
				&& operariDb.getEmbedded().getCodi().equals(operariSync.getCodi());
	}

}
