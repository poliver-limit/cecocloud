/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import es.limit.cecocloud.logic.api.service.UsuariEmpresaService;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;

/**
 * Implementació del servei de gestió d'usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariEmpresa, UsuariEmpresaEntity, UsuariEmpresaPk> implements UsuariEmpresaService {

	@Override
	protected UsuariEmpresaPk getPkFromDto(UsuariEmpresa dto) {
		return new UsuariEmpresaPk(
				dto.getUsuari().getId(),
				dto.getEmpresa().getId());
	}

}
