/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable;
import es.limit.cecocloud.fact.persist.entity.HistoricResponsableEntity;

/**
 * Conversor cap a DTO de les entitats de tipus HistoricResponsable.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class HistoricResponsableEntityToDtoConverter extends AbstractEntityToDtoConverter<HistoricResponsableEntity, HistoricResponsable> {

}