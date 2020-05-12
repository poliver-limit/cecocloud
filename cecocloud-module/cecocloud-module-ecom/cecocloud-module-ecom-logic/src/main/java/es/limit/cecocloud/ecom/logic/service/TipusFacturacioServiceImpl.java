/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.ecom.logic.api.service.TipusFacturacioService;
import es.limit.cecocloud.ecom.persist.entity.TipusFacturacioEntity;

/**
 * Implementació del servei de gestió de TipusFacturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomTipusFacturacioService")
public class TipusFacturacioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusFacturacio, TipusFacturacioEntity, String> implements TipusFacturacioService {

}
