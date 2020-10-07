/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.service.CategoriaTraduccioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Validador per verificar si existeix una categoria traduccio en concret
 * @author Limit Tecnologies
 */
public class CategoriaTraduccioNotExistsValidator implements ConstraintValidator<CategoriaTraduccioNotExists, CategoriaTraduccio> {

	String [] fields;
	private String message;	
	
	@Autowired
	private CategoriaTraduccioService categoriaTraduccioService;

	@Override
	public void initialize(final CategoriaTraduccioNotExists constraintAnnotation) {	
		fields = constraintAnnotation.fields();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final CategoriaTraduccio categoriaTraduccio, final ConstraintValidatorContext context) {		

		for (String field: fields) {				
			context.
			buildConstraintViolationWithTemplate(message).
			addPropertyNode(field).
			addConstraintViolation().
			disableDefaultConstraintViolation();
		}
		
		String idiomaCodi = categoriaTraduccio.getIdioma().getPk().getCodi();
		
		if(categoriaTraduccio.getFamilia()!=null) {
			String familiaCodi = categoriaTraduccio.getFamilia().getPk().getCodi();
			if (existeixCategoriaTraduccio(idiomaCodi,"familia",familiaCodi)) {
				return false;
			}
		}
			
		if(categoriaTraduccio.getMarca()!=null) {			
			String marcaCodi = categoriaTraduccio.getMarca().getPk().getCodi();			
			if (existeixCategoriaTraduccio(idiomaCodi,"marca",marcaCodi)) {
				return false;
			}
		}
				
		if(categoriaTraduccio.getModel()!=null) {				
			String modelCodi = categoriaTraduccio.getModel().getPk().getCodi();			
			if (existeixCategoriaTraduccio(idiomaCodi,"model",modelCodi)) {
				return false;
			}
		}
					
		if(categoriaTraduccio.getGamma()!=null) {					
			String gammaCodi = categoriaTraduccio.getGamma().getPk().getCodi();			
			if (existeixCategoriaTraduccio(idiomaCodi,"gamma",gammaCodi)) {
				return false;
			}
		}		
		
		return true;		
	}
	
	private boolean existeixCategoriaTraduccio (String idiomaCodi, String categoriaNom, String codiCategoria) {
		
		Page<CategoriaTraduccio> categoriaTraduccioPage = categoriaTraduccioService.findPageByQuickFilterAndRsqlQuery(
				null,
				"idioma.codi=="+idiomaCodi+";"+categoriaNom+".codi=="+codiCategoria,
				Pageable.unpaged(),
				Sort.unsorted());
		
		List<CategoriaTraduccio> categoriaTraduccioList = categoriaTraduccioPage.getContent();		
		if (categoriaTraduccioList.size()!=0) {
			return true;
		} else {
			return false;
		}
	}
	
}
