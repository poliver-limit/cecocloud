/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.dto;

import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.Empresa;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una configuració del mòdul de licitacions per a una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
//		resourceAccessConstraints = {
//				@RestapiResourceAccessConstraint(
//						type = RestapiPermissionConstraintType.AUTHORITY,
//						authoritiesWithPermissions = {
//								@RestapiAuthoritiesWithPermission(permission = "READ", authorities = {Authority.ADMIN}),
//								@RestapiAuthoritiesWithPermission(permission = "WRITE", authorities = {Authority.ADMIN}),
//								@RestapiAuthoritiesWithPermission(permission = "CREATE", authorities = {Authority.ADMIN}),
//								@RestapiAuthoritiesWithPermission(permission = "DELETE", authorities = {Authority.ADMIN}),
//								@RestapiAuthoritiesWithPermission(permission = "ADMINISTRATION", authorities = {Authority.ADMIN}),
//						}
//				)
//		}
	)
public class Configuracio extends AbstractIdentificable<Long> {

	private boolean sincronitzacioActiva;
	private String filtreProvincia;
	private String filtreCpv;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = false)
	private GenericReference<Empresa, Long> empresa;

}
