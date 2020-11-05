/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.converter.OperariTipusConverter;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable.HistoricResponsablePk;
import es.limit.cecocloud.fact.logic.api.dto.enums.OperariTipusEnumDto;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
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
		descriptionField = "sequencia"
)
public class HistoricResponsable extends AbstractIdentificableWithIdentificador<HistoricResponsablePk> {

//	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate= true,
			toUpperCase = true,			
			includeInQuickFilter = true)
	private Integer sequencia;
	
	@NotNull
	@RestapiField(hiddenInLov = true)	
	@Convert(converter = OperariTipusConverter.class)
	private OperariTipusEnumDto tipusOperari;
	
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForCreate = false)
	private Date dataInicial;
	
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForCreate = false)
	private Date dataFinal;
	
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
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			lovNamedFilter = Operari.FILTER_ACTIU)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operari;
	

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class HistoricResponsablePk extends WithIdentificadorPk {
		private String empresaCodi;
		private String projecteNumero;
		private Integer sequencia;
		public HistoricResponsablePk(
				String identificadorCodi,
				String empresaCodi,
				String projecteNumero,
				Integer sequencia) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.projecteNumero = projecteNumero;
			this.sequencia = sequencia;
		}
	}

}
