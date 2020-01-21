/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.PaisNif;
import es.limit.cecocloud.rrhh.persist.entity.PaisNifEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PaisNifEntityToDtoConverter extends AbstractEntityToDtoConverter<PaisNifEntity, PaisNif> {

}