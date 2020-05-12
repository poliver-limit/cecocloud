/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.ecom.persist.entity.TipusVencimentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusVenciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomTipusVencimentEntityToDtoConverter")
public class TipusVencimentEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusVencimentEntity, TipusVenciment> {

}