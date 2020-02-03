/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class OperariEmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<OperariEmpresaEntity, OperariEmpresa> {

}