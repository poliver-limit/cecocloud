/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia;
import es.limit.cecocloud.facturacio.persist.entity.ProvinciaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProvinciaEntityToDtoConverter extends AbstractEntityToDtoConverter<ProvinciaEntity, Provincia> {

}