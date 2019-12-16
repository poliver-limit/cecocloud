/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.EmpresaRrhh;
import es.limit.cecocloud.rrhh.logic.api.dto.EmpresaRrhh.EmpresaRrhhPk;
import es.limit.cecocloud.rrhh.logic.api.service.EmpresaRrhhService;
import es.limit.cecocloud.rrhh.persist.entity.EmpresaRrhhEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("EmpresaRrhhServive")
public class EmpresaRrhhServiceImpl extends AbstractGenericCompositePkServiceImpl<EmpresaRrhh, EmpresaRrhhEntity, EmpresaRrhhPk> implements EmpresaRrhhService {

	@Override
	protected EmpresaRrhhPk getPkFromDto(EmpresaRrhh dto) {
		return new EmpresaRrhhPk(
				dto.getIdentificador().getId(),
				dto.getId()
				);
	}


}
