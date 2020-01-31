/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Organitzacio;
import es.limit.cecocloud.fact.logic.api.service.OrganitzacioService;
import es.limit.cecocloud.fact.persist.entity.OrganitzacioEntity;

/**
 * Implementació del servei de gestió de organitzacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OrganitzacioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Organitzacio, OrganitzacioEntity, String>
		implements OrganitzacioService {

}
