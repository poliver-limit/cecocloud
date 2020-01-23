/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.AgrupacioIdentificador;
import es.limit.cecocloud.logic.api.service.AgrupacioIdentificadorService;
import es.limit.cecocloud.persist.entity.AgrupacioIdentificadorEntity;

/**
 * Implementació del servei encarregat de gestionar relacions agrupacio-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AgrupacioIdentificadorServiceImpl extends AbstractGenericServiceImpl<AgrupacioIdentificador, AgrupacioIdentificadorEntity, Long> implements AgrupacioIdentificadorService {

}
