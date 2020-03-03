/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.fact.persist.entity.TipusAdresaEntity;

/**
 * Conversor cap a DTO de les entitats de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factTipusAdresaEntityToDtoConverter")
public class TipusAdresaEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusAdresaEntity, TipusAdresa> {

}
