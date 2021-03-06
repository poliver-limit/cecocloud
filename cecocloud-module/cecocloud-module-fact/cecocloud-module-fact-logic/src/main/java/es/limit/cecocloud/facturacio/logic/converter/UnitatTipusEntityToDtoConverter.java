/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatTipus;
import es.limit.cecocloud.facturacio.persist.entity.UnitatTipusEntity;

/**
 * Conversor cap a DTO de les entitats de tipus UnitatTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UnitatTipusEntityToDtoConverter extends AbstractEntityToDtoConverter<UnitatTipusEntity, UnitatTipus> {

}