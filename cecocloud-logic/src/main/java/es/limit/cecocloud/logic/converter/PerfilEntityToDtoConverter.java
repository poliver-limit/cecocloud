/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Conversor cap a DTO de les entitats de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PerfilEntityToDtoConverter extends AbstractEntityToDtoConverter<PerfilEntity, Perfil> {

}