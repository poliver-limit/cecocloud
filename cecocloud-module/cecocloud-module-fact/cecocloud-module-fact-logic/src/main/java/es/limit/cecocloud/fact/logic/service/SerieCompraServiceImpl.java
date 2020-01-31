/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.SerieCompra;
import es.limit.cecocloud.fact.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.fact.logic.api.service.SerieCompraService;
import es.limit.cecocloud.fact.persist.entity.SerieCompraEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de series compra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SerieCompraServiceImpl extends AbstractGenericCompositePkServiceImpl<SerieCompra, SerieCompraEntity, SerieCompraPk> implements SerieCompraService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected SerieCompraPk getPkFromDto(SerieCompra dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new SerieCompraPk(
				dto.getIdentificador().getId(),				
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
