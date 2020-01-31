/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.service.MarcatgeService;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.entity.OperariEntity;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.marc.persist.repository.OperariRepository;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MarcatgeServiceImpl extends AbstractGenericServiceImpl<Marcatge, MarcatgeEntity, Long> implements MarcatgeService {

	@Autowired
	private OperariRepository operariRepository;

	@Override
	public Marcatge findDarrerMarcatgePerOperari(Long operariId) {
		OperariEntity operari = operariRepository.getOne(operariId);
		return toDto(((MarcatgeRepository)getRepository()).findFirstByOperariOrderByEmbeddedDataDesc(operari));
	}

}
