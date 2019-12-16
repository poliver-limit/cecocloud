/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

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
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una seccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Seccio extends AbstractIdentificableWithCompositePk<SeccioPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;
	
	@Size(max = 30)
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private String compteSous;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private boolean controlPartes;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private boolean controlHoresExtras;
	
	@Size(max = 4)
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private String depcmp;
	
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	private String discos;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	@Digits(integer = 5, fraction = 3)
	private BigDecimal dtehor;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	@Digits(integer = 5, fraction = 2)
	private BigDecimal horesLaboralesDia;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov=true
			)	
	private GenericReference<SeccioGrup, String> seccioGrup;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	@Size(max = 1000)
	private String observaciones;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	@Size(max = 15)
	private String rolVistas;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<IdentificadorRrhh, String> identificador;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<EmpresaRrhh, String> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class SeccioPk implements Serializable {
		private String identificadorCodi;		
		private String codi;
		private String empresaCodi;
	}

}
