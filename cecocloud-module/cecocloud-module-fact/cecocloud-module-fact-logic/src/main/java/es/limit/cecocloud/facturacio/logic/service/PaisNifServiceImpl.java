/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.PaisNif;
import es.limit.cecocloud.facturacio.logic.api.service.PaisNifService;
import es.limit.cecocloud.facturacio.persist.entity.PaisNifEntity;

/**
 * Implementació del servei de gestió PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factPaisNifServiceImpl")
public class PaisNifServiceImpl extends AbstractGenericServiceImpl<PaisNif, PaisNifEntity, String>
		implements PaisNifService {

}
