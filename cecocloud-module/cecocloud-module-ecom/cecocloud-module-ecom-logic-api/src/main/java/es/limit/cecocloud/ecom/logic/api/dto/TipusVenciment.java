/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.converter.MesosConverter;
import es.limit.cecocloud.ecom.logic.api.converter.TipusVencimentConverter;
import es.limit.cecocloud.ecom.logic.api.dto.enums.MesosEnumDto;
import es.limit.cecocloud.ecom.logic.api.dto.enums.TipusVencimentEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un tipus venciment
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class TipusVenciment extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@NotNull
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	
	@RestapiField(
			hiddenInLov=true
	)
	@NotNull
	@Size(max = 30)
	private String descripcio;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, type = RestapiFieldType.ENUM)
	@Convert(converter = TipusVencimentConverter.class)
	private TipusVencimentEnumDto tipus;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean generarCobramentPagament = false;
	
	@Digits(integer = 12, fraction = 3)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal importTermini;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=2,
			hiddenInLov = true)
	private Integer diaTermini;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean terminiAMesosComplets = false;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=2,
			hiddenInLov = true)
	private Integer nombreTerminis;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 3, fraction = 2)
	private Float percentatgePrimerTermini;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 3, fraction = 2)
	private Float percentatgeSegonTermini;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 3, fraction = 2)
	private Float percentatgeTercerTermini;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 3, fraction = 2)
	private Float percentatgeQuartTermini;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 3, fraction = 2)
	private Float percentatgeQuintTermini;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 3, fraction = 2)
	private Integer diesPrimerTermini;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diesSegonTermini;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	
	private Integer diesTercerTermini;
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diesQuartTermini;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diesQuintTermini;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer minimDies;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=2,
			hiddenInLov = true)
	private Integer dia2Terminis;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = MesosConverter.class)
	private MesosEnumDto mesTan;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diaPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = MesosConverter.class)
	private MesosEnumDto mesPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean darrerDiaMesVentes = false;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean darrerDiaMesCompres = false;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 4)
	private String classeVenciment;

}
