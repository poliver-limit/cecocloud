/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa.PerfilUsuariEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import es.limit.cecocloud.logic.api.service.PerfilUsuariEmpresaService;
import es.limit.cecocloud.persist.entity.PerfilUsuariEmpresaEntity;

/**
 * Implementació del servei de gestió de perfil-rols.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PerfilUsuariEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<PerfilUsuariEmpresa, PerfilUsuariEmpresaEntity, PerfilUsuariEmpresaPk> implements PerfilUsuariEmpresaService {

	@Override
	protected PerfilUsuariEmpresaPk getPkFromDto(PerfilUsuariEmpresa dto) {
		UsuariEmpresaPk pk = (UsuariEmpresaPk)getPkFromDtoId(
				dto.getUsuariEmpresa().getId(),
				UsuariEmpresa.class,
				UsuariEmpresaPk.class);
		return new PerfilUsuariEmpresaPk(
				pk.getUsuariId(),
				pk.getEmpresaId(),
				dto.getPerfil().getId());
	}
}
