/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.service.PerfilUsuariIdentificadorEmpresaService;
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;

/**
 * Implementació del servei encarregat de gestionar relacions perfil-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PerfilUsuariIdentificadorEmpresaServiceImpl extends AbstractGenericServiceImpl<PerfilUsuariIdentificadorEmpresa, PerfilUsuariIdentificadorEmpresaEntity, Long> implements PerfilUsuariIdentificadorEmpresaService {

}
