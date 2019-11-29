/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.facturacio.logic.api.service.DepartamentService;
import es.limit.cecocloud.facturacio.persist.entity.DepartamentEntity;

/**
 * Implementació del servei de gestió de departaments.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DepartamentServiceImpl extends AbstractGenericCompositePkServiceImpl<Departament, DepartamentEntity, DepartamentPk> implements DepartamentService {

	@Override
	protected DepartamentPk getPkFromDto(Departament dto) {
		return new DepartamentPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getEmpresa().getId());
	}


}
