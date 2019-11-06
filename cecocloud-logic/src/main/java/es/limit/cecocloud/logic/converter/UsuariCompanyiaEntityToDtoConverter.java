/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
import es.limit.cecocloud.persist.entity.UsuariCompanyiaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus usuariCompanyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UsuariCompanyiaEntityToDtoConverter extends AbstractEntityToDtoConverter<UsuariCompanyiaEntity, UsuariCompanyia> {

}