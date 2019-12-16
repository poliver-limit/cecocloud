/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.facturacio.logic.api.service.ArticleMarcaService;
import es.limit.cecocloud.facturacio.persist.entity.ArticleMarcaEntity;

/**
 * Implementació del servei de gestió de articles marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleMarcaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ArticleMarca, ArticleMarcaEntity, String> implements ArticleMarcaService {

}
