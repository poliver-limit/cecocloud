/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.AgrupacioFuncionalitat;
import es.limit.cecocloud.persist.entity.AgrupacioFuncionalitatEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Agrupacio-Funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AgrupacioFuncionalitatEntityToDtoConverter extends AbstractEntityToDtoConverter<AgrupacioFuncionalitatEntity, AgrupacioFuncionalitat> {

}