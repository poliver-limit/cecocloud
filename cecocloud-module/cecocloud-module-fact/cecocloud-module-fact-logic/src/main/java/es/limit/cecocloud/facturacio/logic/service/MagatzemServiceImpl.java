/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Magatzem;
import es.limit.cecocloud.facturacio.logic.api.dto.Magatzem.MagatzemPk;
import es.limit.cecocloud.facturacio.logic.api.service.MagatzemService;
import es.limit.cecocloud.facturacio.persist.entity.MagatzemEntity;

/**
 * Implementació del servei de gestió de magatzems.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MagatzemServiceImpl extends AbstractGenericCompositePkServiceImpl<Magatzem, MagatzemEntity, MagatzemPk> implements MagatzemService {

	@Override
	protected MagatzemPk getPkFromDto(Magatzem dto) {
		return new MagatzemPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
