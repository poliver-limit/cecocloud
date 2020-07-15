/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.helper.GenericEntityHelper;
import es.limit.cecocloud.ecom.persist.repository.EmpresaRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació del servei de sincronització d'identificadors i empreses pel
 * mòdul de ecommerce.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service("ecomEmpresaIdentificadorSyncServiceImpl")
public class EmpresaIdentificadorSyncServiceImpl implements EmpresaIdentificadorSyncService {

	@Autowired
	private IdentificadorRepository indentificadorRepository;
	
	@Autowired
	private es.limit.cecocloud.ecom.persist.repository.IdentificadorRepository ecomIndentificadorRepository;
	
	@Autowired
	private EmpresaRepository ecomEmpresaRepository;
	
	@Autowired
	private GenericEntityHelper genericEntityHelper;

	@Override
	public void identificadorCreate(Identificador identificador) {
		es.limit.cecocloud.ecom.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.ecom.logic.api.dto.Identificador();
		identificadorFact.setCodi(identificador.getCodi());
		identificadorFact.setNom(identificador.getDescripcio());
		es.limit.cecocloud.ecom.persist.entity.IdentificadorEntity entity = es.limit.cecocloud.ecom.persist.entity.IdentificadorEntity.builder().id(identificador.getCodi()).embedded(identificadorFact).build();
		ecomIndentificadorRepository.save(entity);
	}

	@Override
	public void identificadorUpdate(Identificador identificador) {
		Optional<es.limit.cecocloud.ecom.persist.entity.IdentificadorEntity> entity = ecomIndentificadorRepository.findById(identificador.getCodi());
		if (entity.isPresent()) {
			es.limit.cecocloud.ecom.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.ecom.logic.api.dto.Identificador();
			identificadorFact.setCodi(identificador.getCodi());
			identificadorFact.setNom(identificador.getDescripcio());
			entity.get().update(identificadorFact);
		} else {
			identificadorCreate(identificador);
		}
	}

	@Override
	public void identificadorDelete(Identificador identificador) {
		if (ecomIndentificadorRepository.existsById(identificador.getCodi())) {
			ecomIndentificadorRepository.deleteById(identificador.getCodi());
		}
	}

	@Override
	public void empresaGestioCreate(Empresa empresa) {
		IdentificadorEntity identificador = indentificadorRepository.getOne(empresa.getIdentificador().getId());
		String identificadorCodi = identificador.getEmbedded().getCodi();
		log.debug("Propagant creació d'una empresa a dins el mòdul de ecommerce (" +
				"identificadorCodi=" + identificadorCodi + ", " +
				"codi=" + empresa.getCodi() + ")");
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				empresa.getCodi());
		es.limit.cecocloud.ecom.logic.api.dto.Empresa empresaEcom = new es.limit.cecocloud.ecom.logic.api.dto.Empresa();
		empresaEcom.setCodi(empresa.getCodi());		
		empresaEcom.setNomComercial(empresa.getNom());		
		es.limit.cecocloud.ecom.persist.entity.EmpresaEntity entity = es.limit.cecocloud.ecom.persist.entity.EmpresaEntity.builder().
				pk(pk).
				embedded(empresaEcom).		
				divisa(genericEntityHelper.getGenericDivisa(identificadorCodi)).
				build();
		ecomEmpresaRepository.save(entity);
	}

	@Override
	public void empresaGestioUpdate(Empresa empresa) {
		IdentificadorEntity identificador = indentificadorRepository.getOne(empresa.getIdentificador().getId());
		String identificadorCodi = identificador.getEmbedded().getCodi();
		log.debug("Propagant modificació d'una empresa a dins el mòdul de ecommerce (" +
				"identificadorCodi=" + identificadorCodi + ", " +
				"codi=" + empresa.getCodi() + ")");
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificador.getEmbedded().getCodi(),
				empresa.getCodi());
		Optional<es.limit.cecocloud.ecom.persist.entity.EmpresaEntity> entity = ecomEmpresaRepository.findById(pk);
		if (entity.isPresent()) {			
			entity.get().getEmbedded().setNomComercial(empresa.getNom());
		} else {
			empresaGestioCreate(empresa);
		}
	}

	@Override
	public void empresaGestioDelete(Empresa empresa) {
		IdentificadorEntity identificador = indentificadorRepository.getOne(empresa.getIdentificador().getId());
		String identificadorCodi = identificador.getEmbedded().getCodi();
		log.debug("Propagant eliminació d'una empresa a dins el mòdul de ecommerce (" +
				"identificadorCodi=" + identificadorCodi + ", " +
				"codi=" + empresa.getCodi() + ")");
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificador.getEmbedded().getCodi(),
				empresa.getCodi());
		if (ecomEmpresaRepository.existsById(pk)) {
			genericEntityHelper.deleteEmpresaGenericEntities(
					identificador.getEmbedded().getCodi(),
					empresa.getCodi());
			ecomEmpresaRepository.deleteById(pk);
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
