/**
 * 
 */
package es.limit.cecocloud.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableWithPermissionsApiController;
import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.service.UsuariService;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Controlador per al servei REST de gestió de recursos de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/identificadors")
public class IdentificadorApiController extends AbstractIdentificableWithPermissionsApiController<Identificador, Long> {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired 
	private UsuariService usuariService;
	@Override
	protected void completeDtoWithSession(Identificador dto, Object userSession) {
		super.completeDtoWithSession(dto, userSession);
		// Afegim l'usuari propietari
		if (dto.getPropietari() == null) {
			String usuariCodi = authenticationHelper.getPrincipalName();
			Usuari usuari = usuariService.findOneByRsqlQuery("codi==\"" + usuariCodi + "\"");
			GenericReference<Usuari, Long> propietari = GenericReference.toGenericReference(usuari.getId());
			propietari.setDescription(usuari.getNomComplet());
			dto.setPropietari(propietari);
		}
	}

	
}
