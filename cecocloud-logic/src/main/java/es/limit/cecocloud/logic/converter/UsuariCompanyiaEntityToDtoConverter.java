/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.cecocloud.logic.api.acl.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
import es.limit.cecocloud.persist.entity.UsuariCompanyiaEntity;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

/**
 * Conversor cap a DTO de les entitats de tipus usuariCompanyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UsuariCompanyiaEntityToDtoConverter extends AbstractEntityToDtoConverter<UsuariCompanyiaEntity, UsuariCompanyia> {

	@Autowired
	PermissionHelper permissionHelper;
	
	@Override
	public UsuariCompanyia convert(UsuariCompanyiaEntity source, Type<? extends UsuariCompanyia> destinationType,
			MappingContext mappingContext) {
		UsuariCompanyia usuariCompanyia = super.convert(source, destinationType, mappingContext);
		usuariCompanyia.setAdministrador(permissionHelper.checkPermissionForCurrentUser(UsuariCompanyia.class, usuariCompanyia.getId(), ExtendedPermission.ADMINISTRATION));
		return usuariCompanyia;
	}
}