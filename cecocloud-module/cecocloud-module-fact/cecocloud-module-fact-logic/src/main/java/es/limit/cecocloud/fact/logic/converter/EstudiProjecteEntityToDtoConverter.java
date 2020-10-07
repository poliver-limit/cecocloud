/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte;
import es.limit.cecocloud.fact.persist.entity.EstudiProjecteEntity;

/**
 * Conversor cap a DTO de les entitats de tipus EstudiProjecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factEstudiProjecteEntityToDtoConverter")
public class EstudiProjecteEntityToDtoConverter extends AbstractEntityToDtoConverter<EstudiProjecteEntity, EstudiProjecte> {

}