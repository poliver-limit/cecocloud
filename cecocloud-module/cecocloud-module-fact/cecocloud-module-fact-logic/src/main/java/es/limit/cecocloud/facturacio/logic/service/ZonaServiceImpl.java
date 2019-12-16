/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.service.ZonaService;
import es.limit.cecocloud.facturacio.persist.entity.ZonaEntity;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ZonaFactService")
public class ZonaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Zona, ZonaEntity, String> implements ZonaService {

}
