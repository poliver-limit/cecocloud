/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.fact.logic.api.converter.TarifaFormaCalculConverter;
import es.limit.cecocloud.fact.logic.api.converter.TarifaTipusConverter;
import es.limit.cecocloud.fact.logic.api.dto.enums.TarifaFormaCalculEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TarifaTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
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
public class Tarifa extends AbstractIdentificableWithIdentificadorAndCodi<String> {

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
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TarifaTipusConverter.class)
	private TarifaTipusEnumDto tarifaTipus;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TarifaFormaCalculConverter.class)
	private TarifaFormaCalculEnumDto formaCalcul;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean actualitzarPreu = false;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean tarifaOferta = false;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean descomptesGenerals = false;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataInici;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFi;

}
