/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.List;

import org.springframework.security.acls.model.Permission;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;

/**
 * Interfície per a definir la informació d'una funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatCodiFont {

	public String getCodi();
	public FuncionalitatTipus getTipus();
	public String getDescripcio();
	public Class<? extends Identificable<?>> getRecursPrincipal();
	public List<Class<? extends Identificable<?>>> getRecursosSecundaris();
	public List<Permission> getAllowedPermissions();
	public List<FuncionalitatCodiFont> getFuncionalitatsFilles();

}
