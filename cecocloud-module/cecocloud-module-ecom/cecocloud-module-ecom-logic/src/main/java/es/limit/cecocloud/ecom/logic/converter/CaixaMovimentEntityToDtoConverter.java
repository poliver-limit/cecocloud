/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment;
import es.limit.cecocloud.ecom.persist.entity.CaixaMovimentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus CaixaMoviment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomCaixaMovimentEntityToDtoConverter")
public class CaixaMovimentEntityToDtoConverter extends AbstractEntityToDtoConverter<CaixaMovimentEntity, CaixaMoviment> {

}