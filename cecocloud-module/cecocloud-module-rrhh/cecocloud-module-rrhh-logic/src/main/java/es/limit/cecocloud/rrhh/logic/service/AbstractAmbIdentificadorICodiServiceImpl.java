/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.base.boot.persist.entity.AbstractCompositePkEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.IdentificableWithIdentificadorAndCodi;

/**
 * Entitat de base de dades abstracta amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public abstract class AbstractAmbIdentificadorICodiServiceImpl<D extends IdentificableWithIdentificadorAndCodi<ID>, E extends AbstractCompositePkEntity<D, WithIdentificadorAndCodiPk<ID>>, ID extends Serializable> extends AbstractGenericCompositePkServiceImpl<D, E, WithIdentificadorAndCodiPk<ID>> {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected WithIdentificadorAndCodiPk<ID> getPkFromDto(D dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new WithIdentificadorAndCodiPk<ID>(
				identificador.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
