/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleFamiliaEmpresaService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleFamiliaEmpresaEntity;

/**
 * Implementació del servei de gestió de articles familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleFamiliaEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleFamiliaEmpresa, ArticleFamiliaEmpresaEntity, ArticleFamiliaEmpresaPk> implements ArticleFamiliaEmpresaService {

	@Override
	protected ArticleFamiliaEmpresaPk getPkFromDto(ArticleFamiliaEmpresa dto) {
		return new ArticleFamiliaEmpresaPk(
				dto.getIdentificador().getId(),				
				dto.getArticleFamilia().getId(),
				dto.getEmpresa().getId());
	}

}
