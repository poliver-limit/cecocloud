/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia.AlbaraLiniaPk;
import es.limit.cecocloud.ecom.logic.api.dto.Albara.AlbaraPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un AlbaraLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "numero"
)
public class AlbaraLinia extends AbstractIdentificableWithIdentificador<AlbaraLiniaPk> {

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
	@Size(max = 2000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String descripcio;
	
	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer preu;
	
	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer factorConversioSortides;
	
	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer preuAmbIva;
	
	
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
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Albara, AlbaraPk> albara;
	
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
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class AlbaraLiniaPk extends WithIdentificadorPk {
		private String empresaCodi;
		private Integer albaraNumeroDocument;
		private Integer numero;
		public AlbaraLiniaPk(
				String identificadorCodi,
				String empresaCodi,
				Integer albaraNumeroDocument,
				Integer numero) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.albaraNumeroDocument = albaraNumeroDocument;
			this.numero = numero;
		}
	}

}
