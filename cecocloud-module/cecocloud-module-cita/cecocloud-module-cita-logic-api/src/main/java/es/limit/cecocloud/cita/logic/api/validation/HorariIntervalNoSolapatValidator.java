/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.service.HorariIntervalService;

/**
 * Validador per a evitar el solapament amb altres intervals horaris.
 * 
 * @author Limit Tecnologies
 */
public class HorariIntervalNoSolapatValidator implements ConstraintValidator<HorariIntervalNoSolapat, HorariInterval> {

	private String message;

	@Autowired
	private HorariIntervalService horariIntervalService;

	@Override
	public void initialize(final HorariIntervalNoSolapat constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final HorariInterval value, final ConstraintValidatorContext context) {
		if (value.getHorari() != null && value.getDiaSetmana() != null && value.getHoraInici() != null && value.getHoraFi() != null) {
			List<HorariInterval> intervalsExistents = horariIntervalService.findByHorari(value.getHorari());
			boolean solapat = false;
			for (HorariInterval interval: intervalsExistents) {
				if (!interval.getId().equals(value.getId())) {
					if (interval.getDiaSetmana() == value.getDiaSetmana()) {
						boolean horaIniciSolapada = !value.getHoraInici().isBefore(interval.getHoraInici()) && !value.getHoraInici().isAfter(interval.getHoraFi());
						boolean horaFiSolapada = !value.getHoraFi().isBefore(interval.getHoraInici()) && !value.getHoraFi().isAfter(interval.getHoraFi());
						if (horaIniciSolapada || horaFiSolapada) {
							solapat = true;
							break;
						}
					}
				}
			}
			if (solapat) {
				context.
				buildConstraintViolationWithTemplate(message).
				addPropertyNode("horaInici").
				addConstraintViolation().
				disableDefaultConstraintViolation();
				context.
				buildConstraintViolationWithTemplate(message).
				addPropertyNode("horaFi").
				addConstraintViolation().
				disableDefaultConstraintViolation();
				return false;
			}
		}
		return true;
	}

}
