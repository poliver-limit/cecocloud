/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.api.dto.ProfileResource;
import es.limit.base.boot.logic.service.AbstractProfileServiceImpl;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modules;

/**
 * Implementació del servei per a obtenir el perfil d'un recurs.
 * 
 * @author Limit Tecnologies
 */
@Service
public class ProfileServiceImpl extends AbstractProfileServiceImpl {

	@Override
	protected void processGeneratedProfile(Class<?> resourceClass, Profile profile) {
		FuncionalitatCodiFont funcionalitat = Modules.getFuncionalitatWithRecursPrincipal(resourceClass);
		if (funcionalitat != null) {
			ProfileResource profileResource = profile.getResource();
			// Només s'afegeixen les accions si es tenen permisos de modificació
			if (profileResource.isHasUpdatePermission()) {
				List<String> simpleActions = profileResource.getSimpleActions() != null ? Arrays.asList(profileResource.getSimpleActions()) : null;
				if (simpleActions != null) {
					profileResource.setSimpleActions(simpleActions.toArray(new String[simpleActions.size()]));
				}
				List<String> multipleActions = profileResource.getMultipleActions() != null ? Arrays.asList(profileResource.getMultipleActions()) : null;
				if (multipleActions != null) {
					profileResource.setMultipleActions(multipleActions.toArray(new String[multipleActions.size()]));
				}
			}
			// Només s'afegeixen els informes si es tenen permisos de lectura
			if (profileResource.isHasReadPermission()) {
				List<String> reports = profileResource.getReports() != null ? Arrays.asList(profileResource.getReports()) : null;
				if (reports != null) {
					profileResource.setReports(reports.toArray(new String[reports.size()]));
				}
			}
		}
	}

}