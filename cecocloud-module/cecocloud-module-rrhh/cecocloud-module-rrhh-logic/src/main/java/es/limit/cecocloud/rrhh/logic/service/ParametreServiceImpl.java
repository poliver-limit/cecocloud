/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Parametre;
import es.limit.cecocloud.rrhh.logic.api.service.ParametreService;
import es.limit.cecocloud.rrhh.persist.entity.ParametreEntity;

/**
 * Implementació del servei de gestió de parametres.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ParametreServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Parametre, ParametreEntity, String> implements ParametreService {

}
