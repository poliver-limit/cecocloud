/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.PerfilRol;
import es.limit.cecocloud.logic.api.dto.PerfilRol.PerfilRolPk;
import es.limit.cecocloud.logic.api.service.PerfilRolService;
import es.limit.cecocloud.persist.entity.PerfilRolEntity;

/**
 * Implementació del servei de gestió de Grups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PerfilRolServiceImpl extends AbstractGenericCompositePkServiceImpl<PerfilRol, PerfilRolEntity, PerfilRolPk> implements PerfilRolService {

}
