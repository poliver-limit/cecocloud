/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.service.OperariService;
import es.limit.cecocloud.persist.entity.OperariEntity;

/**
 * Implementació del servei encarregat de gestionar operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("OperariMarcService")
public class OperariServiceImpl extends AbstractGenericServiceImpl<Operari, OperariEntity, Long> implements OperariService {

	/*private Date toHoraIniciDia(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	private Date toHoraFiDia(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}*/

}
