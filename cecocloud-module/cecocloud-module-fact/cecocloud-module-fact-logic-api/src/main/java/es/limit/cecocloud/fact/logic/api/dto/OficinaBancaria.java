/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)

public class OficinaBancaria extends AbstractIdentificableWithIdentificador<OficinaBancariaPk>{
	
	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private Integer codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 60)
	private String domicili;	
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codipostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Banc, WithIdentificadorAndCodiPk<Integer>> banc;
	
	
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
	private String fax;
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String contacte;
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class OficinaBancariaPk extends WithIdentificadorAndCodiPk<Integer> {
		private Integer bancCodi;
		public OficinaBancariaPk(
				String identificadorCodi,
				Integer bancCodi,
				Integer codi) {
			super(identificadorCodi, codi);
			this.bancCodi = bancCodi;
		}
	}
	

}
