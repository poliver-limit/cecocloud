/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.ecom.logic.api.service.MagatzemPeriodeService;
import es.limit.cecocloud.ecom.persist.entity.MagatzemPeriodeEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomMagatzemPeriodeService")
public class MagatzemPeriodeServiceImpl extends AbstractGenericCompositePkServiceImpl<MagatzemPeriode, MagatzemPeriodeEntity, MagatzemPeriodePk> implements MagatzemPeriodeService {	
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected MagatzemPeriodePk getPkFromDto(MagatzemPeriode dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new MagatzemPeriodePk(
				identificador.getEmbedded().getCodi(),			
				dto.getMagatzem().getPk().getCodi(),				
				dto.getCodi());
	}

}
