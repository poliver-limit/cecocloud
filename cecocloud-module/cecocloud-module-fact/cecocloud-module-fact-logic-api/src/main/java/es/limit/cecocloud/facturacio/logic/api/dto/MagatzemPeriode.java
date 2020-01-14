/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un magatzem periode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
public class MagatzemPeriode extends AbstractIdentificableWithIdentificador<MagatzemPeriodePk> {

	@NotNull
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true, disabledForUpdate = true)	
	private Date dataInici;
	
	@Transient
	@RestapiField(
			includeInQuickFilter = true, 
			hiddenInForm = false, 
			hiddenInGrid = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class MagatzemPeriodePk extends WithIdentificadorAndCodiPk<String> {
		private String magatzemCodi;
		public MagatzemPeriodePk(
				String identificadorCodi,
				String magatzemCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.magatzemCodi = magatzemCodi;
		}
	}

}
