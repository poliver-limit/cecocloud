/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.service.OperariService;

/**
 * Validador dels operaris dels marcatges. Es fan les següents validacions:
 * · Que l'usuari tengui permisos per a fer marcatges amb l'operari.
 * · Que l'operari estigui actiu en la data del marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MarcatgeOperariValidValidator implements ConstraintValidator<MarcatgeOperariValidConstraint, Marcatge> {

	@Autowired
	private OperariService operariService;

	@Override
	public void initialize(MarcatgeOperariValidConstraint constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Marcatge marcatge,
			ConstraintValidatorContext context) {
		if (marcatge.getOperari() != null && marcatge.getData() != null) {
			try {
				boolean actiu = operariService.isOperariActiu(
						marcatge.getOperari().getId(),
						marcatge.getData());
				if (!actiu) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(
			                "{marcarge.operari.not.active}").
			        addPropertyNode("operari").
					addConstraintViolation();
				}
			} catch (Exception ex) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
		                "{marcarge.operari.permission.denied}").
		        addPropertyNode("operari").
				addConstraintViolation();
			}
		}
		return true;
	}

}
