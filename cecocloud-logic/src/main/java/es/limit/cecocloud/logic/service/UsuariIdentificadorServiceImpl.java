/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorService;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;

/**
 * Implementació del servei encarregat de gestionar relacions usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariIdentificadorServiceImpl extends AbstractGenericServiceImpl<UsuariIdentificador, UsuariIdentificadorEntity, Long> implements UsuariIdentificadorService {

}

