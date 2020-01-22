package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.facturacio.logic.api.service.TipusAdresaService;
import es.limit.cecocloud.facturacio.persist.entity.TipusAdresaEntity;

/**
 * Implementació del servei de gestió de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusAdresaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusAdresa, TipusAdresaEntity, String>
		implements TipusAdresaService {

}
