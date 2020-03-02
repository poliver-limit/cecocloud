/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.acls.model.Permission;

import es.limit.base.boot.logic.api.dto.util.Identificable;
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
	protected Modul modul;
	protected List<Class<? extends Identificable<?>>> recursosPrincipals;
	protected List<Class<? extends Identificable<?>>> recursosSecundaris;
	protected List<Permission> allowedPermission;
	
	public FuncionalitatCodiFontImpl(
			String codi, 
			FuncionalitatTipus tipus, 
			String descripcio, 
			Modul modul,
			List<Class<? extends Identificable<?>>> recursosPrincipals,
			List<Class<? extends Identificable<?>>> recursosSecundaris) {
		super();
		this.codi = codi;
		this.tipus = tipus;
		this.descripcio = descripcio;
		this.modul = modul;
		this.recursosPrincipals = recursosPrincipals;
		this.recursosSecundaris = recursosSecundaris;
		this.allowedPermission = new ArrayList<Permission>();
		
		switch (tipus) {
		case MANTENIMENT:
			this.allowedPermission.add(ExtendedPermission.READ);
			this.allowedPermission.add(ExtendedPermission.WRITE);
			this.allowedPermission.add(ExtendedPermission.CREATE);
			this.allowedPermission.add(ExtendedPermission.DELETE);
			break;
		case ACCIO:
			this.allowedPermission.add(ExtendedPermission.EXECUTE);
			break;
		case INFORME:
			this.allowedPermission.add(ExtendedPermission.READ);
			this.allowedPermission.add(ExtendedPermission.PRINT);
			break;
		default:
			break;
		}
	}

}
