/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.logic.api.service.IdentificadorService;

/**
 * Validador per verificar el nombre màxim d'empreses d'un identificador.
 * 
 * @author Limit Tecnologies
 */
public class IdentificadorMaxEmpresesValidator implements ConstraintValidator<IdentificadorMaxEmpreses, Empresa> {

	@Autowired
	private IdentificadorService identificadorService;
	@Autowired
	private EmpresaService empresaService;

	@Override
	public void initialize(IdentificadorMaxEmpreses constraintAnnotation) {
	}

	@Override
	public boolean isValid(
			Empresa empresa,
			ConstraintValidatorContext context) {
		if (empresa.getId() == null) {
			return validarCreacio(empresa);
		} else {
			return validarModificacio(empresa);
		}
	}

	public boolean validarCreacio(Empresa empresa) {
		if (empresa.getIdentificador() != null) {
			Identificador identificador = identificadorService.getOne(empresa.getIdentificador().getId());
			return (identificador.getEmpresesCount() < identificador.getNumEmpreses());
		} else {
			return true;
		}
	}

	public boolean validarModificacio(Empresa empresa) {
		if (empresa.isActiva()) {
			Empresa empresaGuardada = empresaService.getOne(empresa.getId());
			if (!empresaGuardada.isActiva()) {
				return validarCreacio(empresa);
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

}
