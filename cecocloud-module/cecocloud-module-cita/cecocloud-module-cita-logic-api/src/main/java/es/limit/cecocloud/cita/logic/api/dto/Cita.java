/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndEmpresa.WithIdentificadorAndEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una cita d'un punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
public class Cita extends AbstractIdentificableWithIdentificador<CitaPk> {

	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			sizeMax = 10)
	private String codi;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class CitaPk extends WithIdentificadorAndEmpresaPk {
		private String puntVendaCodi;
		private String codi;
		public CitaPk(
				String identificadorCodi,
				String empresaCodi,
				String puntVendaCodi,
				String codi) {
			super(identificadorCodi, empresaCodi);
			this.puntVendaCodi = puntVendaCodi;
			this.codi = codi;
		}
	}

}
