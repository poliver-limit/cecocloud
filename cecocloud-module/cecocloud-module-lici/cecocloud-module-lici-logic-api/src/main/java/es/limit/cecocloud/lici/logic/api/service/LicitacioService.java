/*
 * 
 */
package es.limit.cecocloud.lici.logic.api.service;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;

/**
 * Servei encarregat de gestionar licitacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface LicitacioService extends GenericService<Licitacio, Long> {
	
	//métode de proves de Licitacions Infonalia i les de la plataforma de contractació
		public void mail();

}
