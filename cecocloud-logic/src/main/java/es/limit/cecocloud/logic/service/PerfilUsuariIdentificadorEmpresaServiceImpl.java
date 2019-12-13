/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa.PerfilUsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.service.PerfilUsuariIdentificadorEmpresaService;
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;

/**
 * Implementació del servei de gestió de perfil-rols.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PerfilUsuariIdentificadorEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<PerfilUsuariIdentificadorEmpresa, PerfilUsuariIdentificadorEmpresaEntity, PerfilUsuariIdentificadorEmpresaPk> implements PerfilUsuariIdentificadorEmpresaService {

	@Override
	protected PerfilUsuariIdentificadorEmpresaPk getPkFromDto(PerfilUsuariIdentificadorEmpresa dto) {
		UsuariIdentificadorEmpresaPk pk = getPkFromDtoId(
				dto.getUsuariIdentificadorEmpresa().getId(),
				UsuariIdentificadorEmpresa.class,
				UsuariIdentificadorEmpresaPk.class);
		return new PerfilUsuariIdentificadorEmpresaPk(
				pk.getUsuariId(),
				pk.getIdentificadorId(),
				pk.getEmpresaId(),
				dto.getPerfil().getId());
	}
}
