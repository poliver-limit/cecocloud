/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari.PuntVendaHorariPk;
import es.limit.cecocloud.cita.logic.api.service.PuntVendaHorariService;
import es.limit.cecocloud.cita.persist.entity.PuntVendaHorariEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de relacions entre punt de venda i horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PuntVendaHorariServiceImpl extends AbstractGenericCompositePkServiceImpl<PuntVendaHorari, PuntVendaHorariEntity, PuntVendaHorariPk> implements PuntVendaHorariService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected PuntVendaHorariPk getPkFromDto(PuntVendaHorari dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new PuntVendaHorariPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getPuntVenda().getPk().getCodi(),
				dto.getHorari().getPk().getCodi());
	}

}
