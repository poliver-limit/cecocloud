/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ConfiguracioImpressos;
import es.limit.cecocloud.fact.persist.entity.ConfiguracioImpressosEntity;

/**
 * Convert entity to DTO from type ConfiguracioImpressos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ConfiguracioImpressosEntityToDtoConverter extends AbstractEntityToDtoConverter<ConfiguracioImpressosEntity, ConfiguracioImpressos> {

}