package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Projecte;
import es.limit.cecocloud.facturacio.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.facturacio.logic.api.service.ProjecteService;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteEntity;

/**
 * Implementació del servei de gestió de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteServiceImpl extends AbstractGenericCompositePkServiceImpl<Projecte, ProjecteEntity, ProjectePk> implements ProjecteService{

	@Override
	protected ProjectePk getPkFromDto(Projecte dto) {
		return new ProjectePk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getEmpresa().getId());
	}
}

