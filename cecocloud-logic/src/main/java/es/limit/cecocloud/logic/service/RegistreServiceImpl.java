/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.RegistreUsuari;
import es.limit.cecocloud.logic.api.dto.RegistreValidate;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.RegistreService;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import es.limit.cecocloud.persist.repository.UsuariRepository;

/**
 * Implementació del servei encarregat de gestionar usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegistreServiceImpl implements RegistreService {

	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	public void create(RegistreUsuari dto) {
		Usuari usuari = new Usuari();
		usuari.setCodi(dto.getCodi());
		usuari.setNom(dto.getNom());
		usuari.setEmail(dto.getEmail());
		usuari.setRols(new HashSet<Rol>(Arrays.asList(Rol.MARCA)));
		UsuariEntity entity = UsuariEntity.builder().embedded(usuari).build();
		usuariRepository.save(entity);
		// TODO enviar correu de validació
	}

	@Override
	public void contrasenyaRecover(String email) {
		UsuariEntity usuari = usuariRepository.findByEmbeddedEmail(email);
		if (usuari != null) {
			// TODO enviar correu de recuperació de contrasenya
		} else {
			throw new EntityNotFoundException("Usuari amb adreça de correu " + email);
		}
	}

	@Override
	public void validate(RegistreValidate dto) {
		String codi = dto.getToken();
		// TODO decodificar i comprovar token JWT
		UsuariEntity usuari = usuariRepository.findByEmbeddedCodi(codi);
		if (usuari != null) {
			usuari.updateContrasenya(dto.getContrasenya());
		} else {
			throw new EntityNotFoundException("Usuari amb codi " + codi);
		}
	}

}
