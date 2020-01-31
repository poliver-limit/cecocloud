/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.SituacioInicial;
import es.limit.cecocloud.fact.logic.api.dto.SituacioInicial.SituacioInicialPk;
import es.limit.cecocloud.fact.logic.api.service.SituacioInicialService;
import es.limit.cecocloud.fact.persist.entity.SituacioInicialEntity;

/**
 * Implementació del servei de gestió de situacions inicials.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SituacioInicialServiceImpl extends AbstractGenericCompositePkServiceImpl<SituacioInicial, SituacioInicialEntity, SituacioInicialPk> implements SituacioInicialService {

	@Override
	protected SituacioInicialPk getPkFromDto(SituacioInicial dto) {
		return new SituacioInicialPk(
				dto.getIdentificador().getId(),				
				dto.getArticle().getPk().getCodi(),
				dto.getClasse(),
				dto.getMagatzem().getPk().getCodi());
	}

}
