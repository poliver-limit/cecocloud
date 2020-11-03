/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.converter.PressupostEstatConverter;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.PressupostEstatEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
public class Pressupost extends AbstractIdentificableWithIdentificador<PressupostPk> {

	@NotNull(groups = { OnCreate.class })	
	@RestapiField(
			disabledForUpdate = true, 
		toUpperCase = true,
		includeInQuickFilter = true)
	private Integer codi;
	
	@RestapiField(
			disabledForCreate = true, 
			disabledForUpdate = true, 
			hiddenInGrid = false,
			hiddenInLov = true,
			sizeMax = 22)
	private int numero;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = true)
	private Date data = new Date();	
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInForm = false, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean desglose = false;
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 14, fraction = 8)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal valorDivisaEuros;
	
	@RestapiField(hiddenInGrid = false, hiddenInLov = true)
	@Convert(converter = PressupostEstatConverter.class)
	private PressupostEstatEnumDto estat;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 40)
	@RestapiField(			
			includeInQuickFilter = true,
			hiddenInGrid = false)
	private String nomClient;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private int versio;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInForm = false, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean certificacioOrigen = false;	
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String classe;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInForm = false, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean seguimentRecepcioMaterial = false;	
	
	@Size(max = 20)
	@RestapiField(			
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String referencia;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = false,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operari;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<SubClient, SubClientPk> subClient;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<ClientAdresa, ClientAdresaPk> clientAdresa;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String resumPressupost;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PressupostPk extends WithIdentificadorAndCodiPk<Integer> {
		private String empresaCodi;
		public PressupostPk(
				String identificadorCodi,
				String empresaCodi,
				Integer codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
