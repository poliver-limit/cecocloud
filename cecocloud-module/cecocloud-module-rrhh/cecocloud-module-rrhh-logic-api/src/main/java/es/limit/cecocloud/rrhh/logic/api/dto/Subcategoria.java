/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
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
public class Subcategoria extends AbstractIdentificableAmbIdentificadorICodi<String> {
	
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;	
	
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true, hiddenInLov = true)
	private String categoriaCodi;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
//	private GenericReference<Categoria, String> categoria;
	private GenericReferenceWithCompositePk<Categoria> categoria;
	
	@Size(max = 30)
	private String nom;
	
	@Size(max = 1000)
	private String observacio;
	
	private boolean actiu;

}
