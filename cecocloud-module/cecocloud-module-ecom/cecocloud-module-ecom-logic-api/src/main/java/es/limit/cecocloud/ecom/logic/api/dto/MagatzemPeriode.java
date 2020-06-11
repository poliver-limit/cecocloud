/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
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
@PrimaryKeyNotExists(fields = {"codi","magatzem"}, groups = { OnCreate.class })
public class MagatzemPeriode extends AbstractIdentificableWithIdentificador<MagatzemPeriodePk> {

	@NotNull
	@Size(max = 22)
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
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true, disabledForUpdate = true)	
	private Date dataInici;
	
	@NotNull
	@Transient
	@RestapiField(
			includeInQuickFilter = true, 
			hiddenInForm = false,			
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
