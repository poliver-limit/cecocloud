/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiOrder;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.module.Modul;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio",
		sortFields = {
				@RestapiOrder(fieldName = "modul"),
				@RestapiOrder(fieldName = "descripcio")
			})
public class Funcionalitat extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 12)
	@RestapiField(
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	private FuncionalitatTipus tipus;
	@NotNull
	@Size(max = 100)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Modul modul;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReference<Funcionalitat, Long> pare;

}
