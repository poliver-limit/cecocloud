/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de AreaNegoci.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)

public class AreaNegoci extends AbstractIdentificableWithIdentificador<AreaNegociPk>{
	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;	
		
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
		
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 30)
	private String comptabilitatCodi;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	private String comptabilitatCompteExistencies;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	private String comptabilitatCompteCostos;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	private String comptabilitatCompteProveidors;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	private String comptabilitatCompteClients;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	private String compteMagatzem;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	private String compteObraExecutada;
	
	
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class AreaNegociPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public AreaNegociPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}
	
	
}
