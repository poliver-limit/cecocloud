/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.EmpresaFact;
import es.limit.cecocloud.facturacio.logic.api.dto.EmpresaFact.EmpresaFactPk;
import es.limit.cecocloud.facturacio.logic.api.service.EmpresaFactService;
import es.limit.cecocloud.facturacio.persist.entity.EmpresaFactEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEmpresaServiceImpl")
public class EmpresaFactServiceImpl extends AbstractGenericCompositePkServiceImpl<EmpresaFact, EmpresaFactEntity, EmpresaFactPk> implements EmpresaFactService {

	@Override
	protected EmpresaFactPk getPkFromDto(EmpresaFact dto) {
		return new EmpresaFactPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
