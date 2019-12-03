/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una Identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Identificador extends AbstractIdentificable<String> {
	
//	@NotNull
//	@Size(max = 40)
//	@RestapiField(
//			includeInQuickFilter = true)
//	protected String nom;
	
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class IdentificadorPk implements Serializable {		
	}
	
	public String getCodi() {
		return this.id;
	}

}
