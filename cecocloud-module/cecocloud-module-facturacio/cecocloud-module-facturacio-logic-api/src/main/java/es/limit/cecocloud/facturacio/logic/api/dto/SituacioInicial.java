/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial.SituacioInicialPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
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
public class SituacioInicial extends AbstractIdentificableWithCompositePk<SituacioInicialPk> {

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV, 
			lovWithDescriptionInput = false, 
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private GenericReference<Article, String> article;	
	
	@RestapiField()
	private BigDecimal unitatsInicials;
	
	@RestapiField()
	private BigDecimal unitatsMetriquesInicials;
	
	@RestapiField()
	private BigDecimal preuCostUnitari;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV, 
			lovWithDescriptionInput = false, 
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private Divisa divisa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV, 
			lovWithDescriptionInput = false,
			includeInQuickFilter = false,
			disabledForCreate = true,
			disabledForUpdate = true)
	private ArticleFamilia familia;
	
	@Transient
	@RestapiField(
			lovWithDescriptionInput = false,
			includeInQuickFilter = false,
			disabledForCreate = true,
			disabledForUpdate = true)
	private Object ubicacionsReferencies;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Magatzem, String> magatzem;
	
	@RestapiField()
	private String classe;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class SituacioInicialPk implements Serializable {
		private String identificadorCodi;		
		private String articleCodi;
		private String classe;
		private String magatzemCodi;		
	}

}
