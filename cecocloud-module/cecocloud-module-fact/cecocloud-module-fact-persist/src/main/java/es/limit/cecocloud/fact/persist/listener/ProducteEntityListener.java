/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import javax.persistence.PrePersist;
import es.limit.cecocloud.fact.persist.entity.ProducteEntity;

/**
 * EntityListener per a la generació de la seqüència per a un producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProducteEntityListener {
	
	@PrePersist
    public void calcular(ProducteEntity producte) {
		int seq = EntityListenerHelper.getInstance().getSeguentNumComptador(				
				producte.getIdentificador().getId(),			
				"TGES_APL");
		producte.getEmbedded().setReferencia(seq);		
		producte.getId().setReferencia(seq);
    }

}
