/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia.PressupostLiniaPk;
import es.limit.cecocloud.ecom.logic.api.dto.Pressupost.PressupostPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "numero"
)
public class PressupostLinia extends AbstractIdentificableWithIdentificador<PressupostLiniaPk> {

//	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
		disabledForCreate = true,
		disabledForUpdate = true,
		hiddenInGrid = true,
		hiddenInForm = true,
		toUpperCase = true,
		includeInQuickFilter = true,
		sizeMax = 22)
	private Integer numero;
	
	@NotNull	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer unitats;
	
	@NotNull
	@Size(max = 4000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String descripcio;
	
	@NotNull	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preu;
	
	@NotNull	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer factorConversioSortides;
	
	@NotNull	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuAmbIva;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Pressupost, PressupostPk> pressupost;
	
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PressupostLiniaPk extends WithIdentificadorAndCodiPk<Integer> {
		private String empresaCodi;
		private Integer pressupostCodi;
		public PressupostLiniaPk(
				String identificadorCodi,
				String empresaCodi,
				Integer pressupostCodi,
				Integer numero) {
			super(identificadorCodi, numero);
			this.empresaCodi = empresaCodi;
			this.pressupostCodi = pressupostCodi;
		}
	}

}
