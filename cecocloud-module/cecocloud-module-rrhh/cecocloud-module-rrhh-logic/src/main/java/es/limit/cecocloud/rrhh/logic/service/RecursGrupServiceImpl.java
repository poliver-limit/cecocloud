/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecocloud.rrhh.logic.api.service.RecursGrupService;
import es.limit.cecocloud.rrhh.persist.entity.RecursGrupEntity;

/**
 * Implementació del servei de gestió de recursos grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RecursGrupServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<RecursGrup, RecursGrupEntity, String> implements RecursGrupService {

}
