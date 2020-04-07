/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.converter.ArticleFamiliaAvisAlbaraClientConverter;
import es.limit.cecocloud.fact.logic.api.converter.ArticleFamiliaTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.ArticleFamiliaTipusServeiConverter;
import es.limit.cecocloud.fact.logic.api.dto.enums.ArticleFamiliaAvisAlbaraClientEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ArticleFamiliaTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ArticleFamiliaTipusServeiEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
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
		descriptionField = "descripcio",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(type = RestapiPermissionConstraintType.ACL_RESOURCE)
		}
)
public class ArticleFamilia extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@RestapiField(disabledForUpdate = true, 
			toUpperCase = true,
			includeInQuickFilter = true)
	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@NotNull
	@Size(max = 30)
	private String descripcio;	

	@RestapiField(type = RestapiFieldType.ENUM,
			hiddenInGrid = true,
			includeInQuickFilter = true)
	@NotNull
	@Convert(converter = ArticleFamiliaTipusConverter.class)
	private ArticleFamiliaTipusEnumDto tipus;
	
	@NotNull
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean lotNavegable = false;
	
	@NotNull
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean ubicacioNavegable = false;
	
	@RestapiField(type = RestapiFieldType.ENUM,
			hiddenInLov = true,
					hiddenInGrid = true,
			includeInQuickFilter = true)
	@NotNull
	@Convert(converter = ArticleFamiliaAvisAlbaraClientConverter.class)
	private ArticleFamiliaAvisAlbaraClientEnumDto avisAlbaraClient;
	
	@NotNull
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean excloureAlGenerarAlbara = false;
	
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
	@Convert(converter = StringBooleanConverter.class)
	private Boolean productePropi = false;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean tempsFabricacioUnitatsMetriques = false;
	
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean distribuirCostAdicional = false;
	
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
	
	@RestapiField(type = RestapiFieldType.ENUM,
			hiddenInGrid = true,
			includeInQuickFilter = true)
	@Convert(converter = ArticleFamiliaTipusServeiConverter.class)
	private ArticleFamiliaTipusServeiEnumDto tipusServei;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Digits(integer = 4, fraction = 2)
	private Float percentatgePenalitzacioDevolucio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV)	
	private GenericReferenceWithCompositePk<FamiliaCost, WithIdentificadorAndCodiPk<String>> familiaCost;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, 	
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<RecursGrup, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> recursGrup;
	
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInLov = true,hiddenInGrid = true)
	@Size(max = 500)
	private String descOperacio;
	
	@RestapiField(
			hiddenInLov = true,hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean artExportables = false;

}
