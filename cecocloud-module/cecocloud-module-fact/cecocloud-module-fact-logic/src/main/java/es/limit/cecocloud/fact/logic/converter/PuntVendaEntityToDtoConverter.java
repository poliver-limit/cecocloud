/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factPuntVendaEntityToDtoConverter")
public class PuntVendaEntityToDtoConverter extends AbstractEntityToDtoConverter<PuntVendaEntity, PuntVenda> {

}