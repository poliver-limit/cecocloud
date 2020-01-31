/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.fact.logic.api.service.ArticleMarcaService;
import es.limit.cecocloud.fact.persist.entity.ArticleMarcaEntity;

/**
 * Implementació del servei de gestió de articles marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleMarcaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleMarca, ArticleMarcaEntity, String> implements ArticleMarcaService {

}
