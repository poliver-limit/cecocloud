/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.facturacio.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus DocumentPagamentCobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class DocumentPagamentCobramentEntityToDtoConverter extends AbstractEntityToDtoConverter<DocumentPagamentCobramentEntity, DocumentPagamentCobrament> {

}