/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.fact.logic.api.service.ArticleFamiliaService;
import es.limit.cecocloud.fact.persist.entity.ArticleFamiliaEntity;

/**
 * Implementació del servei de gestió de articles familia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleFamiliaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleFamilia, ArticleFamiliaEntity, String> implements ArticleFamiliaService {

}
