/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Group;
import es.limit.cecocloud.fact.logic.api.service.GroupService;
import es.limit.cecocloud.fact.persist.entity.GroupEntity;

/**
 * Implementation of groups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class GroupServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Group, GroupEntity, String> implements GroupService {

}
