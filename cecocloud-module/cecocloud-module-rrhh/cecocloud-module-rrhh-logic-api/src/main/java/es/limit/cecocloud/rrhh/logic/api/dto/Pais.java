/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter
@RestapiResource(descriptionField = "codi")
public class Pais extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 5)
	@NotNull
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;

	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String nif;

	@Size(max = 3)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String codiso;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String codiso002;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean cee;

}
