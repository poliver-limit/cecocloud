/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument;
import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.ecom.logic.api.service.PeuDocumentService;
import es.limit.cecocloud.ecom.persist.entity.PeuDocumentEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de PeuDocument.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomPeuDocumentService")
public class PeuDocumentServiceImpl extends AbstractGenericCompositePkServiceImpl<PeuDocument, PeuDocumentEntity, PeuDocumentPk> implements PeuDocumentService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected PeuDocumentPk getPkFromDto(PeuDocument dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new PeuDocumentPk(
				dto.getIdentificador().getId(),				
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
