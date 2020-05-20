/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.ecom.logic.api.service.DocumentPagamentCobramentService;
import es.limit.cecocloud.ecom.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Implementació del servei de gestió de DocumentPagamentCobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomDocumentPagamentCobramentService")
public class DocumentPagamentCobramentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<DocumentPagamentCobrament, DocumentPagamentCobramentEntity, String> implements DocumentPagamentCobramentService {

}
