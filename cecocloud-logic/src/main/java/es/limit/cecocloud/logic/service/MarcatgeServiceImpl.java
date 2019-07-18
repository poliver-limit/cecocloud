/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.service.MarcatgeService;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MarcatgeServiceImpl extends AbstractGenericChildServiceImpl<Marcatge, UsuariEmpresaEntity, MarcatgeEntity, Long, Long> implements MarcatgeService {

}
