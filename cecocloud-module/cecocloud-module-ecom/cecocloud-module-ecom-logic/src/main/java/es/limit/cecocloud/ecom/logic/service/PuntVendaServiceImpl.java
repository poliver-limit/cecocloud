/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.ecom.logic.api.service.PuntVendaService;
import es.limit.cecocloud.ecom.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de PuntVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomPuntVendaService")
public class PuntVendaServiceImpl extends AbstractGenericCompositePkServiceImpl<PuntVenda, PuntVendaEntity, PuntVendaPk> implements PuntVendaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected PuntVendaPk getPkFromDto(PuntVenda dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new PuntVendaPk(
				dto.getIdentificador().getId(),				
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
