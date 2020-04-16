/**
 * 
 */
package es.limit.cecocloud.persist.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Classe amb mètodes comuns pels EntityListener's de Cecocloud.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class EntityListenerUtil {

	private static ApplicationContext applicationContext;

	@Autowired
	public void init(ApplicationContext applicationContext) {
		EntityListenerUtil.applicationContext = applicationContext;
	}

	/**
	 * Obté un bean del ApplicationContext de Spring.
	 * 
	 * @param <T>
	 *            el tipus del bean a obtenir.
	 * @param clazz
	 *            la classe del bean a obtenir.
	 * @return el bean obtingut.
	 */
	public static <T> T getBean(Class<T> clazz) {
		Assert.state(applicationContext != null, "El context Spring de la classe " + EntityListenerUtil.class.getName() + " encara no s'ha inicialitzat!");
		return applicationContext.getBean(clazz);
	}

	/**
	 * Processa un camp de tipus codi passant-lo a majúscules o afegint zeros
	 * (o el caràcter especificat) si conté només caràcters numèrics.
	 * 
	 * @param codi
	 *            el codi a processar.
	 * @param llargada
	 *            la llargada del camp.
	 * @param c
	 *            el caràcter per a emplenar (si és null s'utilitzarà "0").
	 * @return el codi processat.
	 */
	public static String processarPkCodi(String codi, int llargada, Character c) {
		if (codi.matches("[0-9]+")) {
			StringBuilder sb = new StringBuilder(codi);
			for (int x = codi.length(); x < llargada; x++) {
				sb.insert(0, c);
			}
			return sb.toString();
		} else {
			return codi.toUpperCase();
		}
	}

	/**
	 * Processa un camp de tipus codi passant-lo a majúscules o afegint zeros
	 * si conté només caràcters numèrics.
	 * 
	 * @param codi
	 *            el codi a processar.
	 * @param llargada
	 *            la llargada del camp.
	 * @return el codi processat.
	 */
	public static String processarPkCodi(String codi, int llargada) {
		return processarPkCodi(codi, llargada, '0');
	}

}