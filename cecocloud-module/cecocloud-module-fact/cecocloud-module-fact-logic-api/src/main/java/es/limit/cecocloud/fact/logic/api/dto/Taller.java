/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.Taller.TallerPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un taller.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = {"empresa"}, groups = { OnCreate.class })
public class Taller extends AbstractIdentificableWithIdentificador<TallerPk> {

	@NotNull
	@Size(max = 4)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			hiddenInLov = true, includeInQuickFilter = true)
	private String nom;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String direccio;
	
	@Size(max = 15)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String col;
	
	@Digits(integer = 3, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal diaOberta;	
	
	@Digits(integer = 3, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal diaSensa;	
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal percControl;	
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ana;
	
	@Size(max = 10)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ctecmpexi;
	
	@Size(max = 10)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ctecmpfacpdt;
	
	@Size(max = 10)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ctecmpdsp;
	
	@Size(max = 6)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String prjnumtlr;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			hiddenInForm = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class TallerPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public TallerPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi ;
		}
	}

}
