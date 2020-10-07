/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.fact.persist.entity.PressupostLiniaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factPressupostLiniaEntityToDtoConverter")
public class PressupostLiniaEntityToDtoConverter extends AbstractEntityToDtoConverter<PressupostLiniaEntity, PressupostLinia> {

}