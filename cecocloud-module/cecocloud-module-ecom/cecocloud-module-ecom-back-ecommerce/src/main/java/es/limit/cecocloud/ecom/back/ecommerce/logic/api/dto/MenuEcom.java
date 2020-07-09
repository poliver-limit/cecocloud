/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class MenuEcom extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull
	@Size(max = 15)
	private String codi;
	
	@NotNull
	@Size(max = 20)
	private String label;
	
	@NotNull
	@Size(max = 20)
	private String labelKey;
	
	@NotNull
	@Size(max = 20)
	private String resource;
	
	@NotNull
	@Size(max = 20)
	private String route;
	

}

