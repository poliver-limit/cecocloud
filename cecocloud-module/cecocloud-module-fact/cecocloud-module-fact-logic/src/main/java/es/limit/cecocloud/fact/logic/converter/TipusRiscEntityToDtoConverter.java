/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusRisc;
import es.limit.cecocloud.fact.persist.entity.TipusRiscEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusRisc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusRiscEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusRiscEntity, TipusRisc> {

}