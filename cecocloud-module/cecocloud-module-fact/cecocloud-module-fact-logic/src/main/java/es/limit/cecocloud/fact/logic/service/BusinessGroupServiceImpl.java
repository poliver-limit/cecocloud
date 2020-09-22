/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.BusinessGroup;
import es.limit.cecocloud.fact.logic.api.service.BusinessGroupService;
import es.limit.cecocloud.fact.persist.entity.BusinessGroupEntity;

/**
 * Implementation of business groups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class BusinessGroupServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<BusinessGroup, BusinessGroupEntity, String> implements BusinessGroupService {

}
