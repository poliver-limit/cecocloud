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
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio.ArticleTraduccioPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un article traducció.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = {"article","idioma"}, groups = { OnCreate.class })
public class ArticleTraduccio extends AbstractIdentificableWithIdentificador<ArticleTraduccioPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 2000)
//	@Size(max = 76) // Per adaptacio pantalla
	@RestapiField(
			type = RestapiFieldType.TEXTAREA, // Per adaptacio pantalla
			hiddenInGrid = false,
			hiddenInLov = true)
	private String descripcio;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Idioma, WithIdentificadorAndCodiPk<String>> idioma;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ArticleTraduccioPk extends WithIdentificadorPk {
		private String articleCodi;
		private String idiomaCodi;
		public ArticleTraduccioPk(
				String identificadorCodi,
				String articleCodi,
				String idiomaCodi) {
			super(identificadorCodi);
			this.articleCodi = articleCodi;
			this.idiomaCodi = idiomaCodi;
		}
	}

}
