/*
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marc.logic.api.dto.LlocFeina;
import es.limit.cecocloud.marc.logic.api.service.LlocFeinaService;
import es.limit.cecocloud.marc.persist.entity.LlocFeinaEntity;

/**
 * Implementació del servei encarregat de gestionar llocs de feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class LlocFeinaServiceImpl extends AbstractGenericServiceImpl<LlocFeina, LlocFeinaEntity, Long> implements LlocFeinaService {

}
