/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.service.DocumentPagamentCobramentService;
import es.limit.cecocloud.fact.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Implementació del servei de gestió de Documents Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DocumentPagamentCobramentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<DocumentPagamentCobrament, DocumentPagamentCobramentEntity, String> implements DocumentPagamentCobramentService {

}
