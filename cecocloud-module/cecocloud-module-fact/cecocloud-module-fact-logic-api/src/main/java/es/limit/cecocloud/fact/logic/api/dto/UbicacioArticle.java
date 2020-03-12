/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Ubicacio.UbicacioPk;
import es.limit.cecocloud.fact.logic.api.dto.UbicacioArticle.UbicacioArticlePk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una ubicacioArticle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "unitat"
)
public class UbicacioArticle extends AbstractIdentificableWithIdentificador<UbicacioArticlePk> {

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Ubicacio, UbicacioPk> ubicacio;
	
	@RestapiField(includeInQuickFilter = true)
	@NotNull
	private String unitat;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true
//			,hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;

	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true
//			,hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class UbicacioArticlePk extends WithIdentificadorPk {
		private String articleCodi;
		private String magatzemCodi;
		public UbicacioArticlePk(
				String identificadorCodi,
				String articleCodi,
				String magatzemCodi) {
			super(identificadorCodi);
			this.articleCodi = articleCodi;
			this.magatzemCodi = magatzemCodi;
		}
	}

}
