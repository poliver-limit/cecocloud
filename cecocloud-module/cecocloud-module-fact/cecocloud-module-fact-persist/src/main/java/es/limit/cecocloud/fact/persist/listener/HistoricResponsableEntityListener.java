/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import javax.persistence.PrePersist;
import es.limit.cecocloud.fact.persist.entity.HistoricResponsableEntity;

/**
 * EntityListener per a la generació de la seqüència per a un historic responsable
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class HistoricResponsableEntityListener {
	
	@PrePersist
    public void calcular(HistoricResponsableEntity historicResponsable) {
		int seq = EntityListenerHelper.getInstance().getSeguentNumComptador(				
				historicResponsable.getIdentificador().getId(),			
				"TGES_HOP");
		historicResponsable.getEmbedded().setSequencia(seq);		
		historicResponsable.getId().setSequencia(seq);
    }

}
