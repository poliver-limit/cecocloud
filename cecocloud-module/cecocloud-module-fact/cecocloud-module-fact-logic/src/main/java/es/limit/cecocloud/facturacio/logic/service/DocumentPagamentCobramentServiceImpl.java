/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.facturacio.logic.api.dto.DocumentPagamentCobrament.DocumentPagamentCobramentPk;
import es.limit.cecocloud.facturacio.logic.api.service.DocumentPagamentCobramentService;
import es.limit.cecocloud.facturacio.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Implementació del servei de gestió de Documents Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DocumentPagamentCobramentServiceImpl extends AbstractGenericCompositePkServiceImpl<DocumentPagamentCobrament, DocumentPagamentCobramentEntity, DocumentPagamentCobramentPk> implements DocumentPagamentCobramentService {

	@Override
	protected DocumentPagamentCobramentPk getPkFromDto(DocumentPagamentCobrament dto) {
		return new DocumentPagamentCobramentPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
