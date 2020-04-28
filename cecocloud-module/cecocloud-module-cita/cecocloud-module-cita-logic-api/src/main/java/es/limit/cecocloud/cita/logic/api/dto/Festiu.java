/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.cita.logic.api.dto.Festiu.FestiuPk;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un dia festiu. Els festius han d'estar associats amb
 * un grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Festiu extends AbstractIdentificableWithIdentificador<FestiuPk> {

	@RestapiField(
			disabledForUpdate = true)
	private int sequencia;
	@NotNull
	@RestapiField(
		includeInQuickFilter = true)
	@Size(max = 100)
	private String nom;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date diaMes;
	@NotNull
	private Integer any;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class FestiuPk extends WithIdentificadorPk {
		private String festiuGrupCodi;
		@Setter
		private Integer sequencia;
		public FestiuPk(
				String identificadorCodi,
				String festiuGrupCodi,
				Integer sequencia) {
			super(identificadorCodi);
			this.festiuGrupCodi = festiuGrupCodi;
			this.sequencia = sequencia;
		}
	}

}
