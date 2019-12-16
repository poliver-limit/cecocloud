/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.EmpresaFact;
import es.limit.cecocloud.facturacio.persist.entity.EmpresaFactEntity;

/**
 * Conversor cap a DTO de les entitats de tipus EmpresaFact.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class EmpresaFactEntityToDtoConverter extends AbstractEntityToDtoConverter<EmpresaFactEntity, EmpresaFact> {

}