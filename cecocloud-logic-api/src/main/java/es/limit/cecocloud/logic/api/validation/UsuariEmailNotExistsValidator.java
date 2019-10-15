/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.UsuariService;

/**
 * Validador per verificar que no hi ha un altre usuari donat d'alta amb la mateixa
 * adreça de correu electrònic.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class UsuariEmailNotExistsValidator implements ConstraintValidator<UsuariEmailNotExists, Usuari> {

	@Autowired
	private UsuariService usuariService;

	@Override
	public void initialize(UsuariEmailNotExists constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Usuari usuari,
			ConstraintValidatorContext context) {
		Long id = usuari.getId();
		String email = usuari.getEmail();
		if (email != null && !email.isEmpty()) {
			Usuari usuariSameEmail = usuariService.findOneByRsqlQuery("email==" + email);
			if (usuariSameEmail != null && (id == null || !usuariSameEmail.getId().equals(id))) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
		                "{cecocloud.validation.constraints.UsuariEmailNotExists}").
		        addPropertyNode("email").
				addConstraintViolation();
				return false;
			}
		}
		return true;
	}

}
