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
import es.limit.cecocloud.logic.api.dto.SincronitzacioCompanyia;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaAmbOperaris;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgeConsulta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.repository.CompanyiaRepository;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.repository.UsuariEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariRepository;

/**
 * Implementació del servei encarregat de gestionar la sincronització de la informació provinent
 * de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SincronitzacioServiceImpl implements SincronitzacioService {

	private CompanyiaRepository companyiaRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private UsuariEmpresaRepository usuariEmpresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;
	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	@Transactional
	public SincronitzacioResposta sincronitzar(SincronitzacioCompanyia sincronitzacioCompanyia) {
		// TODO Revisar si l'usuari te permisos
		Optional<CompanyiaEntity> companyia = companyiaRepository.findByEmbeddedCodi(
				sincronitzacioCompanyia.getCodi());
		List<EmpresaEntity> empreses = empresaRepository.findByParent(companyia.get());
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
						parent(companyia.get()).
						embedded(null).
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
	public List<SincronitzacioMarcatge> marcatgeFind(SincronitzacioMarcatgeConsulta consulta) {
		// TODO Revisar si l'usuari te permisos
		Optional<CompanyiaEntity> companyia = companyiaRepository.findByEmbeddedCodi(
				consulta.getCompanyiaCodi());
		List<EmpresaEntity> empreses = empresaRepository.findByParent(companyia.get());
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
			List<MarcatgeEntity> marcatges = marcatgeRepository.findByEmpresaIn(
					empresesConsulta,
					consulta.getDataInici(),
					consulta.getDataFi() == null,
					consulta.getDataFi());
			for (MarcatgeEntity marcatge: marcatges) {
				SincronitzacioMarcatge sm = new SincronitzacioMarcatge();
				UsuariEmpresa smUsuariEmpresa = marcatge.getParent().getEmbedded();
				Empresa smEmpresa = marcatge.getParent().getParent2().getEmbedded();
				sm.setEmpresaIdentificadorCodi(smEmpresa.getIdentificadorCodi());
				sm.setEmpresaCodi(smEmpresa.getCodi());
				sm.setOperariCodi(smUsuariEmpresa.getOperariCodi());
				sm.setData(marcatge.getEmbedded().getData());
				sm.setDataCreacio(marcatge.getEmbedded().getDataCreacio());
				resposta.add(sm);
			}
		}
		return resposta;
	}

	private void updateOperaris(
			EmpresaEntity empresa,
			SincronitzacioEmpresaAmbOperaris syncEmpresa) {
		List<UsuariEmpresaEntity> usuarisEmpreses = usuariEmpresaRepository.findByParent2AndDataFiNull(empresa);
		for (SincronitzacioOperari operari: syncEmpresa.getOperaris()) {
			UsuariEmpresaEntity usuariEmpresaTrobat = null;
			for (UsuariEmpresaEntity usuariEmpresa: usuarisEmpreses) {
				if (usuariEmpresa.getEmbedded().getOperariCodi().equals(operari.getCodi())) {
					usuariEmpresaTrobat = usuariEmpresa;
					break;
				}
			}
			if (usuariEmpresaTrobat != null) {
				// Si l'operari ja és a la base de dades no fa res
			} else {
				// Si l'operari no existeix el crea
				UsuariEmpresa perCrear = new UsuariEmpresa();
				perCrear.setOperariCodi(operari.getCodi());
				perCrear.setDataInici(new Date());
				usuariEmpresaRepository.save(
						UsuariEmpresaEntity.builder().
						parent1(usuariRepository.findByEmbeddedCodi(operari.getUsuariCodi()).get()).
						parent2(empresa).
						embedded(perCrear).
						build());
			}
		}
		// Desactiva els operaris existents a la BBDD que no es troben a l'empresa enviada des de CECOGEST
		for (UsuariEmpresaEntity usuariEmpresa: usuarisEmpreses) {
			boolean trobat = false;
			for (SincronitzacioOperari operari: syncEmpresa.getOperaris()) {
				if (usuariEmpresa.getEmbedded().getOperariCodi().equals(operari.getCodi())) {
					trobat = true;
					break;
				}
			}
			if (!trobat) {
				usuariEmpresa.getEmbedded().setDataFi(new Date());
			}
		}
	}

	private boolean empresaDbEqualsEmpresaSync(
			EmpresaEntity empresaDb,
			SincronitzacioEmpresa empresaSync) {
		return empresaDb.getEmbedded().getIdentificadorCodi().equals(empresaSync.getIdentificadorCodi()) && empresaDb.getEmbedded().getCodi().equals(empresaSync.getCodi());
	}

}
