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
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificador.AmbIdentificadorPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial.SituacioInicialPk;
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
public class SituacioInicial extends AbstractIdentificableAmbIdentificador<SituacioInicialPk> {

	@RestapiField()
	private BigDecimal unitatsInicials;
	
	@RestapiField()
	private BigDecimal unitatsMetriquesInicials;
	
	@RestapiField()
	private BigDecimal preuCostUnitari;
	
	@RestapiField()
	private String classe;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private GenericReference<Article, String> article;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			 
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)	
	private GenericReference<Divisa, String> divisa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			includeInQuickFilter = false,
			disabledForCreate = true,
			disabledForUpdate = true)	
	private GenericReference<ArticleFamilia, String> familia;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Magatzem, String> magatzem;
	
	@Transient
	@RestapiField(			
			includeInQuickFilter = false,
			disabledForCreate = true,
			disabledForUpdate = true)
	private Object ubicacionsReferencies;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SituacioInicialPk extends AmbIdentificadorPk {
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
