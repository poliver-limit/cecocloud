/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.ecom.logic.api.converter.PaisNifTipusConverter;
import es.limit.cecocloud.ecom.logic.api.dto.enums.PaisNifTipusEnumDto;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@RestapiResource(descriptionField = "nom")
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class PaisNif extends AbstractIdentificable<String> {

	@NotNull
	@Size(max = 2)
	@RestapiField(disabledForUpdate = true)
	private String codi;
	
	@NotNull
	@Convert(converter = PaisNifTipusConverter.class)
	private PaisNifTipusEnumDto tipusNif;
	
	@NotNull
	@Size(max = 40)
	private String nom;
	
	@NotNull
	@Size(max = 15)
	private String tamanyNif;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String nomCodiTxt;
}
