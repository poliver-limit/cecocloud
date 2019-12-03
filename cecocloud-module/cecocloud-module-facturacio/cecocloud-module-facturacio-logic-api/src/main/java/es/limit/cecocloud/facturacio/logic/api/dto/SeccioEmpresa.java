/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una seccio empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class SeccioEmpresa extends AbstractIdentificableWithCompositePk<SeccioEmpresaPk> {
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			
			disabledForUpdate = true,  
			toUpperCase = true,
			includeInQuickFilter = true
//			lovModule = "rrhh"
			)
	private Seccio seccio;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private BigDecimal valorPercentual;
	
	@Size(max = 1000)
 	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private String observacions;

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
	private GenericReference<EmpresaFact, String> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<ArticleFamilia, String> articleFamilia;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class SeccioEmpresaPk implements Serializable {
		private String identificadorCodi;		
		private String articleFamiliaCodi;
		private String empresaCodi;
	}

}
