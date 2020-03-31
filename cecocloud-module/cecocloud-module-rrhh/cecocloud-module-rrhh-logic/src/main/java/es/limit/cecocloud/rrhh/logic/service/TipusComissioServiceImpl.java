/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.TipusComissio;
import es.limit.cecocloud.rrhh.logic.api.service.TipusComissioService;
import es.limit.cecocloud.rrhh.persist.entity.TipusComissioEntity;

/**
 * Implementació del servei de gestió de tipus comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("TipusDeComissioRrhhService")
public class TipusComissioServiceImpl
		extends AbstractAmbIdentificadorICodiServiceImpl<TipusComissio, TipusComissioEntity, String>
		implements TipusComissioService {

}