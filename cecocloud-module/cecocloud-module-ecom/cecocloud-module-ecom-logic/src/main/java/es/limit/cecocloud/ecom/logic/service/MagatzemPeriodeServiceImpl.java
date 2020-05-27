/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.ecom.logic.api.service.MagatzemPeriodeService;
import es.limit.cecocloud.ecom.persist.entity.MagatzemPeriodeEntity;

/**
 * Implementació del servei de gestió de MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomMagatzemPeriodeService")
public class MagatzemPeriodeServiceImpl extends AbstractGenericCompositePkServiceImpl<MagatzemPeriode, MagatzemPeriodeEntity, MagatzemPeriodePk> implements MagatzemPeriodeService {	
	
	@Override
	protected MagatzemPeriodePk getPkFromDto(MagatzemPeriode dto) {			
		return new MagatzemPeriodePk(
				dto.getIdentificador().getId(),		
				dto.getMagatzem().getPk().getCodi(),				
				dto.getCodi());
	}

}
