/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost.ProjectePressupostPk;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.Capitol.CapitolPk;
import es.limit.cecocloud.fact.logic.api.dto.Partida.PartidaPk;
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
		descriptionField = "projectePressupostCodi"
)
public class ProjectePressupost extends AbstractIdentificableWithIdentificador<ProjectePressupostPk> {

	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate= false,
			toUpperCase = true,			
			includeInQuickFilter = true)
	private Integer projectePressupostCodi;
	
	@Size(max = 6)
	@RestapiField(			
//			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private String projecteNumero;	

	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
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
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "resumPressupost",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Pressupost, PressupostPk> pressupost;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV)
//			,
//			lovDescriptionField = "descCodiDesc",
//			lovSortFields =  {
//					@RestapiSort(
//							field = "codi",
//							direction = Direction.ASC
//							)
//					})
	private GenericReferenceWithCompositePk<Partida, PartidaPk> partida;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV)
//	,
//			lovDescriptionField = "descCodiDesc",
//			lovSortFields =  {
//					@RestapiSort(
//							field = "codi",
//							direction = Direction.ASC
//							)
//					})
	private GenericReferenceWithCompositePk<Capitol, CapitolPk> capitol;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String observacions;	
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class ProjectePressupostPk extends WithIdentificadorPk {
		private String empresaCodi;
		private Integer projectePressupostCodi;
		private String projecteNumero;
		public ProjectePressupostPk(
				String identificadorCodi,
				String empresaCodi,
				Integer projectePressupostCodi,
				String projecteNumero) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.projectePressupostCodi = projectePressupostCodi;
			this.projecteNumero = projecteNumero;
		}
	}

}
