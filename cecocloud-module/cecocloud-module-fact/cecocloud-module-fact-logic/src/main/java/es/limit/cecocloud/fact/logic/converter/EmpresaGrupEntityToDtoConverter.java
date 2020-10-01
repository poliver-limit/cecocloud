/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup;
import es.limit.cecocloud.fact.persist.entity.EmpresaGrupEntity;

/**
 * Conversor cap a DTO de les entitats de tipus EmpresaGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factEmpresaGrupEntityToDtoConverter")
public class EmpresaGrupEntityToDtoConverter extends AbstractEntityToDtoConverter<EmpresaGrupEntity, EmpresaGrup> {

}