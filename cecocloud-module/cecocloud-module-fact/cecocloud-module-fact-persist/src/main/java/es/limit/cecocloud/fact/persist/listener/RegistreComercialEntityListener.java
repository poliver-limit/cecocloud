/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import javax.persistence.PrePersist;
import es.limit.cecocloud.fact.persist.entity.RegistreComercialEntity;

/**
 * EntityListener per a la generació de la seqüència per a un producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegistreComercialEntityListener {
	
	@PrePersist
    public void calcular(RegistreComercialEntity registreComercial) {
		int seq = EntityListenerHelper.getInstance().getSeguentNumComptador(				
				registreComercial.getIdentificador().getId(),			
				"TGES_RGC");
		registreComercial.getEmbedded().setSequencia(seq);		
		registreComercial.getId().setSequencia(seq);
    }

}
