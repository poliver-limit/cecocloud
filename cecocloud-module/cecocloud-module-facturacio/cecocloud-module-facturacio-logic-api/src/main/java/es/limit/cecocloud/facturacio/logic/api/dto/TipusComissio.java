/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusComissio.TipusComissioPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un tipus de comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class TipusComissio extends AbstractIdentificableWithCompositePk<TipusComissioPk> {

	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal percentatge;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal minim;
		
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
	public static class TipusComissioPk implements Serializable {
		private String identificadorCodi;		
		private String codi;
	}

}
