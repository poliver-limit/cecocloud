/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleMagatzem.ArticleMagatzemPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un article magatzem
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = {"article","magatzem"}, groups = { OnCreate.class })
public class ArticleMagatzem extends AbstractIdentificableWithIdentificador<ArticleMagatzemPk> {

	@NotNull
	@RestapiField(
			hiddenInLov=true,
			hiddenInGrid = false,
			includeInQuickFilter = true)	
	private int stock;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ArticleMagatzemPk extends WithIdentificadorPk {
		private String articleCodi;
		private String magatzemCodi;
		public ArticleMagatzemPk(
				String identificadorCodi,
				String articleCodi,
				String magatzemCodi) {
			super(identificadorCodi);
			this.articleCodi = articleCodi;
			this.magatzemCodi = magatzemCodi;
		}
	}

}
