/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Parametre;
import es.limit.cecocloud.rrhh.persist.entity.ParametreEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Parametre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ParametreEntityToDtoConverter extends AbstractEntityToDtoConverter<ParametreEntity, Parametre> {

}