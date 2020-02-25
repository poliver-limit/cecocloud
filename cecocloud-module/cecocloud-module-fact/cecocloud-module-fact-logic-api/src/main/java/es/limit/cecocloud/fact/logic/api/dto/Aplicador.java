/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador.AplicadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AplicadorCategoriaEnumDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de Aplicador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)

public class Aplicador extends AbstractIdentificableWithIdentificador<AplicadorPk>{
	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 30)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String contracte;	
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 60)
	private String cognoms;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	@Size(max = 15)
	private String nif;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)	
	private AplicadorCategoriaEnumDto categoria;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)	
	private Date dataExpedicio;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)	
	private Date dataCaducitat;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	@Size(max = 100)
	private String domicili;	
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String telefon;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String email;	
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 1)
	private String actiu;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class AplicadorPk extends WithIdentificadorPk {
		private String contracte;
		public AplicadorPk(
				String identificadorCodi,				
				String contracte) {
			super(identificadorCodi);
			this.contracte = contracte;
		}
	}
	

}
