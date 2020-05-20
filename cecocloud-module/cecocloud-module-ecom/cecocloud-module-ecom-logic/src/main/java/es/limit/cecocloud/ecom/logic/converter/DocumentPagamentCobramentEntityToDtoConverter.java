/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.ecom.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus DocumentPagamentCobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomDocumentPagamentCobramentEntityToDtoConverter")
public class DocumentPagamentCobramentEntityToDtoConverter extends AbstractEntityToDtoConverter<DocumentPagamentCobramentEntity, DocumentPagamentCobrament> {

}