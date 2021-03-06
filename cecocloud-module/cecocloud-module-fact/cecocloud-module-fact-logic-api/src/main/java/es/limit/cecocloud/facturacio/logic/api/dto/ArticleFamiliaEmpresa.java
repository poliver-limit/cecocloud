/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un article familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class ArticleFamiliaEmpresa extends AbstractIdentificableWithIdentificador<ArticleFamiliaEmpresaPk> {

	@NotNull
	@RestapiField(
			hiddenInLov=true,
					hiddenInGrid = true,
			includeInQuickFilter = true)
	private boolean web;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<ArticleFamilia, WithIdentificadorAndCodiPk<String>> articleFamilia;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ArticleFamiliaEmpresaPk extends WithIdentificadorPk {
		private String articleFamiliaCodi;
		private String empresaCodi;
		public ArticleFamiliaEmpresaPk(
				String identificadorCodi,
				String articleFamiliaCodi,
				String empresaCodi) {
			super(identificadorCodi);
			this.articleFamiliaCodi = articleFamiliaCodi;
			this.empresaCodi = empresaCodi;
		}
	}

}
