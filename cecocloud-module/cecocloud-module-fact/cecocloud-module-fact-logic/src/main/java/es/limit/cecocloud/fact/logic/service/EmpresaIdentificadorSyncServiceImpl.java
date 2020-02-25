/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.fact.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;

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

	@Override
	public void identificadorCreate(Identificador identificador) {
		es.limit.cecocloud.fact.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.fact.logic.api.dto.Identificador();
		identificadorFact.setCodi(identificador.getCodi());
		identificadorFact.setNom(identificador.getDescripcio());
		IdentificadorEntity entity = IdentificadorEntity.builder().id(identificador.getCodi()).embedded(identificadorFact).build();
		indentificadorRepository.save(entity);
	}

	@Override
	public void identificadorUpdate(Identificador identificador) {
		Optional<IdentificadorEntity> entity = indentificadorRepository.findById(identificador.getCodi());
		if (entity.isPresent()) {
			es.limit.cecocloud.fact.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.fact.logic.api.dto.Identificador();
			identificadorFact.setCodi(identificador.getCodi());
			identificadorFact.setNom(identificador.getDescripcio());
			entity.get().update(identificadorFact);
		} else {
			identificadorCreate(identificador);
		}
	}

	@Override
	public void identificadorDelete(Identificador identificador) {
		if (indentificadorRepository.existsById(identificador.getCodi())) {
			indentificadorRepository.deleteById(identificador.getCodi());
		}
	}

	@Override
	public void empresaGestioCreate(Empresa empresa) {
		// TODO Auto-generated method stub
	}

	@Override
	public void empresaGestioUpdate(Empresa empresa) {
		// TODO Auto-generated method stub
	}

	@Override
	public void empresaGestioDelete(Empresa empresa) {
		// TODO Auto-generated method stub
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
