/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.PeuDocument;
import es.limit.cecocloud.fact.persist.entity.PeuDocumentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PeuDocument.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PeuDocumentEntityToDtoConverter extends AbstractEntityToDtoConverter<PeuDocumentEntity, PeuDocument> {

}