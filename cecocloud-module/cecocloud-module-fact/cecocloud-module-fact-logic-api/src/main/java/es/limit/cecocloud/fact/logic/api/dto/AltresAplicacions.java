/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions.AltresAplicacionsPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'altres aplicacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = {"transportista"}, groups = { OnCreate.class })
public class AltresAplicacions extends AbstractIdentificableWithIdentificador<AltresAplicacionsPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 20)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 22)
	@Digits(integer = 3, fraction = 0)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private BigDecimal aplicacio;
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String observacions;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Transportista, WithIdentificadorAndCodiPk<String>> transportista;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class AltresAplicacionsPk extends WithIdentificadorAndCodiPk<String> {
		private String transportistaCodi;
		private BigDecimal aplicacio;
		public AltresAplicacionsPk(
				String identificadorCodi,
				String transportistaCodi,
				BigDecimal aplicacio,
				String codi) {
			super(identificadorCodi, codi);
			this.transportistaCodi = transportistaCodi;
			this.aplicacio = aplicacio;
		}
	}

}
