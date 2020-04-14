/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor;
import es.limit.cecocloud.fact.persist.entity.TarifaProveidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TarifaProveidorToDtoConverter extends AbstractEntityToDtoConverter<TarifaProveidorEntity, TarifaProveidor> {

}