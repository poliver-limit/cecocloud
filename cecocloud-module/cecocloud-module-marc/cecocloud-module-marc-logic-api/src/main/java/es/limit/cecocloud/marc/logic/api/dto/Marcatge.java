/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GeoPosition;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
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
@RestapiResource()
public class Marcatge extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private Operari operari;
	@NotNull
	@RestapiField(type = RestapiFieldType.DATETIME)
	private Date data;
	@NotNull
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true)
	private MarcatgeOrigen origen = MarcatgeOrigen.CECOCLOUD;
	@RestapiField(hiddenInGrid = true)
	private Double latitud;
	@RestapiField(hiddenInGrid = true)
	private Double longitud;

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
