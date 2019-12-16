/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa.RolUsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.service.RolUsuariIdentificadorEmpresaService;
import es.limit.cecocloud.persist.entity.RolUsuariIdentificadorEmpresaEntity;

/**
 * Implementació del servei de gestió de rol-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RolUsuariIdentificadorEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<RolUsuariIdentificadorEmpresa, RolUsuariIdentificadorEmpresaEntity, RolUsuariIdentificadorEmpresaPk> implements RolUsuariIdentificadorEmpresaService {

	@Override
	protected RolUsuariIdentificadorEmpresaPk getPkFromDto(RolUsuariIdentificadorEmpresa dto) {
		UsuariIdentificadorEmpresaPk pk = getPkFromDtoId(
				dto.getUsuariIdentificadorEmpresa().getId(),
				UsuariIdentificadorEmpresa.class,
				UsuariIdentificadorEmpresaPk.class);
		return new RolUsuariIdentificadorEmpresaPk(
				pk.getUsuariId(),
				pk.getIdentificadorId(),
				pk.getEmpresaId(),
				dto.getRol().getId());
	}
}
