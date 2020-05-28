/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;
import es.limit.cecocloud.rrhh.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.rrhh.persist.repository.IdentificadorRepository;
import lombok.extern.slf4j.Slf4j;
	
/**
 * Implementació del servei de sincronització d'identificadors i empreses pel
 * mòdul de recursos humans.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service("rrhhEmpresaIdentificadorSyncServiceImpl")
public class EmpresaIdentificadorSyncServiceImpl implements EmpresaIdentificadorSyncService {

	@Autowired
	private IdentificadorRepository indentificadorRepository;

	@Override
	public void identificadorCreate(Identificador identificador) {
		log.debug("Propagant creació d'un identificador a dins el mòdul de recursos humans (codi=" + identificador.getCodi() + ")");
		es.limit.cecocloud.rrhh.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.rrhh.logic.api.dto.Identificador();
		identificadorFact.setCodi(identificador.getCodi());
		identificadorFact.setNom(identificador.getDescripcio());
		IdentificadorEntity entity = IdentificadorEntity.builder().id(identificador.getCodi()).embedded(identificadorFact).build();
		indentificadorRepository.save(entity);
	}

	@Override
	public void identificadorUpdate(Identificador identificador) {
		log.debug("Propagant modificació d'un identificador a dins el mòdul de recursos humans (codi=" + identificador.getCodi() + ")");
		Optional<IdentificadorEntity> entity = indentificadorRepository.findById(identificador.getCodi());
		if (entity.isPresent()) {
			es.limit.cecocloud.rrhh.logic.api.dto.Identificador identificadorFact = new es.limit.cecocloud.rrhh.logic.api.dto.Identificador();
			identificadorFact.setCodi(identificador.getCodi());
			identificadorFact.setNom(identificador.getDescripcio());
			entity.get().update(identificadorFact);
		} else {
			identificadorCreate(identificador);
		}
	}

	@Override
	public void identificadorDelete(Identificador identificador) {
		log.debug("Propagant eliminació d'un identificador a dins el mòdul de recursos humans (codi=" + identificador.getCodi() + ")");
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
