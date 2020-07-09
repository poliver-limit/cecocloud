/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Email {	
		
	@NotNull	
	@Size(max = 255)
	protected String to;
	
	@NotNull	
	@Size(max = 25)
	protected String subject;
	
	@NotNull	
	@Size(max = 2000)
	protected String body;
		
	@Size(max = 255)
	protected String from;
	
	@NotNull	
	@Size(max = 255)
	protected String to_cc;
	
		

}