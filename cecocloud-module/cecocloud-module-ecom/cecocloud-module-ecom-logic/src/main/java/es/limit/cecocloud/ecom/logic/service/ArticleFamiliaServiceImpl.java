/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.logic.api.service.ArticleFamiliaService;
import es.limit.cecocloud.ecom.persist.entity.ArticleFamiliaEntity;

/**
 * Implementació del servei de gestió de articles familia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleFamiliaService")
public class ArticleFamiliaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleFamilia, ArticleFamiliaEntity, String> implements ArticleFamiliaService {

}
