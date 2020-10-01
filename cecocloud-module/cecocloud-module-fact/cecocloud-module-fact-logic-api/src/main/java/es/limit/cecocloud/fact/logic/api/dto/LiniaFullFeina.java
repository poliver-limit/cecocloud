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
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina.LiniaFullFeinaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una linia full feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = {"ordre","finalFactura"}, groups = { OnCreate.class })
public class LiniaFullFeina extends AbstractIdentificableWithIdentificador<LiniaFullFeinaPk> {

	@NotNull
	@Digits(integer = 2, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			sizeMax = 22,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)
	private BigDecimal ordre;	
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String nom;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String imprimir;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String cncFactura;
	
	@Size(max = 255)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String formula;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String aplicaTotal = "N";
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String importFacturat;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<FinalFactura, WithIdentificadorAndCodiPk<String>> finalFactura;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class LiniaFullFeinaPk extends WithIdentificadorPk {
		private String finalFacturaCodi;
		private BigDecimal ordre;
		public LiniaFullFeinaPk(
				String identificadorCodi,
				String finalFacturaCodi,
				BigDecimal ordre) {
			super(identificadorCodi);
			this.finalFacturaCodi = finalFacturaCodi ;
			this.ordre = ordre;
		}
	}

}
