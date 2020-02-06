/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador;
import es.limit.cecocloud.fact.persist.entity.AplicadorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Aplicador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AplicadorEntityToDtoConverter extends AbstractEntityToDtoConverter<AplicadorEntity, Aplicador> {

}