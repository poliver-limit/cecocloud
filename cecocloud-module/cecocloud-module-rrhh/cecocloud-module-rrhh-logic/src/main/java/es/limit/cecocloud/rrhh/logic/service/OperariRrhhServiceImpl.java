/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.OperariRrhh;
import es.limit.cecocloud.rrhh.logic.api.dto.OperariRrhh.OperariRrhhPk;
import es.limit.cecocloud.rrhh.logic.api.service.OperariRrhhService;
import es.limit.cecocloud.rrhh.persist.entity.OperariRrhhEntity;

/**
 * Implementació del servei de gestió de operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("OperariRrhhService")
public class OperariRrhhServiceImpl extends AbstractGenericCompositePkServiceImpl<OperariRrhh, OperariRrhhEntity, OperariRrhhPk> implements OperariRrhhService {

	@Override
	protected OperariRrhhPk getPkFromDto(OperariRrhh dto) {
		return new OperariRrhhPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
