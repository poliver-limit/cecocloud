/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
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
		descriptionField = "codiDescripcio",
		sortFields = {
				@RestapiSort(field = "modul"),
				@RestapiSort(field = "descripcio")
		}
)
public class Funcionalitat extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 64)
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
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovSortFields =  {
					@RestapiSort(field = "descripcio", direction = Direction.DESC)
			})
	private GenericReference<Funcionalitat, Long> pare;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Modul modul;

	public String getCodiDescripcio() {
		return getCodi() + " - " + getDescripcio();
	}

}
