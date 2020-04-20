/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.service.CompteComptableEmpresaService;
import es.limit.cecocloud.fact.logic.api.service.EmpresaFactService;

/**
 * Validador per verificar si existeix un registre amb un empresa determinada
 * 
 * @author Limit Tecnologies
 */
public class CCMPEmpresaNotExistsValidator implements ConstraintValidator<CCMPEmpresaNotExists, CompteComptableEmpresa> {

	String field;
	private String message;	
	
	@Autowired
	private CompteComptableEmpresaService compteComptableEmpresaService;
	
	@Autowired
	private EmpresaFactService empresaService;

	@Override
	public void initialize(final CCMPEmpresaNotExists constraintAnnotation) {	
		field = constraintAnnotation.field();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final CompteComptableEmpresa compteComptableEmpresa, final ConstraintValidatorContext context) {		

					
		context.
		buildConstraintViolationWithTemplate(message).
		addPropertyNode(field).
		addConstraintViolation().
		disableDefaultConstraintViolation();		

		boolean existEmpresa = existThisEmp(compteComptableEmpresa);
		return (!existEmpresa);
	}
	
	private boolean existThisEmp (CompteComptableEmpresa compteComptableEmpresa) {	
		
		String empresaId = compteComptableEmpresa.getEmpresa().getId();		
		Empresa empresa = empresaService.getOne(empresaId);		
		String codiEmpresa = empresa.getCodi();		
		CompteComptableEmpresa compteComptableEmpresaCercada = compteComptableEmpresaService.findOneByRsqlQuery("empresa.codi==" + codiEmpresa);
				
		return compteComptableEmpresaCercada!=null;

	}

}
