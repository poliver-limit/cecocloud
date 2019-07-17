/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.service.UsuariEmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEntity;

/**
 * Implementació del servei encarregat de gestionar relacions usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariEmpresaServiceImpl extends AbstractGenericChildChildServiceImpl<UsuariEmpresa, UsuariEntity, EmpresaEntity, UsuariEmpresaEntity, Long, Long, Long> implements UsuariEmpresaService {

}
