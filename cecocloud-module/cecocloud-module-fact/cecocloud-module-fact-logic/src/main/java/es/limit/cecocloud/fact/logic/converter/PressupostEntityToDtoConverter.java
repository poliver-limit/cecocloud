/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost;
import es.limit.cecocloud.fact.persist.entity.PressupostEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PressupostEntityToDtoConverter extends AbstractEntityToDtoConverter<PressupostEntity, Pressupost> {

}