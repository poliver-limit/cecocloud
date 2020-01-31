/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.fact.logic.api.service.TipusFacturacioService;
import es.limit.cecocloud.fact.persist.entity.TipusFacturacioEntity;

/**
 * Implementació del servei de gestió de tipus facturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusFacturacioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusFacturacio, TipusFacturacioEntity, String> implements TipusFacturacioService {

}
