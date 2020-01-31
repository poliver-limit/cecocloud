package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Idioma;
import es.limit.cecocloud.fact.persist.entity.IdiomaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus d'idioma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IdiomaEntityToDtoConverter extends AbstractEntityToDtoConverter<IdiomaEntity, Idioma> {

}
