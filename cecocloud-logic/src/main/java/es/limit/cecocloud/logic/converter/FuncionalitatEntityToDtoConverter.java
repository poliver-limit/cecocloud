/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;

/**
 * Conversor cap a DTO de les entitats de tipus funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FuncionalitatEntityToDtoConverter extends AbstractEntityToDtoConverter<FuncionalitatEntity, Funcionalitat> {

}