/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable.HistoricResponsablePk;
import es.limit.cecocloud.fact.logic.api.service.HistoricResponsableService;
import es.limit.cecocloud.fact.persist.entity.HistoricResponsableEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de històrics responsables
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class HistoricResponsableServiceImpl extends AbstractGenericCompositePkServiceImpl<HistoricResponsable, HistoricResponsableEntity, HistoricResponsablePk> implements HistoricResponsableService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected HistoricResponsablePk getPkFromDto(HistoricResponsable dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new HistoricResponsablePk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				"100", // TO DO: RECUPERAR EL PROJECTE
				dto.getSequencia());
	}

}
