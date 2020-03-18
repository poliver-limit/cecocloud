/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.logic.api.service.OperariService;

/**
 * Validador per verificar el nombre màxim d'operaris d'un identificador.
 * 
 * @author Limit Tecnologies
 */
public class IdentificadorMaxOperarisValidator implements ConstraintValidator<IdentificadorMaxOperaris, Operari> {

	@Autowired
	private IdentificadorService identificadorService;
	@Autowired
	private OperariService operariService;

	@Override
	public void initialize(IdentificadorMaxOperaris constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Operari operari,
			ConstraintValidatorContext context) {
		if (operari.getId() == null) {
			return validarCreacio(operari);
		} else {
			return validarModificacio(operari);
		}
	}

	public boolean validarCreacio(Operari operari) {
		if (operari.getIdentificador() != null) {
			Identificador identificador = identificadorService.getOne(operari.getIdentificador().getId());
			return (identificador.getOperarisCount() < identificador.getNumOperaris()); 
		} else {
			return true;
		}
	}

	public boolean validarModificacio(Operari operari) {
		if (operari.isActiu()) {
			Operari operariGuardat = operariService.getOne(operari.getId());
			if (!operariGuardat.isActiu()) {
				return validarCreacio(operari);
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

}
