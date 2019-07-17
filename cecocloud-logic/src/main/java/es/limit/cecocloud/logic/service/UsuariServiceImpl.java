/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.UsuariService;
import es.limit.cecocloud.persist.entity.UsuariEntity;

/**
 * Implementació del servei encarregat de gestionar usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariServiceImpl extends AbstractGenericServiceImpl<Usuari, UsuariEntity, Long> implements UsuariService {

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	protected void beforeCreate(
			UsuariEntity entity,
			Usuari dto) {
		/*if (dto.getRols() != null) {
			entity.updateRols(dto.getRols());
		}*/
		// Si l'usuari a crear te contrasenya la codifica abans de guardar-la a la base de dades
		if (entity.getEmbedded().getContrasenya() != null) {
			entity.getEmbedded().setContrasenya(
					passwordEncoder.encode(entity.getEmbedded().getContrasenya()));
		}
	}

	@Override
	protected void beforeUpdate(
			UsuariEntity entity,
			Usuari dto) {
		// Si s'envia contrasenya en el DTO es codifica abans de guardar-la a la base de dades
		// Si no s'envia contrasenya s'enten que aquesta es vol deixar sense modificar
		if (dto.getContrasenya() != null) {
			dto.setContrasenya(
					passwordEncoder.encode(dto.getContrasenya()));
		} else {
			dto.setContrasenya(entity.getEmbedded().getContrasenya());
		}
	}

}
