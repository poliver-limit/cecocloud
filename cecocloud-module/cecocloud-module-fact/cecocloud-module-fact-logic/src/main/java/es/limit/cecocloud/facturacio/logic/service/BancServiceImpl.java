package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Banc;
import es.limit.cecocloud.facturacio.logic.api.service.BancService;
import es.limit.cecocloud.facturacio.persist.entity.BancEntity;

/**
 * Implementació del servei de gestió de Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class BancServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Banc, BancEntity, Integer>
		implements BancService {

}

