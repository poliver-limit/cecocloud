/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.facturacio.logic.api.service.SeccioEmpresaService;
import es.limit.cecocloud.facturacio.persist.entity.SeccioEmpresaEntity;

/**
 * Implementació del servei de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SeccioEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<SeccioEmpresa, SeccioEmpresaEntity, SeccioEmpresaPk> implements SeccioEmpresaService {

	@Override
	protected SeccioEmpresaPk getPkFromDto(SeccioEmpresa dto) {
		return new SeccioEmpresaPk(
				dto.getIdentificador().getId(),				
				dto.getArticleFamilia().getId(),
				dto.getEmpresa().getId());				
	}

}
