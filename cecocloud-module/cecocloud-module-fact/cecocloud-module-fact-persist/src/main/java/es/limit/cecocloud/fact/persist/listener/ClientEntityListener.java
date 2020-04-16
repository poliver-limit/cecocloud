/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import javax.persistence.PrePersist;
import es.limit.cecocloud.fact.persist.entity.ClientEntity;

/**
 * EntityListener per a la generació de la seqüència per a un producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ClientEntityListener {
	
	@PrePersist
    public void calcular(ClientEntity client) {
		int seq = EntityListenerHelper.getInstance().getSeguentNumComptador(				
				client.getIdentificador().getId(),			
				"TGES_CLI");
		String seqST = Integer.toString(seq);
		String codi = client.getEmbedded().getCodi();
		if ((codi==null)||(codi.equals(""))) {			
			client.getEmbedded().setCodi(seqST);	
			client.getId().setCodi(seqST);			
		}
    }

}
