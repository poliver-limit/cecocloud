/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.acls.model.Permission;

import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourcePermission;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Interfície per a definir la informació d'una funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@AllArgsConstructor
@Getter @Setter
public class FuncionalitatCodiFontImpl implements FuncionalitatCodiFont {

	protected String codi;
	protected FuncionalitatTipus tipus;
	protected String descripcio;
	protected Class<? extends Identificable<?>> recursPrincipal;
	protected List<Class<? extends Identificable<?>>> recursosSecundaris;
	protected List<Permission> allowedPermissions;
	protected List<FuncionalitatCodiFont> funcionalitatsFilles;

	public FuncionalitatCodiFontImpl(
			String codi, 
			FuncionalitatTipus tipus, 
			String descripcio) {
		this.codi = codi;
		this.tipus = tipus;
		this.descripcio = descripcio;
		setAllowedPermissions(null);
	}
	public FuncionalitatCodiFontImpl(
			String codi, 
			FuncionalitatTipus tipus, 
			String descripcio, 
			Class<? extends Identificable<?>> recursPrincipal,
			List<Class<? extends Identificable<?>>> recursosSecundaris,
			List<FuncionalitatCodiFont> funcionalitatsFilles) {
		this.codi = codi;
		this.tipus = tipus;
		this.descripcio = descripcio;
		this.recursPrincipal = recursPrincipal;
		this.recursosSecundaris = recursosSecundaris;
		this.funcionalitatsFilles = funcionalitatsFilles;
		setAllowedPermissions(recursPrincipal);
	}

	public FuncionalitatCodiFontImpl(
			String codi, 
			FuncionalitatTipus tipus, 
			String descripcio, 
			Class<? extends Identificable<?>> recursPrincipal,
			List<Class<? extends Identificable<?>>> recursosSecundaris) {
		this(	codi,
				tipus,
				descripcio,
				recursPrincipal,
				recursosSecundaris,
				null);
	}

	private void setAllowedPermissions(Class<? extends Identificable<?>> recursClass) {
		RestapiResourcePermission[] resourcePermissionsAllowed = null;
		if (recursClass != null) {
			RestapiResource restapiResource = recursClass.getAnnotation(RestapiResource.class);
			if (restapiResource.permissionsAllowed().length > 0) {
				resourcePermissionsAllowed = restapiResource.permissionsAllowed();
			}
		}
		allowedPermissions = new ArrayList<Permission>();
		switch (tipus) {
		case MANTENIMENT:
			addPermissionIfAllowed(ExtendedPermission.READ, resourcePermissionsAllowed);
			addPermissionIfAllowed(ExtendedPermission.WRITE, resourcePermissionsAllowed);
			addPermissionIfAllowed(ExtendedPermission.CREATE, resourcePermissionsAllowed);
			addPermissionIfAllowed(ExtendedPermission.DELETE, resourcePermissionsAllowed);
			break;
		case ACCIO_SIMPLE:
		case ACCIO_MULTIPLE:
			addPermissionIfAllowed(ExtendedPermission.WRITE, resourcePermissionsAllowed);
			break;
		case INFORME:
			addPermissionIfAllowed(ExtendedPermission.READ, resourcePermissionsAllowed);
			addPermissionIfAllowed(ExtendedPermission.CREATE, resourcePermissionsAllowed);
			break;
		default:
			break;
		}
	}

	private void addPermissionIfAllowed(Permission permission, RestapiResourcePermission[] allowedPermissions) {
		if (permission.equals(ExtendedPermission.READ) && (allowedPermissions == null || Arrays.stream(allowedPermissions).anyMatch(RestapiResourcePermission.READ::equals))) {
			this.allowedPermissions.add(permission);
		}
		if (permission.equals(ExtendedPermission.WRITE) && (allowedPermissions == null || Arrays.stream(allowedPermissions).anyMatch(RestapiResourcePermission.WRITE::equals))) {
			this.allowedPermissions.add(permission);
		}
		if (permission.equals(ExtendedPermission.CREATE) && (allowedPermissions == null || Arrays.stream(allowedPermissions).anyMatch(RestapiResourcePermission.CREATE::equals))) {
			this.allowedPermissions.add(permission);
		}
		if (permission.equals(ExtendedPermission.DELETE) && (allowedPermissions == null || Arrays.stream(allowedPermissions).anyMatch(RestapiResourcePermission.DELETE::equals))) {
			this.allowedPermissions.add(permission);
		}
	}

}
