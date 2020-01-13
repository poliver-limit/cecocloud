/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.facturacio.logic.api.service.PeuDocumentService;
import es.limit.cecocloud.facturacio.persist.entity.PeuDocumentEntity;

/**
 * Implementació del servei de gestió de peus document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PeuDocumentServiceImpl extends AbstractGenericCompositePkServiceImpl<PeuDocument, PeuDocumentEntity, PeuDocumentPk> implements PeuDocumentService {

	@Override
	protected PeuDocumentPk getPkFromDto(PeuDocument dto) {
		return new PeuDocumentPk(
				dto.getIdentificador().getId(),			
				dto.getEmpresa().getPk().getCodi(),
				dto.getCodi());
		
	}


}
