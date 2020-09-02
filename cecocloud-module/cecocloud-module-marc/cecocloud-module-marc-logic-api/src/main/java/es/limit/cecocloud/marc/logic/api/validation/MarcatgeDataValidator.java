/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.validation;

import java.util.Calendar;
import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import es.limit.base.boot.logic.api.dto.Authority;
import es.limit.base.boot.logic.api.service.PermissionService;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.service.MarcatgeService;

/**
 * Validador de la data dels marcatges. Es fan les següents validacions:
 * · Que la data sigui posterior a la del darrer marcatge del mateix operari.
 * · Que la data no sigui anterior o posterior a la data actual (amb un marge
 *   de minuteMargin minuts).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MarcatgeDataValidator implements ConstraintValidator<MarcatgeData, Marcatge> {

	@Autowired
	private MarcatgeService marcatgeService;
	@Autowired
	private PermissionService permissionService;

	@Value("${cecocloud.marca.minute.margin:5}")
	private int minuteMargin;

	@Override
	public void initialize(MarcatgeData constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Marcatge marcatge,
			ConstraintValidatorContext context) {
		boolean hasAdminPermission = permissionService.checkPermissionForCurrentUser(
				Marcatge.class,
				new Long(0),
				BasePermission.ADMINISTRATION);
		if (!hasAdminPermission) {
			Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			if (!authorities.contains(new SimpleGrantedAuthority(Authority.ADMIN.name()))) {
				if (marcatge.getOperariEmpresa() != null) {
					Marcatge darrerMarcatge = marcatgeService.findDarrerMarcatgePerOperariEmpresa(marcatge.getOperariEmpresa().getId());
					if (darrerMarcatge != null) {
						if (marcatge.getData().before(darrerMarcatge.getData())) {
							context.disableDefaultConstraintViolation();
							context.buildConstraintViolationWithTemplate(
					                "{cecocloud.validation.constraints.MarcatgeData.before.last}").
					        addPropertyNode("data").
							addConstraintViolation();
							return false;
						}
					}
					Calendar dataLimitAfter = Calendar.getInstance();
					dataLimitAfter.add(Calendar.MINUTE, minuteMargin);
					if (marcatge.getData().after(dataLimitAfter.getTime())) {
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate(
				                "{cecocloud.validation.constraints.MarcatgeData.after.limit}").
				        addPropertyNode("data").
						addConstraintViolation();
						return false;
					}
					Calendar dataLimitBefore = Calendar.getInstance();
					dataLimitBefore.add(Calendar.MINUTE, -minuteMargin);
					if (marcatge.getData().before(dataLimitBefore.getTime())) {
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate(
				                "{cecocloud.validation.constraints.MarcatgeData.after.limit}").
				        addPropertyNode("data").
						addConstraintViolation();
						return false;
					}
				}
			}
		}
		return true;
	}

}
