/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalDate;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.cita.logic.api.dto.Festiu.FestiuPk;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
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
			hiddenInForm = true,
			disabledForUpdate = true)
	private int sequencia;
	@NotNull
	@RestapiField(
		includeInQuickFilter = true)
	@Size(max = 100)
	private String nom;
	@NotNull
	@RestapiField(RestapiFieldType.DAYMONTH)
	private LocalDate diaMes;
	private Integer any;

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<FestiuGrup, WithIdentificadorAndCodiPk<String>> festiuGrup;

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
