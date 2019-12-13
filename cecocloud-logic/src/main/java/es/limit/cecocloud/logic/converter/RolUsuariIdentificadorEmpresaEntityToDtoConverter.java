/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa;
import es.limit.cecocloud.persist.entity.RolUsuariIdentificadorEmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus rolUsuariIdentificadorEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RolUsuariIdentificadorEmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<RolUsuariIdentificadorEmpresaEntity, RolUsuariIdentificadorEmpresa> {

}