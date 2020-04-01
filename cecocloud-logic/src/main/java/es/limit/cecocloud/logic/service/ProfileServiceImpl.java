/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.service.AbstractProfileServiceImpl;

/**
 * Implementació del servei per a obtenir el perfil d'un recurs.
 * 
 * @author Limit Tecnologies
 */
@Service
public class ProfileServiceImpl extends AbstractProfileServiceImpl {

	@Override
	protected void processGeneratedProfile(Class<?> resourceClass, Profile profile) {
		// TODO consultar accions i informes de la funcionalitat que te resourceClass
		// com a recurs principal i afegir-les al profile.
	}

}