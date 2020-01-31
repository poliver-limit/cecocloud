/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.fact.persist.entity.TipusFacturacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus tipusFacturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusFacturacioEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusFacturacioEntity, TipusFacturacio> {

}