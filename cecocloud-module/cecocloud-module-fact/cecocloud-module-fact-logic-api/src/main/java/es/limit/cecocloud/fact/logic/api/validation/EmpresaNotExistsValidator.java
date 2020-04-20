/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.service.CompteCorrentEmpresaService;
import es.limit.cecocloud.fact.logic.api.service.EmpresaFactService;

/**
 * Validador per verificar si existeix un registre amb un empresa determinada
 * 
 * @author Limit Tecnologies
 */
public class EmpresaNotExistsValidator implements ConstraintValidator<EmpresaNotExists, CompteCorrentEmpresa> {

	String field;
	private String message;	
	
	@Autowired
	private CompteCorrentEmpresaService compteCorrentEmpresaService;
	
	@Autowired
	private EmpresaFactService empresaService;

	@Override
	public void initialize(final EmpresaNotExists constraintAnnotation) {	
		field = constraintAnnotation.field();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final CompteCorrentEmpresa compteCorrentEmpresa, final ConstraintValidatorContext context) {		

					
		context.
		buildConstraintViolationWithTemplate(message).
		addPropertyNode(field).
		addConstraintViolation().
		disableDefaultConstraintViolation();		

		boolean existEmpresa = existThisEmp(compteCorrentEmpresa);
		return (!existEmpresa);
	}
	
	private boolean existThisEmp (CompteCorrentEmpresa compteCorrentEmpresa) {	
		
		String empresaId = compteCorrentEmpresa.getEmpresa().getId();		
		Empresa empresa = empresaService.getOne(empresaId);		
		String codiEmpresa = empresa.getCodi();		
		CompteCorrentEmpresa compteCorrentEmpresaCercada = compteCorrentEmpresaService.findOneByRsqlQuery("empresa.codi==" + codiEmpresa);
				
		return compteCorrentEmpresaCercada!=null;

	}

}
