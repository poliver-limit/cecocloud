/*
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marc.logic.api.dto.OperariEmpresaLlocFeina;
import es.limit.cecocloud.marc.logic.api.service.OperariEmpresaLlocFeinaService;
import es.limit.cecocloud.marc.persist.entity.OperariEmpresaLlocFeinaEntity;

/**
 * Implementació del servei encarregat de gestionar relacions (operari-empresa)-(lloc de feina).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OperariEmpresaLlocFeinaServiceImpl extends AbstractGenericServiceImpl<OperariEmpresaLlocFeina, OperariEmpresaLlocFeinaEntity, Long> implements OperariEmpresaLlocFeinaService {

}
