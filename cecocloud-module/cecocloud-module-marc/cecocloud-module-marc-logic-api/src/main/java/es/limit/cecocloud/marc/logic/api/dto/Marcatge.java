/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
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
			lovNamedFilter = OperariEmpresa.FILTER_MARC_ALLOWED)
	private GenericReference<OperariEmpresa, Long> operariEmpresa;
	@NotNull
	@RestapiField(type = RestapiFieldType.DATETIME)
	private Date data;
	@NotNull
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true)
	private MarcatgeOrigen origen = MarcatgeOrigen.CECOCLOUD;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal latitud;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private BigDecimal longitud;

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
