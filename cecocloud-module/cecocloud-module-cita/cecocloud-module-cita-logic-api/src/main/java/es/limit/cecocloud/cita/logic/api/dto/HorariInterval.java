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
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.HorariIntervalPk;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un interval horari. Aquests intervals permeten definir
 * els dies i les hores d'atenció al públic d'un punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class HorariInterval extends AbstractIdentificableWithIdentificador<HorariIntervalPk> {

	@RestapiField(
			disabledForUpdate = true)
	private int sequencia;
	@NotNull
	private DiaSetmana diaSetmana;
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date horaInici;
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date horaFi;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class HorariIntervalPk extends WithIdentificadorPk {
		private String horariCodi;
		@Setter
		private Integer sequencia;
		public HorariIntervalPk(
				String identificadorCodi,
				String horariCodi,
				Integer sequencia) {
			super(identificadorCodi);
			this.horariCodi = horariCodi;
			this.sequencia = sequencia;
		}
	}

	public static enum DiaSetmana {
		DILLUNS,
		DIMARTS,
		DIMECRES,
		DIJOUS,
		DIVENDRES,
		DISSABTE,
		DIUMENGE
	}

}
