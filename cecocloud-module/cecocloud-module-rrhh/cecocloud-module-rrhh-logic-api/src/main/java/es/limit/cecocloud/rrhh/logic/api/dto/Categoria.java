/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Categoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Categoria extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@NotNull
	private String nom;
	
	@Size(max = 1000)
	@RestapiField(		
			hiddenInGrid = true)
	private String observacio;
	
	@Digits(integer = 15, fraction = 3)
	@RestapiField(		
			hiddenInGrid = true)
	private BigDecimal souBase;
	
	@RestapiField(		
			hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean actiu = false;

}
