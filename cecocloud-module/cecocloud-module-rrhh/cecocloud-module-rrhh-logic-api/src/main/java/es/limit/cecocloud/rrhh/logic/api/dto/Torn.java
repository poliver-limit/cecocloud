/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@RestapiResource(descriptionField = "nom")
public class Torn extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true)
	private String codi;

	@NotNull
	@Size(max = 30)
	private String nom;
	
	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true)
	private String observacions;

	@NotNull
	@RestapiField(type = RestapiFieldType.TEXTAREA, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean prevalecenLosFestivos = false;
}
