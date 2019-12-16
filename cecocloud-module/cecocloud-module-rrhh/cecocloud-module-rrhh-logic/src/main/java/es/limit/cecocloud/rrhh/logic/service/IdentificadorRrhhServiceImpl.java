/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.IdentificadorRrhh;
import es.limit.cecocloud.rrhh.logic.api.service.IdentificadorRrhhService;
import es.limit.cecocloud.rrhh.persist.entity.IdentificadorRrhhEntity;

/**
 * Implementació del servei de gestió de identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IdentificadorRrhhServiceImpl extends AbstractGenericServiceImpl<IdentificadorRrhh, IdentificadorRrhhEntity, String> implements IdentificadorRrhhService {
}
