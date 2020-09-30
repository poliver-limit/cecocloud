/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ConfiguracioImpressos;
import es.limit.cecocloud.fact.logic.api.service.ConfiguracioImpressosService;
import es.limit.cecocloud.fact.persist.entity.ConfiguracioImpressosEntity;

/**
 * Implementation of configuracio d'impressos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ConfiguracioImpressosServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ConfiguracioImpressos, ConfiguracioImpressosEntity, String> implements ConfiguracioImpressosService {

}
