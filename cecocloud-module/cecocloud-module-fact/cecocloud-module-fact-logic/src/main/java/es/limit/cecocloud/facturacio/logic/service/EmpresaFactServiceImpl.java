/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Empresa;
import es.limit.cecocloud.facturacio.logic.api.service.EmpresaFactService;
import es.limit.cecocloud.facturacio.persist.entity.EmpresaFactEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEmpresaServiceImpl")
public class EmpresaFactServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Empresa, EmpresaFactEntity, String> implements EmpresaFactService {

}
