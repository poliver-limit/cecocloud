/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Subcategoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Subcategoria extends AbstractIdentificableWithIdentificadorAndCodi<String> {
	
	@Size(max = 4)
	@NotNull
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV)	
	private GenericReferenceWithCompositePk<Categoria, WithIdentificadorAndCodiPk<String>> categoria;
	
	@NotNull
	@Size(max = 30)
	private String nom;
	
	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true)
	private String observacio;
	
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean actiu;

}
