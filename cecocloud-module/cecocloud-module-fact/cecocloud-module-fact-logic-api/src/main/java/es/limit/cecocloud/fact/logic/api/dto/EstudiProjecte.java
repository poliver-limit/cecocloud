/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

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
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte.EstudiProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'estudis projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = {"empresa","codi","projecteCodi","numero"}, groups = { OnCreate.class })
public class EstudiProjecte extends AbstractIdentificableWithIdentificador<EstudiProjectePk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			toUpperCase = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)
	private String codi;
	
	@NotNull	
	@Digits(integer = 3, fraction = 0)
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			sizeMax = 22)
	private int numero;
	
	@NotNull	
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)
	private Date diaInici;	
	
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)
	private Date diaFi;
	
	@NotNull	
	@Digits(integer = 15, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal valDivEur;
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String observacions;
	
	@NotNull
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String descripcio;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String tan;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String revisioEstudi;	
	
	@Digits(integer = 15, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal despesesFinanceres;	
	
//	@Digits(integer = 0, fraction = 127)
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal tip;	
	
//	@Digits(integer = 0, fraction = 127)
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal estimacionTramite;	
	
	@Digits(integer = 15, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal magatzemManual;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String revisatResponsable;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String revisatCapGrup;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class EstudiProjectePk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		private int numero;
		private String projecteCodi;
		public EstudiProjectePk(
				String identificadorCodi,
				String empresaCodi,
				int numero,
				String projecteCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
			this.numero = numero;
			this.projecteCodi = projecteCodi;
		}
	}

}
