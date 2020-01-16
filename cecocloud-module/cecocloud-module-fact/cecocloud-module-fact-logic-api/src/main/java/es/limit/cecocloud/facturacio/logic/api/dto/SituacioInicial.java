/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial.SituacioInicialPk;
import es.limit.cecocloud.facturacio.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.facturacio.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una situacio inicial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "article"
)
public class SituacioInicial extends AbstractIdentificableWithIdentificador<SituacioInicialPk> {

	@NotNull
	@RestapiField()
	private BigDecimal unitatsInicials;
	
	@RestapiField()
	private BigDecimal unitatsMetriquesInicials;
	
	@NotNull
	@RestapiField()
	private BigDecimal preuCostUnitari;
	
	@RestapiField()
	private String classe;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true
//			,hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private GenericReferenceWithCompositePk<Article, WithIdentificadorAndCodiPk<String>> article;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			 
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			includeInQuickFilter = false,
			disabledForCreate = true,
			disabledForUpdate = true)	
	private GenericReferenceWithCompositePk<MagatzemPeriode, MagatzemPeriodePk> magatzemPeriode;	

//	@Transient
//	@RestapiField(			
//			includeInQuickFilter = false,
//			disabledForCreate = true,
//			disabledForUpdate = true)
//	private Object ubicacionsReferencies;
// NO EXISTEIX A LA ENTITY DE CECOGEST


	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SituacioInicialPk extends WithIdentificadorPk {
		private String articleCodi;
		private String classe;
		private String magatzemCodi;
		public SituacioInicialPk(
				String identificadorCodi,
				String articleCodi,
				String classe,
				String magatzemCodi) {
			super(identificadorCodi);
			this.articleCodi = articleCodi;
			this.classe = classe;
			this.magatzemCodi = magatzemCodi;
		}
	}

}
