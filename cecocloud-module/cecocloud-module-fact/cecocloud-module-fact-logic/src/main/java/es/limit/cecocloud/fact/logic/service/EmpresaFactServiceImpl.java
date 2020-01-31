/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.service.EmpresaFactService;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEmpresaServiceImpl")
public class EmpresaFactServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Empresa, EmpresaEntity, String> implements EmpresaFactService {

}
