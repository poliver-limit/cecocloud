/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioGrup;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioGrup.SeccioGrupPk;
import es.limit.cecocloud.facturacio.logic.api.service.SeccioGrupService;
import es.limit.cecocloud.facturacio.persist.entity.SeccioGrupEntity;

/**
 * Implementació del servei de gestió de seccions grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SeccioGrupServiceImpl extends AbstractGenericCompositePkServiceImpl<SeccioGrup, SeccioGrupEntity, SeccioGrupPk> implements SeccioGrupService {

	@Override
	protected SeccioGrupPk getPkFromDto(SeccioGrup dto) {
		return new SeccioGrupPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getEmpresa().getId());
	}


}
