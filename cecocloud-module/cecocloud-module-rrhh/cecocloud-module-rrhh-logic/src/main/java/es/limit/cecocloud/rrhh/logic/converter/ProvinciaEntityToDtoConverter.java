/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Provincia;
import es.limit.cecocloud.rrhh.persist.entity.ProvinciaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("rrhhProvinciaEntityToDtoConverter")
public class ProvinciaEntityToDtoConverter extends AbstractEntityToDtoConverter<ProvinciaEntity, Provincia> {

}
