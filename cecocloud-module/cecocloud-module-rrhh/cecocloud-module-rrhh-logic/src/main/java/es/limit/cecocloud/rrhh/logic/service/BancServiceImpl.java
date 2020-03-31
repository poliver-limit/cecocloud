/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Banc;
import es.limit.cecocloud.rrhh.logic.api.service.BancService;
import es.limit.cecocloud.rrhh.persist.entity.BancEntity;

/**
 * Implementació del servei de gestió de Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("BancRrhhService")
public class BancServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Banc, BancEntity, Integer>
		implements BancService {

}
