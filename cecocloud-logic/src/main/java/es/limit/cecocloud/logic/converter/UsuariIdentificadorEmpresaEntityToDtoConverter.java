/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus (usuari-identificador)-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UsuariIdentificadorEmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<UsuariIdentificadorEmpresaEntity, UsuariIdentificadorEmpresa> {

}