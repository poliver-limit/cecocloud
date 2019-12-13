/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.service.EmpresaService;
import es.limit.cecocloud.rrhh.persist.entity.EmpresaEntity;

/**
 * Implementació del servei de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("rrhhEmpresaService")
public class EmpresaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Empresa, EmpresaEntity, String> implements EmpresaService {

}
