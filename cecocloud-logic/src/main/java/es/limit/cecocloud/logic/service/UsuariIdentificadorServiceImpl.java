/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorService;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;

/**
 * Implementació del servei de gestió d'usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariIdentificadorServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariIdentificador, UsuariIdentificadorEntity, UsuariIdentificadorPk> implements UsuariIdentificadorService {

	@Override
	protected UsuariIdentificadorPk getPkFromDto(UsuariIdentificador dto) {
		return new UsuariIdentificadorPk(
				dto.getUsuari().getId(),
				dto.getIdentificador().getId());
	}

}

