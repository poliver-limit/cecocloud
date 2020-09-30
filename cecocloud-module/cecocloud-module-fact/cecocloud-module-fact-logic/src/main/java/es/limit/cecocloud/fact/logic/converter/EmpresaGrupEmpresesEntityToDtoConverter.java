/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses;
import es.limit.cecocloud.fact.persist.entity.EmpresaGrupEmpresesEntity;

/**
 * Conversor cap a DTO de les entitats de tipus EmpresaGrupEmpreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factEmpresaGrupEmpresesEntityToDtoConverter")
public class EmpresaGrupEmpresesEntityToDtoConverter extends AbstractEntityToDtoConverter<EmpresaGrupEmpresesEntity, EmpresaGrupEmpreses> {

}