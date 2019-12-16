/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;
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
public class Calendari extends AbstractIdentificableAmbIdentificador<CalendariPk> {

	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Date data;
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV, 			
			hiddenInGrid = true)	
	private GenericReference<TipusDia, String> tipusDia;
	@Size(max = 1000)
	@RestapiField(			
			hiddenInGrid = true)
	private String descripcio;
	@Size(max = 1000)
	@RestapiField(		
			hiddenInGrid = true)
	private String observacio;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class CalendariPk extends AmbIdentificadorPk {
		private Date data;
		public CalendariPk(
				String identificadorCodi,
				Date data) {
			super(identificadorCodi);
			this.data = data;
		}
	}

}
