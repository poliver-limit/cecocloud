/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamilia.ArticleFamiliaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleFamiliaService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleFamiliaEntity;

/**
 * Implementació del servei de gestió de articles familia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleFamiliaServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleFamilia, ArticleFamiliaEntity, ArticleFamiliaPk> implements ArticleFamiliaService {

	@Override
	protected ArticleFamiliaPk getPkFromDto(ArticleFamilia dto) {
		return new ArticleFamiliaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
