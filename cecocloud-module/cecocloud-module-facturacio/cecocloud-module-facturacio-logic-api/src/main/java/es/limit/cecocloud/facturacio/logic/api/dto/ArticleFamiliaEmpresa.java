/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
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
public class ArticleFamiliaEmpresa extends AbstractIdentificableWithCompositePk<ArticleFamiliaEmpresaPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
//	@Transient
//	@NotNull(groups = {OnCreate.class})
//	@RestapiField(
//			type = RestapiFieldType.LOV, 
//			lovWithDescriptionInput = false, 
//			disabledForUpdate = true,
//			toUpperCase = true,
//			includeInQuickFilter = true)
//	private Empresa empresa;
	
	@NotNull
	@RestapiField(
			hiddenInLov=true,
			includeInQuickFilter = true)
	private boolean web;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<ArticleFamilia, String> articleFamilia;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Empresa, String> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class ArticleFamiliaEmpresaPk implements Serializable {
		private String identificadorCodi;
		private String empresaCodi;
		private String articleFamiliaCodi;
		
		private String codi;
	}

}
