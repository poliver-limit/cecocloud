/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.service.MarcatgeService;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MarcatgeServiceImpl extends AbstractGenericServiceImpl<Marcatge, Long, MarcatgeEntity, Long> implements MarcatgeService {

	@Autowired
	private OperariRepository operariRepository;

	@Override
	public Marcatge findDarrerMarcatgePerOperari(Long operariId) {
		OperariEntity operari = operariRepository.getOne(operariId);
		return toDto(((MarcatgeRepository)getRepository()).findFirstByOperariOrderByEmbeddedDataDesc(operari));
	}

}
