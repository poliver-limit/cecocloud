/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.service.OperariService;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.OperariRepository;

/**
 * Implementació del servei encarregat de gestionar operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OperariServiceImpl extends AbstractGenericServiceImpl<Operari, Long, OperariEntity, Long> implements OperariService {

	@Autowired
	private OperariRepository operariRepository;

	@Override
	public boolean isOperariActiu(Long id, Date data) {
		OperariEntity operari = operariRepository.getOne(id);
		Date operariDataInici = toHoraIniciDia(operari.getEmbedded().getDataInici());
		boolean valid = data.equals(operariDataInici) || data.after(operariDataInici);
		Date operariDataFi = operari.getEmbedded().getDataFi();
		if (valid && operariDataFi != null) {
			operariDataFi = toHoraFiDia(operariDataFi);
			valid = data.before(operariDataFi);
		}
		return valid;
	}

	private Date toHoraIniciDia(Date data) {
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
	}

}
