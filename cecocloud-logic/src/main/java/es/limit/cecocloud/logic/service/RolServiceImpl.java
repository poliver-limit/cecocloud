/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.service.RolService;
import es.limit.cecocloud.persist.entity.RolEntity;

/**
 * Implementació del servei de gestió de Grups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RolServiceImpl extends AbstractGenericServiceImpl<Rol, RolEntity, Long> implements RolService {

}
