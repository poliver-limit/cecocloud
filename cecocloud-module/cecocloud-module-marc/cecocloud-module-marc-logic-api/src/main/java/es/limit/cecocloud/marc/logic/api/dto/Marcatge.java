/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.GeoPosition;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.marc.logic.api.validation.MarcatgeAdressaIpAutoritzada;
import es.limit.cecocloud.marc.logic.api.validation.MarcatgeData;
import es.limit.cecocloud.marc.logic.api.validation.MarcatgeOperariValid;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@MarcatgeOperariValid
@MarcatgeData
@MarcatgeAdressaIpAutoritzada
@RestapiResource(
		descriptionField = "data",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(
						type = RestapiPermissionConstraintType.ACL_RESOURCE,
						resourceClass = "es.limit.cecocloud.marc.logic.api.dto.Marcatge")
		}
)
public class Marcatge extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true,
			lovNamedFilter = OperariEmpresa.FILTER_MARC_ALLOWED,
			filterAsSuggest = false)
	private GenericReference<OperariEmpresa, Long> operariEmpresa;
	@NotNull
	@RestapiField(
			type = RestapiFieldType.DATETIME,
			timeShowSeconds = true,
			datetimeLinkedWithCurrentTime = false)
	private Date data = new Date();
	@NotNull
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true)
	private MarcatgeOrigen origen = MarcatgeOrigen.CECOCLOUD;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private String adressaIp;
	@Digits(integer = 4, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal latitud;
	@Digits(integer = 4, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal longitud;
	@Digits(integer = 4, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal precisio;
	private boolean foraLinia;
	private boolean llocFeinaFora;
	private boolean validat;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true,
			includeInQuickFilter = false)
	private GenericReference<Marcatge, Long> intervalAnterior;
	@Digits(integer = 10, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal intervalDuracio;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private Boolean intervalObert;
	@Digits(integer = 10, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal acumulatAny;
	@Digits(integer = 10, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal acumulatMes;
	@Digits(integer = 10, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal acumulatDia;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInLov = true,
			includeInQuickFilter = false)
	private GenericReference<LlocFeina, Long> llocFeina;

	@Transient
	@RestapiField(
			hiddenInForm = true,
			hiddenInLov = true)
	public GeoPosition getUbicacio() {
		if (getLatitud() != null || getLongitud() != null) {
			return new GeoPosition(
					getLatitud(),
					getLongitud());
		} else {
			return null;
		}
	}

}
