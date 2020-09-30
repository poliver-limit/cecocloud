/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup.UsuariGrupPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un usuari del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = {"usuari","grup"}, groups = { OnCreate.class })
public class UsuariGrup extends AbstractIdentificableWithIdentificador<UsuariGrupPk> {
	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 30)
	@RestapiField(
				toUpperCase=true,
				disabledForUpdate = true,
				disabledForCreate = false,
				includeInQuickFilter = true,
				hiddenInLov = true)
	private String usuari;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Group, WithIdentificadorAndCodiPk<String>> grup;
	

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class UsuariGrupPk extends WithIdentificadorPk {
		private String usuariCodi;
		private String grupCodi;
		public UsuariGrupPk(
				String identificadorCodi,
				String usuariCodi,
				String grupCodi) {
			super(identificadorCodi);
			this.usuariCodi = usuariCodi ;
			this.grupCodi = grupCodi;
		}
	}

}
