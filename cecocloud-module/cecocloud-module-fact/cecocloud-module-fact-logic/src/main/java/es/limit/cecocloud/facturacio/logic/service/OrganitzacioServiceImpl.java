/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Organitzacio;
import es.limit.cecocloud.facturacio.logic.api.service.OrganitzacioService;
import es.limit.cecocloud.facturacio.persist.entity.OrganitzacioEntity;

/**
 * Implementació del servei de gestió de organitzacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OrganitzacioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Organitzacio, OrganitzacioEntity, String>
		implements OrganitzacioService {

}
