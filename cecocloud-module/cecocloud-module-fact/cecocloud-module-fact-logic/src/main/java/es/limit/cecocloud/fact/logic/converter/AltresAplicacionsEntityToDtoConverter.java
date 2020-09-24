/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions;
import es.limit.cecocloud.fact.persist.entity.AltresAplicacionsEntity;

/**
 * Conversor cap a DTO de les entitats de tipus AltresAplicacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factAltresAplicacionsEntityToDtoConverter")
public class AltresAplicacionsEntityToDtoConverter extends AbstractEntityToDtoConverter<AltresAplicacionsEntity, AltresAplicacions> {

}