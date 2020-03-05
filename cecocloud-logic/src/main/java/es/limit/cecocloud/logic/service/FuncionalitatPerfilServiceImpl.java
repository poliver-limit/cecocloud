/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import es.limit.cecocloud.logic.api.service.FuncionalitatIdentificadorPerfilService;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatPerfilServiceImpl extends AbstractGenericServiceImpl<FuncionalitatIdentificadorPerfil, FuncionalitatIdentificadorPerfilEntity, Long> implements FuncionalitatIdentificadorPerfilService {

}
