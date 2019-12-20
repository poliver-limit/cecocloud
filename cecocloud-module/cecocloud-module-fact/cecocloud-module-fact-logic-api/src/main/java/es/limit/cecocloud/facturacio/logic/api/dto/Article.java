/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
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
		descriptionField = "codi"
)
public class Article extends AbstractIdentificableAmbIdentificadorICodi<String> {

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
	private GenericReferenceWithCompositePk<ArticleFamilia, AmbIdentificadorICodiPk<String>> familia;
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Iva, AmbIdentificadorICodiPk<String>> iva;
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
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean bloquejat;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean compost;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean controlStock;
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
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleGamma, AmbIdentificadorICodiPk<String>> gamma;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<ArticleMarca, AmbIdentificadorICodiPk<String>> marca;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Empresa, AmbIdentificadorICodiPk<String>> empresa;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Article, AmbIdentificadorICodiPk<String>> alternatiu;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Article, AmbIdentificadorICodiPk<String>> alternatiu2;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Article, AmbIdentificadorICodiPk<String>> articleRaee;
	
	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<ArticleModel, AmbIdentificadorICodiPk<String>> model;

}
