/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.SituacioComercial;
import es.limit.cecocloud.fact.logic.api.service.SituacioComercialService;
import es.limit.cecocloud.fact.persist.entity.SituacioComercialEntity;

/**
 * Implementació del servei de gestió de situacions comercials.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SituacioComercialServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<SituacioComercial, SituacioComercialEntity, String> implements SituacioComercialService {

}
