/*
 * 
 */
package es.limit.cecocloud.lici.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.lici.logic.api.service.LicitacioService;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;

/**
 * Implementació del servei encarregat de gestionar licitacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class LicitacioServiceImpl extends AbstractGenericServiceImpl<Licitacio, LicitacioEntity, Long>
		implements LicitacioService {

}
