/**
 * 
 */
package es.limit.cecocloud.fact.persist.listener;

import javax.persistence.PrePersist;
import es.limit.cecocloud.fact.persist.entity.ProjectePressupostEntity;

/**
 * EntityListener per a la generació del numero de ProjectePressupost per a un ProjectePressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProjectePressupostEntityListener {
	
	@PrePersist
    public void calcular(ProjectePressupostEntity projectePressupost) {
		int num = EntityListenerHelper.getInstance().getSeguentNumComptador(				
				projectePressupost.getIdentificador().getId(),			
				"TGES_PJP");
		projectePressupost.getEmbedded().setProjectePressupostCodi(num);		
		projectePressupost.getId().setProjectePressupostCodi(num);
    }

}
