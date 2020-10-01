/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Parameter;
import es.limit.cecocloud.ecom.logic.api.service.ParameterService;
import es.limit.cecocloud.ecom.persist.entity.ParameterEntity;

/**
 * Implementation of parameters.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomParameterService")
public class ParameterServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Parameter, ParameterEntity, String> implements ParameterService {

}
