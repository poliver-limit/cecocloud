/**
 * 
 */
package es.limit.cecocloud.lici.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.lici.persist.entity.ConfiguracioEntity;

/**
 * Conversor cap a DTO de les entitats de configuracio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ConfiguracioEntityToDtoConverter extends AbstractEntityToDtoConverter<ConfiguracioEntity, Configuracio> {

}
