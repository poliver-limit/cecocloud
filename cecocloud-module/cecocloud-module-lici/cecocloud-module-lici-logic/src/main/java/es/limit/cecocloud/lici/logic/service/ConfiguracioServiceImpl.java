/*
 * 
 */
package es.limit.cecocloud.lici.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.lici.logic.api.service.ConfiguracioService;
import es.limit.cecocloud.lici.persist.entity.ConfiguracioEntity;

/**
 * Implementació del servei encarregat de gestionar configuracions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ConfiguracioServiceImpl extends AbstractGenericServiceImpl<Configuracio, ConfiguracioEntity, Long>
		implements ConfiguracioService {

}
