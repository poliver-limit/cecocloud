/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.AgrupacioIdentificador;
import es.limit.cecocloud.persist.entity.AgrupacioIdentificadorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus identificador-agrupacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IdentificadorAgrupacioEntityToDtoConverter extends AbstractEntityToDtoConverter<AgrupacioIdentificadorEntity, AgrupacioIdentificador> {

}