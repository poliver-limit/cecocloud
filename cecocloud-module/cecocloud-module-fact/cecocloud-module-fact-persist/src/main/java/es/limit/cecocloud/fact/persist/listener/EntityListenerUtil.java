/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.api.dto.CompositePk;
import es.limit.cecocloud.fact.persist.entity.ComptadorEntity;
import es.limit.cecocloud.fact.persist.entity.ProjecteEntity;
import es.limit.cecocloud.fact.persist.repository.ComptadorRepository;
import es.limit.cecocloud.logic.api.dto.Comptador;
import es.limit.cecocloud.logic.api.dto.Comptador.ComptadorPk;

/**
 * Classe amb mètodes comuns pels EntityListener's de Cecocloud.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factEntityListenerUtil")
public class EntityListenerUtil extends es.limit.cecocloud.persist.listener.EntityListenerUtil {

	/**
	 * Obté el pròxim valor per a un comptador de la taula TGES_CNT.
	 * La taula TGES_CNT emmagatzema el darrer valor assignat. El valor
	 * retornat s'obté de consultar el darrer valor assignat incrementat
	 * en 1.
	 * 
	 * @param identificador
	 *            L'identificador al qual pertany el comptador.
	 * @param comptadorCodi
	 *            El codi del comptador.
	 * @return El següent valor pel comptador.
	 */
	public static int getSeguentNumComptador(
			String identificadorCodi,
			String comptadorCodi,
			String comptadorCodi2) {
		ComptadorPk comptadorPk = new ComptadorPk(identificadorCodi, comptadorCodi);
		ComptadorRepository comptadorRepository = getBean(ComptadorRepository.class);
		Optional<ComptadorEntity> comptadorEntity = comptadorRepository.findById(comptadorPk);
		int valor;
		if (comptadorEntity.isPresent()) {
			valor = comptadorEntity.get().getEmbedded().getDarrerValor() + 1;
			comptadorEntity.get().getEmbedded().setDarrerValor(valor);
		} else {
			
			if (comptadorCodi2==null) {			
				Comptador comptador = new Comptador();
				comptador.setCodi(comptadorCodi);
				comptador.setDarrerValor(1);
				comptadorRepository.save(
						ComptadorEntity.builder().
						pk(comptadorPk).
						embedded(comptador).
						build());
				valor = 1;
			} else {
				valor = getSeguentNumComptador(identificadorCodi,comptadorCodi2,null);
			}
		}
		return valor;
	}

	/**
	 * Obté el pròxim valor per a un comptador de la taula TGES_CNT comprovant
	 * que el valor retornat no estigui ja utilitzat. Per a fer aquesta
	 * comprovació genera la PK a partir del número de seqüència i consulta si
	 * existeix una entitat a la base de dades amb aquesta PK. Si el número de
	 * seqüència ja està utilitzat en genera un de nou i torna a fer la
	 * comprovació. Si no està utilitzat el retorna.
	 * 
	 * @param <PK>
	 *            tipus de la clau primària.
	 * @param identificadorCodi
	 *            L'identificador al qual pertany el comptador.
	 * @param comptadorCodi
	 *            El codi del comptador.
	 * @param pkBuilder
	 *            Instància de PkBuilder per a generar la PK.
	 * @param entityRepository
	 *            El repository per a consultar si ja existeix una instància
	 *            de l'entitat amb la PK generada.
	 * @return el següent número de seqüència vàlid.
	 */
	public static <PK extends CompositePk> int getSeguentNumComptadorComprovantPk(
			String identificadorCodi,
			String comptadorCodi,
			String comptadorCodi2,
			PkBuilder<PK> pkBuilder,
			JpaRepository<?, PK> entityRepository) {
		int seq;
		PK pk;
		do {
			seq = EntityListenerUtil.getSeguentNumComptador(
					identificadorCodi,
					comptadorCodi,
					comptadorCodi2);
			pk = pkBuilder.build(seq);
		} while (entityRepository.findById(pk).isPresent());
		return seq;
	}
	
	public static <PK extends CompositePk> int getSeguentNumComptadorComprovantPkAmbZeros(
			String identificadorCodi,
			String comptadorCodi,
			String comptadorCodi2,
			PkBuilder<PK> pkBuilder,
			JpaRepository<?, PK> entityRepository,
			int tamanyCodi) {
		int seq;
		PK pk;
		do {
			seq = EntityListenerUtil.getSeguentNumComptador(
					identificadorCodi,
					comptadorCodi,
					comptadorCodi2);
			String codiST = afegirZerosAlCodi(seq, tamanyCodi);
			pk = pkBuilder.build(codiST);
		} while (entityRepository.findById(pk).isPresent());
		return seq;
	}
	
	public static String afegirZerosAlCodi(int codi, int tamanyCodi) {						
			return addZeros(codi, tamanyCodi);
			
	}
	
	public static String addZeros(int codi, int tamanyCodi) {
		return String.format("%0"+String.valueOf(tamanyCodi)+"d", codi).toString();	
	}

	/**
	 * Classe per a construir del PKs pel mètode
	 * getSeguentNumComptadorComprovantPk.
	 * 
	 * @author Limit Tecnologies <limit@limit.es>
	 *
	 * @param <PK>
	 *            tipus de la clau primària.
	 */
	public static abstract class PkBuilder<PK extends CompositePk> {
		public abstract PK build(int seq);
		public abstract PK build(String seq);		
	}
	
	

}