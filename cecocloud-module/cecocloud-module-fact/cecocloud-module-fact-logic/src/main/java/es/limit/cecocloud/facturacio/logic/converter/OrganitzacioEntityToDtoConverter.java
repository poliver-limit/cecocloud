/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Organitzacio;
import es.limit.cecocloud.facturacio.persist.entity.OrganitzacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus d'organitzacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class OrganitzacioEntityToDtoConverter extends AbstractEntityToDtoConverter<OrganitzacioEntity, Organitzacio> {

}