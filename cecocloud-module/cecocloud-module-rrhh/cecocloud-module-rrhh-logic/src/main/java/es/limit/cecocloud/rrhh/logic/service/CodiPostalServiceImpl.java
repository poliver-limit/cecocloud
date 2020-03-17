/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.CodiPostal;
import es.limit.cecocloud.rrhh.logic.api.service.CodiPostalService;
import es.limit.cecocloud.rrhh.persist.entity.CodiPostalEntity;

/**
 * Implementació del servei de gestió de codis postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public class CodiPostalServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<CodiPostal, CodiPostalEntity, String> implements CodiPostalService {

}
