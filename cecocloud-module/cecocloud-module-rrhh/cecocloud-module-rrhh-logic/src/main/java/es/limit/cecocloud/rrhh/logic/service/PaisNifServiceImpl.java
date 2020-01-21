/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.PaisNif;
import es.limit.cecocloud.rrhh.logic.api.service.PaisNifService;
import es.limit.cecocloud.rrhh.persist.entity.PaisNifEntity;

/**
 * Implementació del servei de gestió de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PaisNifServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<PaisNif, PaisNifEntity, String> implements PaisNifService {

}
