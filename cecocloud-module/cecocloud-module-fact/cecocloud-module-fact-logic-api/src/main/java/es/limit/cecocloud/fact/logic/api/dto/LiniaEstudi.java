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
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte.EstudiProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi.LiniaEstudiPk;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.fact.logic.api.dto.PressupostLinia.PressupostLiniaPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi.UnitatControlEstudiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'LiniaEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = {"empresa","estudiProjecteCodi","estudiProjecteNum","projecteNum","sequencia"}, groups = { OnCreate.class })
public class LiniaEstudi extends AbstractIdentificableWithIdentificador<LiniaEstudiPk> {

	@Size(max = 30)
	@RestapiField(
			toUpperCase = true,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)
	private String codi;
	
	@Digits(integer = 10, fraction = 0)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer sequencia;
	
	@Digits(integer = 10, fraction = 0)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal easSequencia;
	
	@Digits(integer = 10, fraction = 0)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal seqPae;
	
	@Digits(integer = 15, fraction = 3)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal unitatsPress;
	
	@Digits(integer = 15, fraction = 3)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal unitatsAnterior;
	
	@Digits(integer = 15, fraction = 3)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal unitatsActual;
	
	@Digits(integer = 15, fraction = 2)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal costeAnterior;
	
	@Digits(integer = 15, fraction = 2)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal costeRealAnterior;
	
	@Digits(integer = 15, fraction = 2)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal costeRealActual;
	
	@Digits(integer = 15, fraction = 2)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal importeImputadoAnterior;
	
	@Digits(integer = 15, fraction = 2)
	@RestapiField(
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal importeImputadoActual;
	
	@Size(max = 22)
	@Digits(integer = 3, fraction = 0)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInLov = true)
	private BigDecimal numOrigen;
	
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String codInt;
	
	@NotNull
	@Size(max = 2000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String descripcio;
	
	@NotNull
	@Size(max = 128)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String descripcioReduc;
	
	@NotNull
	@Digits(integer = 15, fraction = 3)
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal unitats;
	
	@NotNull
	@Digits(integer = 17, fraction = 5)
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal preu;
	
	@NotNull
	@Digits(integer = 17, fraction = 5)
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private BigDecimal costUni;
	
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String referencia;
	
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
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecteNum;
	
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
	private GenericReferenceWithCompositePk<EstudiProjecte, EstudiProjectePk> estudiProjecteCodi;
	
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
	private GenericReferenceWithCompositePk<EstudiProjecte, EstudiProjectePk> estudiProjecteNum;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForCreate = true,
			disabledForUpdate = true,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<UnitatControlEstudi, UnitatControlEstudiPk> uceSequencia;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> articulo;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<UnitatTipus, WithIdentificadorAndCodiPk<String>> unitatTipus;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Pressupost, PressupostPk> pressupost;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<PressupostLinia, PressupostLiniaPk> pressupostNumero;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class LiniaEstudiPk extends WithIdentificadorPk {
		private String empresaCodi;
		private Integer sequencia;
		private String projecteNum;
		private String estudiProjecteCodi;
		private BigDecimal estudiProjecteNum;
		public LiniaEstudiPk(
				String identificadorCodi,
				String empresaCodi,
				String projecteNum,
				String estudiProjecteCodi,
				BigDecimal estudiProjecteNum,
				Integer sequencia) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.sequencia = sequencia;
			this.projecteNum = projecteNum;
			this.estudiProjecteCodi = estudiProjecteCodi;
			this.estudiProjecteNum = estudiProjecteNum;
			
		}
	}

}
