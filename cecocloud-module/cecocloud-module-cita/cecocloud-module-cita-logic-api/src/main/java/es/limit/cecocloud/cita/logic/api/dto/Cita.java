/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalDateTime;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndEmpresa.WithIdentificadorAndEmpresaPk;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
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
			hiddenInForm = true,
			disabledForUpdate = true)
	private int sequencia;
	@Size(max = 34)
	@RestapiField(
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private String codi;
	@NotNull
	private LocalDateTime data;
	@NotNull
	@Size(max = 100)
	private String nom;
	@NotNull
	@Size(max = 100)
	private String llinatges;
	@NotNull
	@Size(max = 15)
	private String telefon;
	@Size(max = 100)
	private String email;
	@RestapiField(
			hiddenInForm = true)
	private LocalDateTime anulacioData;
	@Transient
	private Boolean anulada;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<PuntVenda, PuntVendaPk> puntVenda;

	public Boolean isAnulada() {
		return anulada;
	}
	public void setAnulada(Boolean anulada) {
		this.anulada = anulada;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class CitaPk extends WithIdentificadorAndEmpresaPk {
		private String puntVendaCodi;
		@Setter
		private int sequencia;
		public CitaPk(
				String identificadorCodi,
				String empresaCodi,
				String puntVendaCodi,
				int sequencia) {
			super(identificadorCodi, empresaCodi);
			this.puntVendaCodi = puntVendaCodi;
			this.sequencia = sequencia;
		}
	}

}
