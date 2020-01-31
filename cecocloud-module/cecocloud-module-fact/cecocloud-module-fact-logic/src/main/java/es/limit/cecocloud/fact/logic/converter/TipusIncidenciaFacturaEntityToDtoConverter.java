/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusIncidenciaFactura;
import es.limit.cecocloud.fact.persist.entity.TipusIncidenciaFacturaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusIncidenciaFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusIncidenciaFacturaEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusIncidenciaFacturaEntity, TipusIncidenciaFactura> {

}