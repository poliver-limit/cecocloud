/*
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marc.logic.api.dto.Configuracio;
import es.limit.cecocloud.marc.logic.api.service.ConfiguracioService;
import es.limit.cecocloud.marc.persist.entity.ConfiguracioEntity;

/**
 * Implementació del servei encarregat de gestionar configuracions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("marcConfiguracioServiceImpl")
public class ConfiguracioServiceImpl extends AbstractGenericServiceImpl<Configuracio, ConfiguracioEntity, Long> implements ConfiguracioService {

}
