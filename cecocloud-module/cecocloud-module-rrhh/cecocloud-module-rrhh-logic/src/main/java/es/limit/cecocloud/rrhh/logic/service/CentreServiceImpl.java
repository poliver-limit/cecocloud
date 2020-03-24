/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Centre;
import es.limit.cecocloud.rrhh.logic.api.service.CentreService;
import es.limit.cecocloud.rrhh.persist.entity.CentreEntity;

/**
 * Implementació del servei de gestió de torns.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CentreServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Centre, CentreEntity, String>
		implements CentreService {

}
