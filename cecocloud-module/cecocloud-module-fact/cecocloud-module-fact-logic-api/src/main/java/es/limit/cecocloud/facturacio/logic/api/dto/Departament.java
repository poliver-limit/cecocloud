/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Departament extends AbstractIdentificableWithIdentificador<DepartamentPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;

	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;

	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class DepartamentPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public DepartamentPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
