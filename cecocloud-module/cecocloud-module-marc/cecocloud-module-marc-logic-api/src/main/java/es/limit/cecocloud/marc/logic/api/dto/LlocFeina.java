/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.Empresa;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un lloc de feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class LlocFeina extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 100)
	private String nom;
	@Size(max = 200)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA)
	private String adressa;
	@Size(max = 200)
	private String adrecesIpPermeses;
	@Digits(integer = 12, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal latitud;
	@Digits(integer = 12, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal longitud;
	private int distanciaMaxima = 10;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			includeInQuickFilter = false)
	private GenericReference<Empresa, Long> empresa;

}
