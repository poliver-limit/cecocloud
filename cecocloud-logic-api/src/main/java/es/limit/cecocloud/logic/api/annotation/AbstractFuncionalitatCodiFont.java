/**
 * 
 */
package es.limit.cecocloud.logic.api.annotation;

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
public class AbstractFuncionalitatCodiFont implements FuncionalitatCodiFont {

	private String codi;
	private FuncionalitatTipus tipus;
	private String descripcio;
	private String modul;

}
