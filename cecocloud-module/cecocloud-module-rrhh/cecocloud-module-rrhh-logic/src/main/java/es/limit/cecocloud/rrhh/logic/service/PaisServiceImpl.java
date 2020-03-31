/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Pais;
import es.limit.cecocloud.rrhh.logic.api.service.PaisService;
import es.limit.cecocloud.rrhh.persist.entity.PaisEntity;

/**
 * Implementació del servei de gestió de paisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("PaisRrhhService")
public class PaisServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Pais, PaisEntity, String> implements PaisService {

}