/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial.RegistreComercialPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.RegistreComercialMitjaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RegistreComercialTipusEnumDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Registre Comercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
public class RegistreComercial extends AbstractIdentificableWithIdentificador<RegistreComercialPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;

	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)	
	private RegistreComercialTipusEnumDto tipus;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)	
	private RegistreComercialMitjaEnumDto mitja;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcioMitja;

	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String interessat;
	
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = true)
	private Date data;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
//	@Transient	
//	@RestapiField(
//			type = RestapiFieldType.LOV,
//			disabledForCreate = false,
//			disabledForUpdate = true,
//			hiddenInGrid = true,
//			hiddenInForm = false)
//	private GenericReferenceWithCompositePk<Producte, WithIdentificadorAndCodiPk<String>> producte;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class RegistreComercialPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public RegistreComercialPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
