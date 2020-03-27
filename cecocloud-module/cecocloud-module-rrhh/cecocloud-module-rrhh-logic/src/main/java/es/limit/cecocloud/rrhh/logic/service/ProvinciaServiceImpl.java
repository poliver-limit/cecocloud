/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Provincia;
import es.limit.cecocloud.rrhh.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.rrhh.logic.api.service.ProvinciaService;
import es.limit.cecocloud.rrhh.persist.entity.ProvinciaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ProvinciaRrhhService")
public class ProvinciaServiceImpl extends AbstractGenericCompositePkServiceImpl<Provincia, ProvinciaEntity, ProvinciaPk> implements ProvinciaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected ProvinciaPk getPkFromDto(Provincia dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new ProvinciaPk(
				identificador.getEmbedded().getCodi(),
				dto.getPais().getPk().getCodi(),
				dto.getCodi());
	}

}
