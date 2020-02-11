/**
 * 
 */
package es.limit.cecocloud.lici.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;

/**
 * Conversor cap a DTO de les entitats de configuracio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class LicitacioEntityToDtoConverter extends AbstractEntityToDtoConverter<LicitacioEntity, Licitacio> {

}
