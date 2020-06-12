/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat;
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat.VencimentPagatPk;
import es.limit.cecocloud.ecom.logic.api.service.VencimentPagatService;
import es.limit.cecocloud.ecom.persist.entity.VencimentPagatEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de VencimentPagat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomVencimentPagatService")
public class VencimentPagatServiceImpl extends AbstractGenericCompositePkServiceImpl<VencimentPagat, VencimentPagatEntity, VencimentPagatPk> implements VencimentPagatService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected VencimentPagatPk getPkFromDto(VencimentPagat dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new VencimentPagatPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getCaixa().getPk().getCodi(),
				dto.getCaixaMoviment().getPk().getNumero(),
				dto.getMoviment()
		);
	}

}
