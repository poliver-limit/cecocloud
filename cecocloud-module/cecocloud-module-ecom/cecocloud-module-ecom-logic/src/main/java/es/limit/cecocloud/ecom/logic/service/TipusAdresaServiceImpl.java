/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.ecom.logic.api.service.TipusAdresaService;
import es.limit.cecocloud.ecom.persist.entity.TipusAdresaEntity;

/**
 * Implementació del servei de gestió de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomTipusAdresaServiceImpl")
/*public class TipusAdresaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusAdresa, TipusAdresaEntity, String>
		implements TipusAdresaService {

}*/
public class TipusAdresaServiceImpl extends AbstractGenericServiceImpl<TipusAdresa, TipusAdresaEntity, String>
implements TipusAdresaService {

}
