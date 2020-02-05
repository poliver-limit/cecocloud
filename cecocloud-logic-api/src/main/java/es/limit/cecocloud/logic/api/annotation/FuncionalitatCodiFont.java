/**
 * 
 */
package es.limit.cecocloud.logic.api.annotation;

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
	public String getModul();

}
