/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost.ProjectePressupostPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Registre Comercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "pressupostNumero"
)
public class ProjectePressupost extends AbstractIdentificableWithIdentificador<ProjectePressupostPk> {


	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate= true,
			toUpperCase = true,			
			includeInQuickFilter = true)
	private Integer pressupostNumero;
	
	@RestapiField(
			includeInQuickFilter = true)
	private Integer pressupostCodi;
	
	@Size(max = 6)
	@RestapiField(			
			includeInQuickFilter = true)
	private String projecteNumero;	
	
	@Size(max = 4)
	@RestapiField(			
			includeInQuickFilter = true)
	private String capitolCodi;	
	
	@Size(max = 4)
	@RestapiField(			
			includeInQuickFilter = true)
	private String partidaCodi;	

	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String observacions;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class ProjectePressupostPk extends WithIdentificadorPk {
		private String empresaCodi;
		private Integer pressupostNumero;
		private String projecteNumero;
		public ProjectePressupostPk(
				String identificadorCodi,
				String empresaCodi,
				Integer pressupostNumero,
				String projecteNumero) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.pressupostNumero = pressupostNumero;
			this.projecteNumero = projecteNumero;
		}
	}

}
