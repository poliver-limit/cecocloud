/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.service.CompanyiaService;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;

/**
 * Implementació del servei encarregat de gestionar companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CompanyiaServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Companyia, CompanyiaEntity, Long> implements CompanyiaService {

}
