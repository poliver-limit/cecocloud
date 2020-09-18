/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Parameter;
import es.limit.cecocloud.fact.logic.api.service.ParameterService;
import es.limit.cecocloud.fact.persist.entity.ParameterEntity;

/**
 * Implementation of parameters.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ParameterServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Parameter, ParameterEntity, String> implements ParameterService {

}
