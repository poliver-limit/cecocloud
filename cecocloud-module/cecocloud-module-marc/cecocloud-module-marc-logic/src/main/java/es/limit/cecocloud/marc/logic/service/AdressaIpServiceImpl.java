/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marc.logic.api.dto.AdressaIp;
import es.limit.cecocloud.marc.logic.api.service.AdressaIpService;
import es.limit.cecocloud.marc.persist.entity.AdressaIpEntity;

/**
 * Implementació del servei encarregat de gestionar adreces IP.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AdressaIpServiceImpl extends AbstractGenericServiceImpl<AdressaIp, AdressaIpEntity, Long> implements AdressaIpService {

}
