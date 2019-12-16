/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial.SituacioInicialPk;
import es.limit.cecocloud.facturacio.logic.api.service.SituacioInicialService;
import es.limit.cecocloud.facturacio.persist.entity.SituacioInicialEntity;

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
				dto.getArticle().getId(),
				dto.getClasse(),
				dto.getMagatzem().getId());
	}

}
