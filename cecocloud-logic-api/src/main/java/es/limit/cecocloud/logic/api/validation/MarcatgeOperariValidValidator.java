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
 * Validador dels operaris dels marcatges.
 * Es fan les següents validacions:
 * · Que l'usuari tengui permisos per a fer marcatges amb l'operari.
 * · Que l'operari estigui actiu en la data del marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MarcatgeOperariValidValidator implements ConstraintValidator<MarcatgeOperariValid, Marcatge> {

	@Autowired
	private OperariService operariService;

	@Override
	public void initialize(MarcatgeOperariValid constraintAnnotation) {
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
			                "{cecocloud.validation.constraints.MarcatgeOperariValid.not.active}").
			        addPropertyNode("operari").
					addConstraintViolation();
					return false;
				}
			} catch (Exception ex) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
		                "{cecocloud.validation.constraints.MarcatgeOperariValid.permission.denied}").
		        addPropertyNode("operari").
				addConstraintViolation();
				return false;
			}
		}
		return true;
	}

}
