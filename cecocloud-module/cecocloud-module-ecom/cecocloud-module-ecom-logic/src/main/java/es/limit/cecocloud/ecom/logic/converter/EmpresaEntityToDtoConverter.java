/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Empresa;
import es.limit.cecocloud.ecom.persist.entity.EmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomEmpresaEntityToDtoConverter")
public class EmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<EmpresaEntity, Empresa> {

}