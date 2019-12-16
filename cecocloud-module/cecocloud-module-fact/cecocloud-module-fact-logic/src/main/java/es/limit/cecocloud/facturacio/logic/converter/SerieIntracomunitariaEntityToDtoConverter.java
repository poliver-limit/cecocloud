/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieIntracomunitaria;
import es.limit.cecocloud.facturacio.persist.entity.SerieIntracomunitariaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SerieIntracomunitaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SerieIntracomunitariaEntityToDtoConverter extends AbstractEntityToDtoConverter<SerieIntracomunitariaEntity, SerieIntracomunitaria> {

}