/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.IdentificadorRrhh;
import es.limit.cecocloud.rrhh.persist.entity.IdentificadorRrhhEntity;

/**
 * Conversor cap a DTO de les entitats de tipus IdentificadorRrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IdentificadorRrhhEntityToDtoConverter extends AbstractEntityToDtoConverter<IdentificadorRrhhEntity, IdentificadorRrhh> {

}