/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.acls.model.Permission;

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
		setDefaultAllowedPermissions();
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
		setDefaultAllowedPermissions();
	}

	public FuncionalitatCodiFontImpl(
			String codi, 
			FuncionalitatTipus tipus, 
			String descripcio, 
			Class<? extends Identificable<?>> recursPrincipal,
			List<Class<? extends Identificable<?>>> recursosSecundaris) {
		this(
				codi,
				tipus,
				descripcio,
				recursPrincipal,
				recursosSecundaris,
				null);
	}

	private void setDefaultAllowedPermissions() {
		this.allowedPermissions = new ArrayList<Permission>();
		switch (tipus) {
		case MANTENIMENT:
			this.allowedPermissions.add(ExtendedPermission.READ);
			this.allowedPermissions.add(ExtendedPermission.WRITE);
			this.allowedPermissions.add(ExtendedPermission.CREATE);
			this.allowedPermissions.add(ExtendedPermission.DELETE);
			break;
		case ACCIO_SIMPLE:
		case ACCIO_MULTIPLE:
			this.allowedPermissions.add(ExtendedPermission.EXECUTE);
			break;
		case INFORME:
			this.allowedPermissions.add(ExtendedPermission.READ);
			this.allowedPermissions.add(ExtendedPermission.PRINT);
			break;
		default:
			break;
		}
	}

}
