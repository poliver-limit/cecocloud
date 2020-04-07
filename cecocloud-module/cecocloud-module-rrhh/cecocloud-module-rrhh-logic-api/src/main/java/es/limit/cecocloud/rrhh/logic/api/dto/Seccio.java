/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup.SeccioGrupPk;
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
public class Seccio extends AbstractIdentificableWithIdentificador<SeccioPk> {

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
	@Convert(converter = StringBooleanConverter.class)
	private boolean controlPartes = false;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	@Convert(converter = StringBooleanConverter.class)
	private boolean controlHoresExtras = false;
	
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
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true
			)	
	private GenericReferenceWithCompositePk<SeccioGrup, SeccioGrupPk> seccioGrup;
	
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
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SeccioPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public SeccioPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
