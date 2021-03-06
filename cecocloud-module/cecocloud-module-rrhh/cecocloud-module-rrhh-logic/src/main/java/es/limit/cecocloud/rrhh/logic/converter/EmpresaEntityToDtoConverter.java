/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.persist.entity.EmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus EmpresaRrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("rrhhEmpresaEntityToDtoConverter")
public class EmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<EmpresaEntity, Empresa> {

}