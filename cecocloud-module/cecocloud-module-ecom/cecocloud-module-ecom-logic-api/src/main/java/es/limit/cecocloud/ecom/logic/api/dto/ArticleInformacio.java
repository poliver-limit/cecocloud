/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.ecom.logic.api.converter.ArticleInformacioTipusConverter;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio.ArticleInformacioPk;
import es.limit.cecocloud.ecom.logic.api.dto.enums.ArticleInformacioTipusEnumDto;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Article Informació
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "referenciaSequencial"
)
public class ArticleInformacio extends AbstractIdentificableWithIdentificador<ArticleInformacioPk> {

	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate= true,
			toUpperCase = true,
			hiddenInGrid = false,
			hiddenInForm = false,
			includeInQuickFilter = true)
	private Integer referenciaSequencial;

	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;	
	
	@RestapiField(
			hiddenInLov=true,
			hiddenInGrid = false,
			includeInQuickFilter = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean web = false;	
	
	@RestapiField(hiddenInGrid = false, hiddenInLov = true)	
	@Convert(converter = ArticleInformacioTipusConverter.class)
	private ArticleInformacioTipusEnumDto tipus;
	
	@NotNull
	@Size(max = 250)
	@RestapiField(
			includeInQuickFilter = true)
	private String rutaInforme;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Article,  WithIdentificadorAndCodiPk<String>> article;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String urlImatgeTxt;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class ArticleInformacioPk extends WithIdentificadorPk {
		private String articleCodi;
		private Integer referenciaSequencial;
		public ArticleInformacioPk(
				String identificadorCodi,
				String articleCodi,
				Integer referenciaSequencial) {
			super(identificadorCodi);
			this.articleCodi = articleCodi;
			this.referenciaSequencial = referenciaSequencial;
		}
	}

}
