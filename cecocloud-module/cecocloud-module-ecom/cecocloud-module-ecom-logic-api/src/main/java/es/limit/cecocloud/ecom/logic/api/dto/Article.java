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
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio.ArticleInformacioPk;
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
public class Article extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 15)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcioCurta;
	
	@NotNull
	@Size(max = 2000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String descripcio;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
				sizeMax=1,
				hiddenInLov = true)
	private int decimalsPreu;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer=12, fraction=3)
	private BigDecimal pvp;
	
	@RestapiField(hiddenInGrid = true,
				sizeMax=1,
				hiddenInLov = true)
	private int decimalsPreuIva;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleFamilia, WithIdentificadorAndCodiPk<String>> familia;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<ArticleModel, WithIdentificadorAndCodiPk<String>> model;	

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleGamma, WithIdentificadorAndCodiPk<String>> gamma;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleMarca, WithIdentificadorAndCodiPk<String>> marca;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,		
			hiddenInLov = true,
			hiddenInGrid = true,
			hiddenInForm = false)	
	private GenericReferenceWithCompositePk<ArticleInformacio, ArticleInformacioPk> articleInformacio;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = true)
	private String articleInformacioRutaInforme;

}
