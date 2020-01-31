/**
 * 
 */package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ProjecteTipus;
import es.limit.cecocloud.fact.logic.api.service.ProjecteTipusService;
import es.limit.cecocloud.fact.persist.entity.ProjecteTipusEntity;

/**
 * Implementació del servei de gestió de ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteTipusServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ProjecteTipus, ProjecteTipusEntity, String>
		implements ProjecteTipusService {

}
