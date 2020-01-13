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
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Ubicacio.UbicacioPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una ubicacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Ubicacio extends AbstractIdentificableAmbIdentificador<UbicacioPk> {

	@RestapiField(includeInQuickFilter = true, disabledForUpdate = true)
	@NotNull
	@Size(max = 4)
	private String codi;
	
	@RestapiField(includeInQuickFilter = true)
	@NotNull
	@Size(max = 30)
	private String descripcio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true
//			,hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Magatzem, AmbIdentificadorICodiPk<String>> magatzem;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class UbicacioPk extends AmbIdentificadorICodiPk<String> {
		private String magatzemCodi;
		public UbicacioPk(
				String identificadorCodi,
				String magatzemCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.magatzemCodi = magatzemCodi;
		}
	}

}
