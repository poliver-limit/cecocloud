/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
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
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un vehicle
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = {"codi","transportista"}, groups = { OnCreate.class })
public class Vehicle extends AbstractIdentificableWithIdentificador<VehiclePk> {

	@Size(max = 10)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(includeInQuickFilter = true)
//	@Size(max = 60)
	@Size(max = 36) // Per adaptacio pantalla
	private String descripcio;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	@Size(max = 10)
	private String matricula;
	
	@Size(max = 10)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private String matriculaRemolc;
	
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	@Size(max = 12)
	private String nif;
	
	@Size(max = 30)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private String conductorHabitual;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInLov = true, hiddenInGrid = true)
	private String observacions;
	
	@Digits(integer=10, fraction=3)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private BigDecimal tara;
	
	@Digits(integer=10, fraction=3)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private BigDecimal pesMaxim;	
	
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean actiu=true;	
	
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean vehicleEmpresa = false;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)
	private GenericReferenceWithCompositePk<Transportista, WithIdentificadorAndCodiPk<String>> transportista;
	
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class VehiclePk extends WithIdentificadorAndCodiPk<String> {
		private String transportistaCodi;
		public VehiclePk(
				String identificadorCodi,
				String transportistaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.transportistaCodi = transportistaCodi;
		}
	}

}
