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
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(type = RestapiPermissionConstraintType.ACL_RESOURCE)
		}
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class Article extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 15)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Size(max = 60)
//	@Size(max = 24) // Per adaptació pantalla
	@RestapiField(
			hiddenInGrid = false,
			hiddenInLov = true)
	private String descripcioCurta;
	
	@NotNull
	@Size(max = 2000)
//	@Size(max = 100) // Per adaptació pantalla
	@RestapiField(
			type = RestapiFieldType.TEXTAREA, // Per adaptació pantalla 
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String descripcio;
	
	@NotNull
	@Digits(integer = 15, fraction = 10)
	@RestapiField(			
			hiddenInGrid = false,
			hiddenInLov = true,
			sizeMax = 22)	
	private BigDecimal pvp;
	
	@NotNull
	@Digits(integer = 15, fraction = 10)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuAmbIva;	
	
	@NotNull
	@RestapiField(
				hiddenInGrid = true,
				sizeMax=22,
				hiddenInLov = true)
	private int decimalsPreu;
	
	@RestapiField(
				hiddenInGrid = true,
				sizeMax=22,
				hiddenInLov = true)
	private int decimalsPreuIva;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleFamilia, WithIdentificadorAndCodiPk<String>> familia;
	
	@Transient	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInLov = true)
	private String familiaCodi;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<ArticleModel, WithIdentificadorAndCodiPk<String>> model;	
	
	@Transient	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInLov = true)
	private String modelCodi;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleGamma, WithIdentificadorAndCodiPk<String>> gamma;
	
	@Transient	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInLov = true)
	private String gammaCodi;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleMarca, WithIdentificadorAndCodiPk<String>> marca;
	
	@Transient	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInLov = true)
	private String marcaCodi;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInLov = true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInLov = true)
	private String ivaCodi;
	
//	@Transient	
//	@RestapiField(
//			type = RestapiFieldType.LOV,		
//			hiddenInLov = true,
//			hiddenInGrid = true,
//			hiddenInForm = false
////			,lovDescriptionField = "urlImatgeTxt"
//			)	
//	private GenericReferenceWithCompositePk<ArticleInformacio, ArticleInformacioPk> articleInformacio;	
	
	@NotNull
	@Size(max = 2000)
//	@Size(max = 100) // Per adaptació pantalla 
	@RestapiField(
			type = RestapiFieldType.TEXTAREA, // Per adaptació pantalla 
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String rutaInforme;
	
//	@Transient
//	@RestapiField(
//			hiddenInGrid = false,
//			hiddenInForm = false)
//	private BigDecimal preuSenseIva;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private BigDecimal fixedPvp;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private BigDecimal fixedPreuAmbIva;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private BigDecimal ivaValue;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInLov = true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<TipusUnitat, WithIdentificadorAndCodiPk<String>> tipusUnitat;

}
