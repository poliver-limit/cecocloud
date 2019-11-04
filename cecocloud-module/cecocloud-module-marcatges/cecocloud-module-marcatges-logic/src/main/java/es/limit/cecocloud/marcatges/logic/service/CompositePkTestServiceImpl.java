/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.marcatges.logic.api.dto.CompositePkTest;
import es.limit.cecocloud.marcatges.logic.api.dto.CompositePkTest.CompositePkTestPk;
import es.limit.cecocloud.marcatges.logic.api.service.CompositePkTestService;
import es.limit.cecocloud.marcatges.persist.entity.CompositePkTestEntity;

/**
 * Implementació del servei encarregat de gestionar cpktests.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CompositePkTestServiceImpl extends AbstractGenericCompositePkServiceImpl<CompositePkTest, CompositePkTestEntity, CompositePkTestPk> implements CompositePkTestService {

	@Override
	protected CompositePkTestPk getPkFromDto(CompositePkTest dto) {
		return new CompositePkTestPk(
				dto.getEmpresa().getId(),
				dto.getUsuari().getId(),
				dto.getCodi());
	}

}
