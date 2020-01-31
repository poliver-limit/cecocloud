/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.fact.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.fact.logic.api.service.MagatzemPeriodeService;
import es.limit.cecocloud.fact.persist.entity.MagatzemPeriodeEntity;

/**
 * Implementació del servei de gestió de magatzems periode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MagatzemPeriodeServiceImpl extends AbstractGenericCompositePkServiceImpl<MagatzemPeriode, MagatzemPeriodeEntity, MagatzemPeriodePk> implements MagatzemPeriodeService {

	@Override
	protected MagatzemPeriodePk getPkFromDto(MagatzemPeriode dto) {
		return new MagatzemPeriodePk(
				dto.getIdentificador().getId(),				
				dto.getMagatzem().getPk().getCodi(),				
				dto.getCodi());
	}


}
