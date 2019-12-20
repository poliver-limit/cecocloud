/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.ArticleFamiliaAvisAlbaraClientEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.ArticleFamiliaTipusEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.ArticleFamiliaTipusServeiEnumDto;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un article familia
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class ArticleFamilia extends AbstractIdentificableAmbIdentificadorICodi<String> {

	@RestapiField(disabledForUpdate = true, 
			toUpperCase = true,
			includeInQuickFilter = true)
	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	private String codi;
	
	@RestapiField(
			includeInQuickFilter = true)
	@NotNull
	@Size(max = 30)
	private String descripcio;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM,
			includeInQuickFilter = true)
	@NotNull
	private ArticleFamiliaTipusEnumDto tipus;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	private boolean lotNavegable;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	private boolean ubicacioNavegable;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM,
			hiddenInLov = true,
			includeInQuickFilter = true)
	@NotNull
	private ArticleFamiliaAvisAlbaraClientEnumDto avisAlbaraClient;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	private boolean excloureAlGenerarAlbara;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Digits(integer = 5, fraction = 2)
	public Float margeSobreCost;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Digits(integer = 5, fraction = 2)
	private Float valorPercentual;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 10)
	private String compteExistencies;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 10)
	private String compteCompres;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 10)
	private String compteVentes;
	
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 1000)
	private String observacions;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private boolean productePropi;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	private boolean tempsFabricacioUnitatsMetriques;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	private boolean distribuirCostAdicional;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Digits(integer = 4, fraction = 0)
	private Long sequenciaOrdenacio;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Min(value = -100)
	@Max(value = 100)
	@Digits(integer = 5, fraction = 2)
	private Float margeMinim;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM,
			includeInQuickFilter = true)
	private ArticleFamiliaTipusServeiEnumDto tipusServei;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Digits(integer = 4, fraction = 2)
	private Float percentatgePenalitzacioDevolucio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<FamiliaCost, AmbIdentificadorICodiPk<String>> familiaCost;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, 	
			hiddenInGrid = true,hiddenInLov = true)	
	private GenericReferenceWithCompositePk<RecursGrup, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk<String>> recursGrup;
	
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInLov = true,hiddenInGrid = true)
	@Size(max = 500)
	private String descOperacio;
	
	@RestapiField(
			hiddenInLov = true,hiddenInGrid = true)
	private boolean artExportables;

}
