/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment.VencimentPk;
import es.limit.cecocloud.ecom.logic.api.service.VencimentService;
import es.limit.cecocloud.ecom.persist.entity.VencimentEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomVencimentService")
public class VencimentServiceImpl extends AbstractGenericCompositePkServiceImpl<Venciment, VencimentEntity, VencimentPk> implements VencimentService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected VencimentPk getPkFromDto(Venciment dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new VencimentPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
//				dto.getSerieVenda().getPk().getCodi(),
				dto.getFactura().getPk().getSerieVendaCodi(),
				dto.getFactura().getPk().getNumero(),
				dto.getFactura().getPk().getClasse(),
				dto.getNumero()
		);
	}

}
