/*
 * 
 */
package es.limit.cecocloud.lici.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.lici.logic.api.dto.Document;
import es.limit.cecocloud.lici.persist.entity.DocumentEntity;

/**
 * Conversor cap a DTO de les entitats de document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class DocumentEntityToDtoConverter extends AbstractEntityToDtoConverter<DocumentEntity, Document>{

}
