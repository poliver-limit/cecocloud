/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Empresa;
import es.limit.cecocloud.facturacio.logic.api.dto.Empresa.EmpresaPk;
import es.limit.cecocloud.facturacio.logic.api.service.EmpresaService;
import es.limit.cecocloud.facturacio.persist.entity.EmpresaEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class EmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<Empresa, EmpresaEntity, EmpresaPk> implements EmpresaService {

	@Override
	protected EmpresaPk getPkFromDto(Empresa dto) {
		return new EmpresaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
