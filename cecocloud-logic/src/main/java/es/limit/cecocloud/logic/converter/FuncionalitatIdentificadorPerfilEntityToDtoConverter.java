/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;

/**
 * Conversor cap a DTO de les entitats de tipus (funcionalitat-identificador)-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FuncionalitatIdentificadorPerfilEntityToDtoConverter extends AbstractEntityToDtoConverter<FuncionalitatIdentificadorPerfilEntity, FuncionalitatIdentificadorPerfil> {

}