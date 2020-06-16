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
import es.limit.cecocloud.ecom.logic.api.dto.Stock.StockPk;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
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
@PrimaryKeyNotExists(fields = {"STO_TIP","magatzem","magatzemPeriode","article"}, groups = { OnCreate.class })
public class Stock extends AbstractIdentificableWithIdentificador<StockPk> {
	
	@NotNull
	@Size(max = 1)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String STO_TIP = "1";
	
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIINI;
	                                   
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALINI;
	                                        
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNICPRPRO;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALCPRPRO;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIENTALTMAG;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALENTALTMAG;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIENTINV;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALENTINV;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIPENREB;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALPENREB;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIDIPPRO;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALDIPPRO;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIFAB;
	                                        
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALFAB;
	                                        
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORALB;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORALB;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIRSV;
	                                        
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALUNIRSV;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORMAG;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORMAG;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORINV;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORINV;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNICOMCLI;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALCOMCLI;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIDIPCLI;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALDIPCLI;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIDEF;
	                                        
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALDEF;
	                                        
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORFAB;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORFAB;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORFABALB;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIINI002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALINI002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNICPRPRO002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALCPRPRO002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIENTALTMAG002;
	                               
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALENTALTMAG002;
	                               
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIENTINV002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALENTINV002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORALB002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORALB002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIRSV002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALRSV002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORALTMAG002;
	                               
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORALTMAG002;
	                               
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORINV002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORINV002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIDEF002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALDEF002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORFABALB002;
	                               
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNIFAB002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALFAB002;
	                                     
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_UNISORFAB002;
	                                  
	@Digits(integer = 19, fraction = 3)
	@RestapiField(hiddenInGrid = true,hiddenInLov = true,sizeMax = 22)
	private BigDecimal STO_VALSORFAB002;	                                  
	
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
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<MagatzemPeriode, MagatzemPeriodePk> magatzemPeriode;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true,
			disabledForCreate = false)	
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class StockPk extends WithIdentificadorPk {		
		private String magatzemCodi;
		private String magatzemPeriodeCodi;
		private String articleCodi;
		private String STO_TIP;
		public StockPk(
				String identificadorCodi,
				String magatzemCodi,
				String magatzemPeriodeCodi,
				String articleCodi,
				String STO_TIP) {
			super(identificadorCodi);
			this.magatzemCodi = magatzemCodi;
			this.magatzemPeriodeCodi = magatzemPeriodeCodi;
			this.articleCodi = articleCodi;
			this.STO_TIP = STO_TIP;
		}
	}

}
