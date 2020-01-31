/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.fact.logic.api.service.TipusAdresaService;
import es.limit.cecocloud.fact.persist.entity.TipusAdresaEntity;

/**
 * Implementació del servei de gestió de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusAdresaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusAdresa, TipusAdresaEntity, String>
		implements TipusAdresaService {

}
