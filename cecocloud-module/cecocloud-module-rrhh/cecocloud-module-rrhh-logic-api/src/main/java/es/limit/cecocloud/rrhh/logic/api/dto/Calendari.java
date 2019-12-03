/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Calendari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Calendari extends AbstractIdentificableWithCompositePk<CalendariPk> {
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Date data;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV, 			
			hiddenInGrid = true)
	private TipusDia tipusDia;
	
	@Size(max = 1000)
	@RestapiField(			
			hiddenInGrid = true)
	private String descripcio;
	
	@Size(max = 1000)
	@RestapiField(		
			hiddenInGrid = true)
	private String observacio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class CalendariPk implements Serializable {
		private String identificadorCodi;	
		private String calendariData;
//		private String codi;
	}

}
