/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.ecom.logic.api.service.ArticleMarcaService;
import es.limit.cecocloud.ecom.persist.entity.ArticleMarcaEntity;

/**
 * Implementació del servei de gestió de articles marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleMarcaService")
public class ArticleMarcaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleMarca, ArticleMarcaEntity, String> implements ArticleMarcaService {

}
