/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalTime;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.RangDatesOrdenat;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.HorariIntervalPk;
import es.limit.cecocloud.cita.logic.api.validation.HorariIntervalNoSolapat;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
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
@HorariIntervalNoSolapat
@RangDatesOrdenat(field1 = "horaInici", field2 = "horaFi")
@RestapiResource(
		descriptionField = "nom"
)
public class HorariInterval extends AbstractIdentificableWithIdentificador<HorariIntervalPk> {

	@RestapiField(
			hiddenInForm = true,
			disabledForUpdate = true)
	private int sequencia;
	@NotNull
	private DiaSetmana diaSetmana;
	@NotNull
	@RestapiField(RestapiFieldType.HOURMINUTE)
	private LocalTime horaInici;
	@NotNull
	@RestapiField(RestapiFieldType.HOURMINUTE)
	private LocalTime horaFi;

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;

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
