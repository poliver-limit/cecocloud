/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteTarifaProveidor.ProjecteTarifaProveidorPk;
import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor.TarifaProveidorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de ProjecteTarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@PrimaryKeyNotExists(fields = {"proveidor","tarifaProveidor","projecte","empresa"}, groups = { OnCreate.class })
@RestapiResource(
		descriptionField = ""
)
public class ProjecteTarifaProveidor extends AbstractIdentificableWithIdentificador<ProjecteTarifaProveidorPk>{
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,			
			disabledForUpdate = true,
			lovDescriptionField = "descCodiNom",
			lovSortFields =  {
					@RestapiSort(
							field = "nomComercial",
							direction = Direction.ASC
							)
					}
			)
	private GenericReferenceWithCompositePk<Proveidor, WithIdentificadorAndCodiPk<String>> proveidor;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,		
			disabledForUpdate = true		
			)
	private GenericReferenceWithCompositePk<TarifaProveidor, TarifaProveidorPk> tarifaProveidor;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ProjecteTarifaProveidorPk extends WithIdentificadorPk {
		private String empresaCodi;
		private String projecteNumero;
		private String proveidorCodi;
		private String tarifaProveidorCodi;
		public ProjecteTarifaProveidorPk(
				String identificadorCodi,				
				String empresaCodi,
				String projecteNumero,
				String proveidorCodi,
				String tarifaProveidorCodi) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.projecteNumero = projecteNumero;
			this.proveidorCodi = proveidorCodi;
			this.tarifaProveidorCodi = tarifaProveidorCodi;
		}
	}
	

}
