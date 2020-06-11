/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Factura;
import es.limit.cecocloud.ecom.logic.api.dto.Factura.FacturaPk;
import es.limit.cecocloud.ecom.logic.api.service.FacturaService;
import es.limit.cecocloud.ecom.persist.entity.FacturaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomFacturaService")
public class FacturaServiceImpl extends AbstractGenericCompositePkServiceImpl<Factura, FacturaEntity, FacturaPk> implements FacturaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected FacturaPk getPkFromDto(Factura dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new FacturaPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getSerieVenda().getPk().getCodi(),
				dto.getClasse(),
				dto.getNumero());
	}

}
