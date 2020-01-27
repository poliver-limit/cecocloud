/**
 * 
 */package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.ProjecteTipus;
import es.limit.cecocloud.facturacio.logic.api.service.ProjecteTipusService;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteTipusEntity;

/**
 * Implementació del servei de gestió de ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteTipusServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ProjecteTipus, ProjecteTipusEntity, String>
		implements ProjecteTipusService {

}
