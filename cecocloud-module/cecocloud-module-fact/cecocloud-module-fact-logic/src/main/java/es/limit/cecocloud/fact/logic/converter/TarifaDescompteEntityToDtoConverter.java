/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TarifaDescompte;
import es.limit.cecocloud.fact.persist.entity.TarifaDescompteEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TarifaDescompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TarifaDescompteEntityToDtoConverter extends AbstractEntityToDtoConverter<TarifaDescompteEntity, TarifaDescompte> {

}