/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.CompositePk;
import es.limit.cecocloud.logic.api.dto.Comptador.ComptadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un comptador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "darrerValor"
)
public class Comptador extends AbstractIdentificableWithIdentificador<ComptadorPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)	
	private Integer darrerValor;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class ComptadorPk implements CompositePk {
		private String identificadorCodi;
		private String codi;
	}

}
