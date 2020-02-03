/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus perfilUsuariIdentificadorEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FuncionalitatIdentificadorEntityToDtoConverter extends AbstractEntityToDtoConverter<FuncionalitatIdentificadorEntity, FuncionalitatIdentificador> {

}