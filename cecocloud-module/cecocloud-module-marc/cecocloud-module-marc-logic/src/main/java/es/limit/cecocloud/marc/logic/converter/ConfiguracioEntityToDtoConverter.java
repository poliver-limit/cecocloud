/**
 * 
 */
package es.limit.cecocloud.marc.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.marc.logic.api.dto.Configuracio;
import es.limit.cecocloud.marc.persist.entity.ConfiguracioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus configuracio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("marcConfiguracioEntityToDtoConverter")
public class ConfiguracioEntityToDtoConverter extends AbstractEntityToDtoConverter<ConfiguracioEntity, Configuracio> {

}