/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

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
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle.MagatzemArticlePk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un article familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = {"magatzem","article"}, groups = { OnCreate.class })
public class MagatzemArticle extends AbstractIdentificableWithIdentificador<MagatzemArticlePk> {

	
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ubicacio;
	
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal stockMinim;	
	
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal stockMaxim;	
	
	@Digits(integer = 17, fraction = 5)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuCostExitencies;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 7)
	private Date diaUltimaCompra;
	
	@Digits(integer = 17, fraction = 5)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal ultimPreuCost;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 7)
	private Date dataUltimAjustInventari;
	
	@Digits(integer = 17, fraction = 5)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal ultimPreuCostComplements;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 7)
	private Date dataUltimaImputacioCostosComplementaris;
	
	@Digits(integer = 17, fraction = 5)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuCostExistenciesAmbComplements;
	
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal demandaMijaAnual;	
	
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private Integer diesEsperaComanda;	
	
	@Digits(integer = 20, fraction = 2)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal costEmmagatzemament;
	
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal lotEconomic;	
	
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal stockSeguretat;	
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;

	@Transient
	@RestapiField(
			hiddenInGrid = false,
			hiddenInForm = false)
	private BigDecimal unitats;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class MagatzemArticlePk extends WithIdentificadorPk {
		private String magatzemCodi;
		private String articleCodi;
		public MagatzemArticlePk(
				String identificadorCodi,
				String magatzemCodi,
				String articleCodi) {
			super(identificadorCodi);
			this.magatzemCodi = magatzemCodi ;
			this.articleCodi = articleCodi;
		}
	}

}
