/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.fact.logic.api.service.ZonaService;
import es.limit.cecocloud.fact.persist.entity.ZonaEntity;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ZonaFactService")
public class ZonaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Zona, ZonaEntity, String> implements ZonaService {

}
