/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.List;

import es.limit.base.boot.logic.api.dto.util.Identificable;
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

	/*static {
		new FuncionalitatCodiFontImpl(
				"TEST",
				FuncionalitatTipus.MANTENIMENT,
				"Test",
				Modul.fact,
				Arrays.asList(Empresa.class),
				Arrays.asList(Empresa.class));
	}*/

	protected String codi;
	protected FuncionalitatTipus tipus;
	protected String descripcio;
	protected Modul modul;
	protected List<Class<? extends Identificable<?>>> recursosPrincipals;
	protected List<Class<? extends Identificable<?>>> recursosSecundaris;

}
