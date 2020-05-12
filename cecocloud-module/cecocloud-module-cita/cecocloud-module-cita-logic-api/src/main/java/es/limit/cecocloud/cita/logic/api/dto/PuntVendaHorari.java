/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari.PuntVendaHorariPk;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndEmpresa.WithIdentificadorAndEmpresaPk;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació que relaciona un punt de venda amb un horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "horariDescription"
)
public class PuntVendaHorari extends AbstractIdentificableWithIdentificador<PuntVendaHorariPk> {

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<PuntVenda, PuntVendaPk> puntVenda;
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;

	public String getHorariDescription() {
		return horari.getDescription();
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PuntVendaHorariPk extends WithIdentificadorAndEmpresaPk {
		private String puntVendaCodi;
		private String horariCodi;
		public PuntVendaHorariPk(
				String identificadorCodi,
				String empresaCodi,
				String puntVendaCodi,
				String horariCodi) {
			super(identificadorCodi, empresaCodi);
			this.puntVendaCodi = puntVendaCodi;
			this.horariCodi = horariCodi;
		}
	}

}
