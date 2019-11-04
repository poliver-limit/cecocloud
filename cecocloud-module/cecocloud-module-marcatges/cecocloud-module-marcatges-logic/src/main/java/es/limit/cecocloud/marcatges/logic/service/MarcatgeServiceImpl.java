/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marcatges.logic.api.dto.Marcatge;
import es.limit.cecocloud.marcatges.logic.api.service.MarcatgeService;
import es.limit.cecocloud.marcatges.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marcatges.persist.entity.OperariEntity;
import es.limit.cecocloud.marcatges.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.marcatges.persist.repository.OperariRepository;

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
