/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial;
import es.limit.cecocloud.fact.persist.entity.RegistreComercialEntity;

/**
 * Conversor cap a DTO de les entitats de tipus RegistreComercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RegistreComercialEntityToDtoConverter extends AbstractEntityToDtoConverter<RegistreComercialEntity, RegistreComercial> {

}