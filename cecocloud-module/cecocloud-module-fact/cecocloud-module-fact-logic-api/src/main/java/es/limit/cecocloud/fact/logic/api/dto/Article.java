/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
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
	
	@NotNull
	@Size(max = 2000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true)
	private String descripcio;
	
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
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<ArticleModel, WithIdentificadorAndCodiPk<String>> model;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer=12, fraction=3)
	private BigDecimal pvp;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer=12, fraction=3)
	private BigDecimal factorConversioEntrada;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer=12, fraction=3)
	private BigDecimal factorConversioSortida;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
				sizeMax=1,
				hiddenInLov = true)
	private int decimalsPreu;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean bloquejat;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean compost;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean controlStock;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean crearReferencies;
	
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcioCurta;
	@Size(max = 30)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String alies;

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
	@RestapiField(
			type = RestapiFieldType.LOV,
					hiddenInGrid = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> alternatiu;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> alternatiu2;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> articleRaee;	
	


}
