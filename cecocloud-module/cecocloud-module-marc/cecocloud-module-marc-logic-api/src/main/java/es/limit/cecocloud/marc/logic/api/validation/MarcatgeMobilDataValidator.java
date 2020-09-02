/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.validation;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;

import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobil;

/**
 * Validador de la data dels marcatges mòbils. Es fan les següents validacions:
 * · Que la data no sigui anterior o posterior a la data actual (amb un marge
 *   de minuteMargin minuts).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MarcatgeMobilDataValidator implements ConstraintValidator<MarcatgeMobilData, MarcatgeMobil> {

	@Value("${cecocloud.marca.minute.margin:5}")
	private int minuteMargin;

	@Override
	public void initialize(MarcatgeMobilData constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			MarcatgeMobil marcatge,
			ConstraintValidatorContext context) {
		Calendar dataLimitAfter = Calendar.getInstance();
		dataLimitAfter.add(Calendar.MINUTE, minuteMargin);
		if (marcatge.getData().after(dataLimitAfter.getTime())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
	                "{cecocloud.validation.constraints.MarcatgeDataMobil.out.of.limit}").
	        addPropertyNode("data").
			addConstraintViolation();
			return false;
		}
		Calendar dataLimitBefore = Calendar.getInstance();
		dataLimitBefore.add(Calendar.MINUTE, -minuteMargin);
		if (marcatge.getData().before(dataLimitBefore.getTime())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
	                "{cecocloud.validation.constraints.MarcatgeDataMobil.out.of.limit}").
	        addPropertyNode("data").
			addConstraintViolation();
			return false;
		}
		return true;
	}

}
