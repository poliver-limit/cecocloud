/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Caixa;
import es.limit.cecocloud.ecom.persist.entity.CaixaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomCaixaEntityToDtoConverter")
public class CaixaEntityToDtoConverter extends AbstractEntityToDtoConverter<CaixaEntity, Caixa> {

}