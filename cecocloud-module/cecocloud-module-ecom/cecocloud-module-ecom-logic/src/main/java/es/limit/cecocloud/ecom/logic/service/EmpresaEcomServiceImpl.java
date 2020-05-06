/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Empresa;
import es.limit.cecocloud.ecom.logic.api.service.EmpresaEcomService;
import es.limit.cecocloud.ecom.persist.entity.EmpresaEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomEmpresaService")
public class EmpresaEcomServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Empresa, EmpresaEntity, String> implements EmpresaEcomService {

}
