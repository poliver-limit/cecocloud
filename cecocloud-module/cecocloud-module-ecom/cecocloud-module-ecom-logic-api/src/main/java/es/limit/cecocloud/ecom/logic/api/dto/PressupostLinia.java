/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;


import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
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
	
	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer unitats;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 4000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String descripcio;
	
	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer factorConversioSortides;
	
	@NotNull(groups = { OnCreate.class })	
	@Digits(integer = 12, fraction = 5)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preu;	
	
	@Digits(integer = 11, fraction = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuAmbIva;
	
	@NotNull(groups = { OnCreate.class })	
	@Digits(integer = 13, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuTotalLinia;	
		
	@Digits(integer = 11, fraction = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuTotalLiniaAmbIva;
	
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
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class PressupostLiniaPk extends WithIdentificadorPk {
		private String empresaCodi;
		private Integer pressupostCodi;
		private Integer numero;
		public PressupostLiniaPk(
				String identificadorCodi,
				String empresaCodi,
				Integer pressupostCodi,
				Integer numero) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.pressupostCodi = pressupostCodi;
			this.numero = numero;
		}
	}

}
