/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Servidor;
import es.limit.cecocloud.rrhh.persist.entity.ServidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Servidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ServidorEntityToDtoConverter extends AbstractEntityToDtoConverter<ServidorEntity, Servidor> {

}