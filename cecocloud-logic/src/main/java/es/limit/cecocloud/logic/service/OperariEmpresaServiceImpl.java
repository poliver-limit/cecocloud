/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;

/**
 * Implementació del servei encarregat de gestionar relacions operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OperariEmpresaServiceImpl extends AbstractGenericServiceImpl<OperariEmpresa, OperariEmpresaEntity, Long> implements OperariEmpresaService {

}

