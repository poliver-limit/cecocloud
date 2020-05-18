/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.FacturacioTipusEnum;
import es.limit.cecocloud.fact.logic.converter.GenericEntityHelper;
import es.limit.cecocloud.fact.persist.repository.EmpresaRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de sincronització d'identificadors i empreses pel
 * mòdul de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEmpresaIdentificadorSyncServiceImpl")
public class EmpresaIdentificadorSyncServiceImpl implements EmpresaIdentificadorSyncService {

	@Autowired
	private IdentificadorRepository indentificadorRepository;
	@Autowired
	private es.limit.cecocloud.fact.persist.repository.IdentificadorRepository factIndentificadorRepository;
	@Autowired
	private EmpresaRepository factEmpresaRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private GenericEntityHelper genericEntityHelper;

	@Override
	public void identificadorCreate(Identificador identificador) {
		es.limit.cecocloud.fact.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.fact.logic.api.dto.Identificador();
		identificadorFact.setCodi(identificador.getCodi());
		identificadorFact.setNom(identificador.getDescripcio());
		es.limit.cecocloud.fact.persist.entity.IdentificadorEntity entity = es.limit.cecocloud.fact.persist.entity.IdentificadorEntity.builder().
				id(identificador.getCodi()).
				embedded(identificadorFact).
				build();
		factIndentificadorRepository.save(entity);
	}

	@Override
	public void identificadorUpdate(Identificador identificador) {
		Optional<es.limit.cecocloud.fact.persist.entity.IdentificadorEntity> entity = factIndentificadorRepository.findById(identificador.getCodi());
		if (entity.isPresent()) {
			entity.get().getEmbedded().setNom(identificador.getDescripcio());
		} else {
			identificadorCreate(identificador);
		}
	}

	@Override
	public void identificadorDelete(Identificador identificador) {
		if (factIndentificadorRepository.existsById(identificador.getCodi())) {
			factIndentificadorRepository.deleteById(identificador.getCodi());
		}
	}

	@Override
	public void empresaGestioCreate(Empresa empresa) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = indentificadorRepository.getOne(userSession.getI());
		String identificadorCodi = identificador.getEmbedded().getCodi();
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificador.getEmbedded().getCodi(),
				empresa.getCodi());
		es.limit.cecocloud.fact.logic.api.dto.Empresa empresaFact = new es.limit.cecocloud.fact.logic.api.dto.Empresa();
		empresaFact.setCodi(empresa.getCodi());
		empresaFact.setNif(empresa.getNif());
		empresaFact.setNomComercial(empresa.getNom());
		empresaFact.setDomiciliComercial("N/D");
		empresaFact.setNomFiscal(empresa.getNom());
		empresaFact.setDomiciliFiscal("N/D");
		empresaFact.setFacturacioTipus(FacturacioTipusEnum.ADMINISTRACIO);
		empresaFact.setRecarrecEquivalencia(false);
		es.limit.cecocloud.fact.persist.entity.EmpresaEntity entity = es.limit.cecocloud.fact.persist.entity.EmpresaEntity.builder().
				pk(pk).
				embedded(empresaFact).
				codiPostalComercial(genericEntityHelper.getGenericCodiPostal(identificadorCodi)).
				codiPostalFiscal(genericEntityHelper.getGenericCodiPostal(identificadorCodi)).
				divisa(genericEntityHelper.getGenericDivisa(identificadorCodi)).
				build();
		factEmpresaRepository.save(entity);
	}

	@Override
	public void empresaGestioUpdate(Empresa empresa) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = indentificadorRepository.getOne(userSession.getI());
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificador.getEmbedded().getCodi(),
				empresa.getCodi());
		Optional<es.limit.cecocloud.fact.persist.entity.EmpresaEntity> entity = factEmpresaRepository.findById(pk);
		if (entity.isPresent()) {
			entity.get().getEmbedded().setNif(empresa.getNif());
			entity.get().getEmbedded().setNomComercial(empresa.getNom());
		} else {
			empresaGestioCreate(empresa);
		}
	}

	@Override
	public void empresaGestioDelete(Empresa empresa) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = indentificadorRepository.getOne(userSession.getI());
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificador.getEmbedded().getCodi(),
				empresa.getCodi());
		if (factEmpresaRepository.existsById(pk)) {
			factEmpresaRepository.deleteById(pk);
		}
	}

	@Override
	public void empresaComptableCreate(Empresa empresa) {
	}

	@Override
	public void empresaComptableUpdate(Empresa empresa) {
	}

	@Override
	public void empresaComptableDelete(Empresa empresa) {
	}

}
