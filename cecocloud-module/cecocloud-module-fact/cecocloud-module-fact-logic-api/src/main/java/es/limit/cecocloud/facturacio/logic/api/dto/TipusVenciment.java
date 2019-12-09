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
import es.limit.cecocloud.facturacio.logic.api.dto.TipusVenciment.TipusVencimentPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.MesosEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusVencimentEnumDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class TipusVenciment extends AbstractIdentificableWithCompositePk<TipusVencimentPk> {

	@Size(max = 4)
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(type = RestapiFieldType.ENUM)
	private TipusVencimentEnumDto tipus;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean generarCobramentPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	@Size(max = 30)
	private String descripcio;
	
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
	private boolean terminiAMesosComplets;
	
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
	private MesosEnumDto mesTan;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diaPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private MesosEnumDto mesPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean darrerDiaMesVentes;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean darrerDiaMesCompres;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 4)
	private String classeVenciment;
	
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
	public static class TipusVencimentPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
