/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.fact.logic.api.dto.Comptador;
import es.limit.cecocloud.fact.logic.api.dto.Comptador.ComptadorPk;
import es.limit.cecocloud.fact.persist.entity.ComptadorEntity;
import es.limit.cecocloud.fact.persist.repository.ComptadorRepository;
import es.limit.cecocloud.fact.persist.repository.IdentificadorRepository;

/**
 * Aquesta classe està implementada seguint el patró singleton.
 * Mitjançant aquesta classe els EntityListener poden accedir als
 * altres beans d'Spring.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EntityListenerHelper {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private ComptadorRepository comptadorRepository;


	private static EntityListenerHelper instancia = null;

	protected EntityListenerHelper() {}
	/**
	 * Mètode que retorna la instància de la classe.
	 * 
	 * @return La instància
	 */
	public static EntityListenerHelper getInstance() {
		if (instancia == null) {
			instancia = new EntityListenerHelper();
		}
		return instancia;
	}

	/**
	 * Obté el pròxim valor per a un comptador de la taula TGES_CNT.
	 * La taula TGES_CNT emmagatzema el darrer valor assignat. El valor
	 * retornat s'obté de consultar el darrer valor assignat incrementat
	 * en 1.
	 * 
	 * @param identificador
	 *            L'identificador al qual pertany el comptador.
	 * @param codi
	 *            El codi del comptador.
	 * @return El següent valor pel comptador.
	 */
	public int getSeguentNumComptador(
			String identificadorCodi,
			String codi) {
		int valor;
		ComptadorPk comptadorPk = new ComptadorPk(identificadorCodi, codi);
		Optional<ComptadorEntity> comptadorEntity = comptadorRepository.findById(comptadorPk);
		if (comptadorEntity.isPresent()) {
			valor = comptadorEntity.get().getEmbedded().getDarrerValor() + 1;
			comptadorEntity.get().getEmbedded().setDarrerValor(valor);
		} else {
			Comptador comptador = new Comptador();
			comptador.setCodi(codi);
			comptador.setDarrerValor(1);
			comptadorRepository.save(
					ComptadorEntity.builder().
					pk(comptadorPk).
					embedded(comptador).
					identificador(identificadorRepository.findById(identificadorCodi).get()).
					build());
			valor = 1;
		}
		return valor;
	}
	
}
