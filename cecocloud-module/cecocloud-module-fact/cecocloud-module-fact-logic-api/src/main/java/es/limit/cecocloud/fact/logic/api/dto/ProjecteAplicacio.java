/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.converter.AplicacioTipusConverter;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio.ProjecteAplicacioPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AplicacioTipusEnumDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de ProjecteAplicacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
public class ProjecteAplicacio extends AbstractIdentificableWithIdentificador<ProjecteAplicacioPk>{
	
	@NotNull	
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	@Convert(converter = AplicacioTipusConverter.class)
	private AplicacioTipusEnumDto codi;	
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 100)
	private String codiProjecteAap;	
	
	@RestapiField(
			includeInQuickFilter = true)	
	private Float valorPercentual;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,			
			hiddenInLov = true)
	private String observacions;
	
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
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ProjecteAplicacioPk extends WithIdentificadorAndCodiPk<AplicacioTipusEnumDto> {
		private String empresaCodi;
		private String projecteNumero;
		public ProjecteAplicacioPk(
				String identificadorCodi,				
				String empresaCodi,
				String projecteNumero,
				AplicacioTipusEnumDto codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
			this.projecteNumero = projecteNumero;
		}
	}
	

}
