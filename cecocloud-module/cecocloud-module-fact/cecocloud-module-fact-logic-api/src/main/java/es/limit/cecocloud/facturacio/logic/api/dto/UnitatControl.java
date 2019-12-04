/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatControl.UnitatControlPk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una unitat control.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class UnitatControl extends AbstractIdentificableWithCompositePk<UnitatControlPk> {

	@RestapiField(
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInLov=true)
	private int sequencia;
	@NotNull
	@Size(max = 30)
	@RestapiField(
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	@Size(max = 250)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private Integer numeroOrigen;
	private BigDecimal importTotal;
	private BigDecimal costTotal;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class UnitatControlPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
