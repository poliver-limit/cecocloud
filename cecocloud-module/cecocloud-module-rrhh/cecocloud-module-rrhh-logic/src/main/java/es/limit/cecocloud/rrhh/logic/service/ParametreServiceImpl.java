/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Parametre;
import es.limit.cecocloud.rrhh.logic.api.dto.Parametre.ParametrePk;
import es.limit.cecocloud.rrhh.logic.api.service.ParametreService;
import es.limit.cecocloud.rrhh.persist.entity.ParametreEntity;

/**
 * Implementació del servei de gestió de parametres.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ParametreServiceImpl extends AbstractGenericCompositePkServiceImpl<Parametre, ParametreEntity, ParametrePk> implements ParametreService {

	@Override
	protected ParametrePk getPkFromDto(Parametre dto) {
		return new ParametrePk(
				dto.getIdentificador().getId(),
				dto.getId());
	}


}
