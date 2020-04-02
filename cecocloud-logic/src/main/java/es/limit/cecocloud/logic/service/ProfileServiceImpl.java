/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.Profile;
import es.limit.base.boot.logic.api.dto.ProfileResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceAction;
import es.limit.base.boot.logic.api.dto.ProfileResourceReport;
import es.limit.base.boot.logic.service.AbstractProfileServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
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
		if (funcionalitat != null && funcionalitat.getFuncionalitatsFilles() != null) {
			ProfileResource profileResource = profile.getResource();
			for (FuncionalitatCodiFont funcionalitatFilla: funcionalitat.getFuncionalitatsFilles()) {
				// Només s'afegeixen les accions simples si es tenen permisos de modificació
				if (funcionalitatFilla.getTipus() == FuncionalitatTipus.ACCIO_SIMPLE && profileResource.isHasUpdatePermission()) {
					if (profileResource.getSimpleActions() == null) {
						profileResource.setSimpleActions(new ArrayList<ProfileResourceAction>());
					}
					profileResource.getSimpleActions().add(
							new ProfileResourceAction(
									funcionalitatFilla.getCodi(),
									funcionalitatFilla.getDescripcio()));
				}
				// Només s'afegeixen les accions múltiples si es tenen permisos de modificació
				if (funcionalitatFilla.getTipus() == FuncionalitatTipus.ACCIO_MULTIPLE && profileResource.isHasUpdatePermission()) {
					if (profileResource.getMultipleActions() == null) {
						profileResource.setMultipleActions(new ArrayList<ProfileResourceAction>());
					}
					profileResource.getMultipleActions().add(
							new ProfileResourceAction(
									funcionalitatFilla.getCodi(),
									funcionalitatFilla.getDescripcio()));
				}
				// Només s'afegeixen els informes si es tenen permisos de lectura
				if (funcionalitatFilla.getTipus() == FuncionalitatTipus.INFORME && profileResource.isHasReadPermission()) {
					if (profileResource.getReports() == null) {
						profileResource.setReports(new ArrayList<ProfileResourceReport>());
					}
					profileResource.getReports().add(
							new ProfileResourceReport(
									funcionalitatFilla.getCodi(),
									funcionalitatFilla.getDescripcio()));
				}
			}
		}
	}

}