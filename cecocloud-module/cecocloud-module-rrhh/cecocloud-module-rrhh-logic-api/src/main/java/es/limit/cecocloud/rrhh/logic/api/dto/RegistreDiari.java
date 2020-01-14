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
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari.RegistreDiariPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
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
public class RegistreDiari extends AbstractIdentificableWithIdentificador<RegistreDiariPk> {

	@Transient
	@NotNull(groups = {OnCreate.class}) 
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true)	
	private GenericReferenceWithCompositePk<Calendari, CalendariPk> calendariData;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Operari, WithIdentificadorAndCodiPk<String>> operari;
	
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
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Regim, WithIdentificadorAndCodiPk<String>> regim;
	
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
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Categoria, WithIdentificadorAndCodiPk<String>> categoria;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Subcategoria, WithIdentificadorAndCodiPk<String>> subcategoria;
	
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
	public static class RegistreDiariPk extends WithIdentificadorPk {
		private Date calendariDataCodi;
//		private String operariCodi;
		public RegistreDiariPk(
				String identificadorCodi,
				Date calendariDataCodi
//				,String operariCodi
				) {
			super(identificadorCodi);
			this.calendariDataCodi = calendariDataCodi;
//			this.operariCodi = operariCodi;
		}
	}

}
