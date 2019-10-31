/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.service.PerfilService;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Implementació del servei de gestió de Perfils.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PerfilServiceImpl extends AbstractGenericServiceImpl<Perfil, PerfilEntity, Long> implements PerfilService {

}
