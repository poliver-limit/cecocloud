/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.logic.api.service.IdentificadorRrhhService;
import es.limit.cecocloud.rrhh.persist.entity.IdentificadorEntity;

/**
 * Implementació del servei de gestió de identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("rrhhIdentificadorServiceImpl")
public class IdentificadorServiceImpl extends AbstractGenericServiceImpl<Identificador, IdentificadorEntity, String> implements IdentificadorRrhhService {
}
