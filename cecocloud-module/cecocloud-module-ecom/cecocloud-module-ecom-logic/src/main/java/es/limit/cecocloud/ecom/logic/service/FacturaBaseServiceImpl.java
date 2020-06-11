/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase.FacturaBasePk;
import es.limit.cecocloud.ecom.logic.api.service.FacturaBaseService;
import es.limit.cecocloud.ecom.persist.entity.FacturaBaseEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de FacturaBase.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomFacturaBaseService")
public class FacturaBaseServiceImpl extends AbstractGenericCompositePkServiceImpl<FacturaBase, FacturaBaseEntity, FacturaBasePk> implements FacturaBaseService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected FacturaBasePk getPkFromDto(FacturaBase dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new FacturaBasePk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
//				dto.getSerieVenda().getPk().getCodi(),
				dto.getFactura().getPk().getSerieVendaCodi(),
				dto.getFactura().getPk().getNumero(),
				dto.getFactura().getPk().getClasse(),
				dto.getIva().getPk().getCodi()	
		);
	}

}
