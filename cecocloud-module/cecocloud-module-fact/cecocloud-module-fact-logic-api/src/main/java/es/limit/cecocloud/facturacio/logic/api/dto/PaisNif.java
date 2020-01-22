package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.PaisNifTipusEnumDto;
import es.limit.cecocloud.logic.api.dto.AbstractIdentificableWithIdentificador;
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

public class PaisNif extends AbstractIdentificableWithIdentificador<String> {

	@NotNull
	@Size(max = 4)
	private String codi;
	
	@NotNull
	@Size(max = 1)
	private PaisNifTipusEnumDto tipusNif;
	
	@NotNull
	@Size(max = 40)
	private String nom;
	
	@NotNull
	@Size(max = 15)
	private String tamanyNif;
}
