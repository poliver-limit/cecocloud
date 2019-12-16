/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaProveidor;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaProveidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus FamiliaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FamiliaProveidorEntityToDtoConverter extends AbstractEntityToDtoConverter<FamiliaProveidorEntity, FamiliaProveidor> {

}