/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.converter.RegistreComercialMitjaConverter;
import es.limit.cecocloud.fact.logic.api.converter.RegistreComercialTipusConverter;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.Producte.ProductePk;
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
		descriptionField = "sequencia"
)
public class RegistreComercial extends AbstractIdentificableWithIdentificador<RegistreComercialPk> {

//	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate= true,
			toUpperCase = true,
			hiddenInGrid = true,
			hiddenInForm = true,
			includeInQuickFilter = true)
	private Integer sequencia;

	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)	
	@Convert(converter = RegistreComercialTipusConverter.class)
	private RegistreComercialTipusEnumDto tipus;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String interessat;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = RegistreComercialMitjaConverter.class)
	private RegistreComercialMitjaEnumDto mitja;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcioMitja;	
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String dadesContacte;
	
	@Size(max = 2000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String comentaris;
	
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForCreate = false)
	private Date data = new Date();
	
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
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Producte, ProductePk> producte;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter @Setter
	@SuppressWarnings("serial")
	public static class RegistreComercialPk extends WithIdentificadorPk {
		private String empresaCodi;
		private Integer sequencia;
		public RegistreComercialPk(
				String identificadorCodi,
				String empresaCodi,
				Integer sequencia) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.sequencia = sequencia;
		}
	}

}
