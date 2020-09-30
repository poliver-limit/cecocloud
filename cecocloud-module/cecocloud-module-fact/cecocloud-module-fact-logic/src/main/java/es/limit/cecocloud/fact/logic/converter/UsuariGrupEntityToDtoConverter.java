/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup;
import es.limit.cecocloud.fact.persist.entity.UsuariGrupEntity;

/**
 * Conversor cap a DTO de les entitats de tipus UsuariGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factUsuariGrupEntityToDtoConverter")
public class UsuariGrupEntityToDtoConverter extends AbstractEntityToDtoConverter<UsuariGrupEntity, UsuariGrup> {

}