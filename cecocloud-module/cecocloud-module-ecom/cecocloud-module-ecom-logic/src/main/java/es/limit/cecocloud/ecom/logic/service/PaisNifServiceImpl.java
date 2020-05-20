/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.PaisNif;
import es.limit.cecocloud.ecom.logic.api.service.PaisNifService;
import es.limit.cecocloud.ecom.persist.entity.PaisNifEntity;

/**
 * Implementació del servei de gestió PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomPaisNifServiceImpl")
public class PaisNifServiceImpl extends AbstractGenericServiceImpl<PaisNif, PaisNifEntity, String>
		implements PaisNifService {

}
