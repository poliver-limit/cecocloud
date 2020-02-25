/*
 * 
 */
package es.limit.cecocloud.lici.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.lici.logic.api.dto.Document;
import es.limit.cecocloud.lici.logic.api.service.DocumentService;
import es.limit.cecocloud.lici.persist.entity.DocumentEntity;
/**
 * Implementació del servei encarregat de gestionar documents.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DocumentServiceImpl extends AbstractGenericServiceImpl<Document, DocumentEntity, Long> implements DocumentService {

}
