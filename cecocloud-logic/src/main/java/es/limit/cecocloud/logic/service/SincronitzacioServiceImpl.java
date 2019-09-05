/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioCompanyia;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaAmbOperaris;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgesConsulta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgesEnviament;
import es.limit.cecocloud.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.CompanyiaRepository;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;
import es.limit.cecocloud.persist.repository.UsuariRepository;

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
	private EmpresaRepository empresaRepository;
	@Autowired
	private OperariRepository operariRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;
	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	@Transactional
	public SincronitzacioResposta sincronitzar(SincronitzacioCompanyia sincronitzacioCompanyia) {
		// TODO Revisar si l'usuari te permisos
		Optional<CompanyiaEntity> companyia = companyiaRepository.findByEmbeddedCodi(
				sincronitzacioCompanyia.getCompanyiaCodi());
		List<EmpresaEntity> empreses = empresaRepository.findByCompanyia(companyia.get());
		int createCount = 0;
		int updateCount = 0;
		int deleteCount = 0;
		for (EmpresaEntity empresa: empreses) {
			SincronitzacioEmpresaAmbOperaris syncFound = null;
			for (SincronitzacioEmpresaAmbOperaris empresaSync: sincronitzacioCompanyia.getEmpreses()) {
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
				// Actualitza els operaris
				updateOperaris(empresa, syncFound);
				updateCount++;
			} else {
				// Si l'empresa existeix a la BBDD i no a la informació de sincronització
				// Desactiva l'empresa
				empresa.getEmbedded().setActiva(false);
				deleteCount++;
			}
		}
		for (SincronitzacioEmpresaAmbOperaris empresaSync: sincronitzacioCompanyia.getEmpreses()) {
			EmpresaEntity dbFound = null;
			for (EmpresaEntity empresa: empreses) {
				if (empresaDbEqualsEmpresaSync(empresa, empresaSync)) {
					dbFound = empresa;
					break;
				}
			}
			if (dbFound == null) {
				// Si l'empresa no existeix a la BBDD i si a la informació de sincronització
				// Crea l'empresa a la BBDD
				Empresa empresa = new Empresa();
				empresa.setIdentificadorCodi(empresaSync.getIdentificadorCodi());
				empresa.setCodi(empresaSync.getCodi());
				empresa.setNif(empresaSync.getNif());
				empresa.setNom(empresaSync.getNom());
				empresa.setActiva(true);
				EmpresaEntity empresaCreada = empresaRepository.save(
						EmpresaEntity.builder().
						embedded(empresa).
						companyia(companyia.get()).
						build());
				// Actualitza els operaris
				updateOperaris(empresaCreada, empresaSync);
				createCount++;
			}
		}
		return new SincronitzacioResposta(
				createCount,
				updateCount,
				deleteCount);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SincronitzacioMarcatge> marcatgeFind(SincronitzacioMarcatgesConsulta consulta) {
		// TODO Revisar si l'usuari te permisos
		Optional<CompanyiaEntity> companyia = companyiaRepository.findByEmbeddedCodi(
				consulta.getCompanyiaCodi());
		List<EmpresaEntity> empreses = empresaRepository.findByCompanyia(companyia.get());
		List<EmpresaEntity> empresesConsulta = new ArrayList<EmpresaEntity>();
		for (EmpresaEntity empresa: empreses) {
			for (SincronitzacioEmpresa empresaSync: consulta.getEmpreses()) {
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
					consulta.getDataInici(),
					consulta.getDataFi() == null,
					consulta.getDataFi());
			for (MarcatgeEntity marcatge: marcatges) {
				SincronitzacioMarcatge sm = new SincronitzacioMarcatge();
				Operari smUsuariEmpresa = marcatge.getOperari().getEmbedded();
				Empresa smEmpresa = marcatge.getOperari().getEmpresa().getEmbedded();
				sm.setEmpresaIdentificadorCodi(smEmpresa.getIdentificadorCodi());
				sm.setEmpresaCodi(smEmpresa.getCodi());
				sm.setOperariCodi(smUsuariEmpresa.getCodi());
				sm.setData(marcatge.getEmbedded().getData());
				resposta.add(sm);
			}
		}
		return resposta;
	}

	@Override
	@Transactional
	public SincronitzacioResposta marcatgeCreate(SincronitzacioMarcatgesEnviament marcatges) {
		// TODO Revisar si l'usuari te permisos
		Optional<CompanyiaEntity> companyia = companyiaRepository.findByEmbeddedCodi(
				marcatges.getCompanyiaCodi());
		int createCount = 0;
		if (marcatges.getMarcatges() != null) {
			for (SincronitzacioMarcatge marcatge: marcatges.getMarcatges()) {
				Optional<OperariEntity> operari = operariRepository.findByEmpresaCompanyiaAndEmpresaEmbeddedIdentificadorCodiAndEmpresaEmbeddedCodiAndEmbeddedCodi(
						companyia.get(),
						marcatge.getEmpresaIdentificadorCodi(),
						marcatge.getEmpresaCodi(),
						marcatge.getOperariCodi());
				MarcatgeEntity marcatgeExistent = marcatgeRepository.findByOperariAndEmbeddedData(
						operari.get(),
						marcatge.getData());
				if (marcatgeExistent == null) {
					Marcatge embedded = new Marcatge();
					embedded.setData(marcatge.getData());
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
				0);
	}

	private void updateOperaris(
			EmpresaEntity empresa,
			SincronitzacioEmpresaAmbOperaris syncEmpresa) {
		List<OperariEntity> usuarisEmpreses = operariRepository.findByEmpresaAndDataFiNull(empresa);
		for (SincronitzacioOperari operari: syncEmpresa.getOperaris()) {
			OperariEntity usuariEmpresaTrobat = null;
			for (OperariEntity usuariEmpresa: usuarisEmpreses) {
				if (usuariEmpresa.getEmbedded().getCodi().equals(operari.getCodi())) {
					usuariEmpresaTrobat = usuariEmpresa;
					break;
				}
			}
			if (usuariEmpresaTrobat != null) {
				// Si l'operari ja és a la base de dades
				if (!usuariEmpresaTrobat.getUsuari().getEmbedded().getCodi().equals(operari.getUsuariCodi())) {
					// Si l'usuari és diferent del que hi ha a la BBDD l'actualitza
					usuariEmpresaTrobat.getEmbedded().setDataFi(new Date());
					createUsuariEmpresa(empresa, operari);
				}
			} else {
				// Si l'operari no existeix el crea
				createUsuariEmpresa(empresa, operari);
			}
		}
		// Desactiva els operaris existents a la BBDD que no es troben a l'empresa enviada des de CECOGEST
		for (OperariEntity usuariEmpresa: usuarisEmpreses) {
			boolean trobat = false;
			for (SincronitzacioOperari operari: syncEmpresa.getOperaris()) {
				if (usuariEmpresa.getEmbedded().getCodi().equals(operari.getCodi())) {
					trobat = true;
					break;
				}
			}
			if (!trobat) {
				usuariEmpresa.getEmbedded().setDataFi(new Date());
			}
		}
	}

	private OperariEntity createUsuariEmpresa(
			EmpresaEntity empresa,
			SincronitzacioOperari operari) {
		Operari perCrear = new Operari();
		perCrear.setCodi(operari.getCodi());
		perCrear.setDataInici(new Date());
		return operariRepository.save(
				OperariEntity.builder().
				usuari(usuariRepository.findByEmbeddedCodi(operari.getUsuariCodi()).get()).
				empresa(empresa).
				embedded(perCrear).
				build());
	}

	private boolean empresaDbEqualsEmpresaSync(
			EmpresaEntity empresaDb,
			SincronitzacioEmpresa empresaSync) {
		return empresaDb.getEmbedded().getIdentificadorCodi().equals(empresaSync.getIdentificadorCodi()) && empresaDb.getEmbedded().getCodi().equals(empresaSync.getCodi());
	}

}
