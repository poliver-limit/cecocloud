/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Servidor;
import es.limit.cecocloud.rrhh.logic.api.service.ServidorService;
import es.limit.cecocloud.rrhh.persist.entity.ServidorEntity;

/**
 * Implementació del servei de gestió de servidors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ServidorServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Servidor, ServidorEntity, String> implements ServidorService {

}
