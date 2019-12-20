/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari.RegistreDiariPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un RegistreDiari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class RegistreDiari extends AbstractIdentificableAmbIdentificador<RegistreDiariPk> {

	@Transient
	@NotNull(groups = {OnCreate.class}) 
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true)	
	private GenericReferenceWithCompositePk<Calendari, CalendariPk> calendari;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Operari, AmbIdentificadorICodiPk<String>> operari;
	
	@NotNull
	private BigDecimal horesTeoriques;
	@NotNull
	private BigDecimal horesNormals;
	@NotNull
	private BigDecimal horesExtras;
	@NotNull
	private BigDecimal preuHoresExtras;
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Horari, AmbIdentificadorICodiPk<String>> horari;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Regim, AmbIdentificadorICodiPk<String>> regim;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Seccio, SeccioPk> seccio;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Empresa, AmbIdentificadorICodiPk<String>> empresa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Categoria, AmbIdentificadorICodiPk<String>> categoria;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Subcategoria, AmbIdentificadorICodiPk<String>> subcategoria;
	
	@NotNull
	private BigDecimal preuHoraNormal;
	@NotNull
	private BigDecimal preuHoraNit;
	@NotNull
	private BigDecimal horesNit;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class RegistreDiariPk extends AmbIdentificadorPk {
		private Date calendariData;
		private String operariCodi;
		public RegistreDiariPk(
				String identificadorCodi,
				Date calendariData,
				String operariCodi) {
			super(identificadorCodi);
			this.calendariData = calendariData;
			this.operariCodi = operariCodi;
		}
	}

}
