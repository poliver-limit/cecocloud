/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.Producte.ProductePk;
import es.limit.cecocloud.fact.logic.api.dto.enums.ProducteTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.fact.logic.api.converter.ProducteTipusConverter;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(type = RestapiPermissionConstraintType.ACL_RESOURCE)
		}
)
public class Producte extends AbstractIdentificableWithIdentificador<ProductePk> {

	@RestapiField(hiddenInGrid = true,hiddenInForm = true)
	public static final String FILTER_ACTIU_APLICACIO = "actiu_aplicacio";
	
//	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate= true,
			toUpperCase = true,
			hiddenInGrid = true,
			hiddenInForm = true
			)
	private Integer referencia;
	
	@NotNull
	@Size(max = 15)
	@RestapiField(			
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(			
			includeInQuickFilter = true)
	private String nom;	
	
	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true,
			type = RestapiFieldType.TEXTAREA
	)
	private String descripcio;	
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.TEXTAREA)
	private String observacions;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)	
	@Convert(converter = ProducteTipusConverter.class)
	private ProducteTipusEnumDto tipus;
	
	@NotNull	
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean actiu;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
					hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Producte, ProductePk> producte;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class ProductePk extends WithIdentificadorPk {
		private Integer referencia;
		public ProductePk(
				String identificadorCodi,				
				Integer referencia) {
			super(identificadorCodi);
			this.referencia = referencia;
		}
	}

}
