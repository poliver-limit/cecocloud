/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificador.AmbIdentificadorPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una seccio empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class SeccioEmpresa extends AbstractIdentificableAmbIdentificador<SeccioEmpresaPk> {
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			disabledForUpdate = true,  
			toUpperCase = true,
			includeInQuickFilter = true
			)	
	private GenericReference<Seccio, String> seccio;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private BigDecimal valorPercentual;
	
	@Size(max = 1000)
 	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private String observacions;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Empresa, String> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<ArticleFamilia, String> articleFamilia;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SeccioEmpresaPk extends AmbIdentificadorPk {
		private String articleFamiliaCodi;
		private String empresaCodi;
		public SeccioEmpresaPk(
				String identificadorCodi,
				String articleFamiliaCodi,
				String empresaCodi) {
			super(identificadorCodi);
			this.articleFamiliaCodi = articleFamiliaCodi;
			this.empresaCodi = empresaCodi;
		}
	}

}
