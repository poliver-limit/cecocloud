/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia.ProvinciaPk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un codi postal
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "poblacio"
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class CodiPostal extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 8)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			includeInQuickFilter = true)
	private String poblacio;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String municipi;

	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Pais, WithIdentificadorAndCodiPk<String>> pais;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Provincia, ProvinciaPk> provincia;	
	
	@Digits(integer=2, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal importRepartiment;	
	
	@Digits(integer=2, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal importMinimRepartiment;
	
	@Digits(integer=2, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal importCompraNoPreuRepartiment;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String poblacioMunicipiCodiTxt;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String poblacioCodiTxt;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String codiPoblacioProvinciaTxt;

}
