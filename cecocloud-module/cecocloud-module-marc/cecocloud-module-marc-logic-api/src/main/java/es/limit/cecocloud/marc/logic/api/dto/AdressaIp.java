/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
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
 * Informació d'una adreça IP que restringeix la creació/modificació dels
 * marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "adressa"
)
public class AdressaIp extends AbstractIdentificable<Long> {

	@NotEmpty
	@Size(max = 40)
	// @Pattern(regexp = "^(?>(?>([a-f0-9]{1,4})(?>:(?1)){7}|(?!(?:.*[a-f0-9](?>:|$)){8,})((?1)(?>:(?1)){0,6})?::(?2)?)|(?>(?>(?1)(?>:(?1)){5}:|(?!(?:.*[a-f0-9]:){6,})(?3)?::(?>((?1)(?>:(?1)){0,4}):)?)?(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(?>\\.(?4)){3}))$")
	@RestapiField(
			includeInQuickFilter = true,
			filterAsSuggest = false)
	private String adressa;

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = false)
	private GenericReference<Empresa, Long> empresa;

}
