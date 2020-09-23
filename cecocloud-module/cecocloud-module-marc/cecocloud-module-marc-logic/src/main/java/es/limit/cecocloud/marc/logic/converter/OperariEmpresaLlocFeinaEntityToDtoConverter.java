/**
 * 
 */
package es.limit.cecocloud.marc.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.marc.logic.api.dto.OperariEmpresaLlocFeina;
import es.limit.cecocloud.marc.persist.entity.OperariEmpresaLlocFeinaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus relació (operari-empresa)-(lloc de feina).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class OperariEmpresaLlocFeinaEntityToDtoConverter extends AbstractEntityToDtoConverter<OperariEmpresaLlocFeinaEntity, OperariEmpresaLlocFeina> {

}