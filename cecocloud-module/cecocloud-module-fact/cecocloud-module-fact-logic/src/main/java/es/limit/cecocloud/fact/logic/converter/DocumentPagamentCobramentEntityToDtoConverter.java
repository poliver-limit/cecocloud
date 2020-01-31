/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus DocumentPagamentCobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class DocumentPagamentCobramentEntityToDtoConverter extends AbstractEntityToDtoConverter<DocumentPagamentCobramentEntity, DocumentPagamentCobrament> {

}