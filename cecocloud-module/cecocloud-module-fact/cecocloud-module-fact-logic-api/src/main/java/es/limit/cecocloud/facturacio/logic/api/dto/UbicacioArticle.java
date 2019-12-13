/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;
import es.limit.cecocloud.facturacio.logic.api.dto.UbicacioArticle.UbicacioArticlePk;
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
public class UbicacioArticle extends AbstractIdentificableAmbIdentificador<UbicacioArticlePk> {

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)	
	private GenericReference<Ubicacio, String> ubicacio;
	
	@RestapiField(includeInQuickFilter = true)
	@NotNull
	private String unitat;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Article, String> article;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Magatzem, String> magatzem;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class UbicacioArticlePk extends AmbIdentificadorPk {
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
