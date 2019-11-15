/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.validation;

import java.util.Calendar;
import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import es.limit.base.boot.logic.api.dto.Authority;
import es.limit.cecocloud.marcatges.logic.api.dto.Marcatge;
import es.limit.cecocloud.marcatges.logic.api.service.MarcatgeService;

/**
 * Validador de la data dels marcatges.
 * Es fan les següents validacions:
 * · Que la data sigui posterior a la del darrer marcatge del mateix operari.
 * · Que la no sigui posterior a la data actual (amb un marge de 5 minuts).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MarcatgeDataValidator implements ConstraintValidator<MarcatgeData, Marcatge> {

	@Autowired
	private MarcatgeService marcatgeService;

	@Override
	public void initialize(MarcatgeData constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Marcatge marcatge,
			ConstraintValidatorContext context) {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if (!authorities.contains(new SimpleGrantedAuthority(Authority.ADMIN.name()))) {
			if (marcatge.getOperari() != null) {
				Marcatge darrerMarcatge = marcatgeService.findDarrerMarcatgePerOperari(marcatge.getOperari().getId());
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
				Calendar dataLimit = Calendar.getInstance();
				dataLimit.add(Calendar.MINUTE, 5);
				if (marcatge.getData().after(dataLimit.getTime())) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(
			                "{cecocloud.validation.constraints.MarcatgeData.after.limit}").
			        addPropertyNode("data").
					addConstraintViolation();
					return false;
				}
			}
		}
		return true;
	}

}
