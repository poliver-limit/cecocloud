/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.cecocloud.rrhh.logic.api.dto.Identificador.IdentificadorPk;
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
public class Identificador extends AbstractIdentificableWithCompositePk<IdentificadorPk> {

	@Transient
	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate = true,
			toUpperCase=true,
			includeInQuickFilter = true, 
			gridPercentWidth = 15)
	protected String codi;
	
	@NotNull
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true)
	protected String nom;
	
	@RestapiField(hiddenInLov = true)
	private boolean actiu = true;
	
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class IdentificadorPk implements Serializable {		
	}
	
	public String getCodi() {
		return this.id;
	}

}
