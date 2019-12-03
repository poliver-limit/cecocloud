/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.Tarifa.TarifaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TarifaFormaCalculEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TarifaTipusEnumDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una tarifa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Tarifa extends AbstractIdentificableWithCompositePk<TarifaPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
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
	@Digits(integer=3, fraction=2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentatgeMaterial;
	
	@NotNull
	@Digits(integer=3, fraction=2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentatgeMaObra;
	
	@Transient
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private TarifaTipusEnumDto tarifaTipus;
	
	@Transient
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private TarifaFormaCalculEnumDto formaCalcul;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean actualitzarPreu;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean tarifaOferta;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean descomptesGenerals;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataInici;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFi;

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
	public static class TarifaPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
