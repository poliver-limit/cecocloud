/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorService;

/**
 * Validador per verificar el nombre màxim d'usuaris d'un identificador.
 * 
 * @author Limit Tecnologies
 */
public class IdentificadorMaxUsuarisValidator implements ConstraintValidator<IdentificadorMaxUsuaris, UsuariIdentificador> {

	@Autowired
	private IdentificadorService identificadorService;
	@Autowired
	private UsuariIdentificadorService usuariIdentificadorService;

	@Override
	public void initialize(IdentificadorMaxUsuaris constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			UsuariIdentificador usuariIdentificador,
			ConstraintValidatorContext context) {
		if (usuariIdentificador.getId() == null) {
			return validarCreacio(usuariIdentificador);
		} else {
			return validarModificacio(usuariIdentificador);
		}
	}

	public boolean validarCreacio(UsuariIdentificador usuariIdentificador) {
		if (usuariIdentificador.getIdentificador() != null) {
			Identificador identificador = identificadorService.getOne(usuariIdentificador.getIdentificador().getId());
			return (identificador.getUsuarisCount() < identificador.getNumUsuaris()); 
		} else {
			return true;
		}
	}

	public boolean validarModificacio(UsuariIdentificador usuariIdentificador) {
		if (usuariIdentificador.isActiu()) {
			UsuariIdentificador usuariIdentificadorGuardat = usuariIdentificadorService.getOne(usuariIdentificador.getId());
			if (!usuariIdentificadorGuardat.isActiu()) {
				return validarCreacio(usuariIdentificador);
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

}
