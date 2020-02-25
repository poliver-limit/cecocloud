/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;

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
	private OperariEmpresaService operariEmpresaService;

	@Override
	public void initialize(MarcatgeOperariValid constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Marcatge marcatge,
			ConstraintValidatorContext context) {
		if (marcatge.getOperariEmpresa() != null && marcatge.getData() != null) {
			try {
				OperariEmpresa operariEmpresa = operariEmpresaService.getOne(marcatge.getOperariEmpresa().getId());
				if (!operariEmpresa.isActiu()) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(
			                "{cecocloud.validation.constraints.MarcatgeOperariValid.not.active}").
			        addPropertyNode("operariEmpresa").
					addConstraintViolation();
					return false;
				}
			} catch (Exception ex) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
		                "{cecocloud.validation.constraints.MarcatgeOperariValid.permission.denied}").
		        addPropertyNode("operariEmpresa").
				addConstraintViolation();
				return false;
			}
		}
		return true;
	}

}
