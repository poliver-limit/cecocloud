/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.ecom.logic.api.service.SerieVendaService;
import es.limit.cecocloud.ecom.persist.entity.SerieVendaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de SerieVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomSerieVendaService")
public class SerieVendaServiceImpl extends AbstractGenericCompositePkServiceImpl<SerieVenda, SerieVendaEntity, SerieVendaPk> implements SerieVendaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected SerieVendaPk getPkFromDto(SerieVenda dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new SerieVendaPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
