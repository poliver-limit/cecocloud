/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.logic.api.converter.AbstractEnumConverter;
import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class PuntVenda extends AbstractIdentificableWithIdentificador<PuntVendaPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean ticketIvaInclos = false;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	@Convert(converter = EnumeracioTipusEnumConverter.class)
	private EnumeracioTipus enumeracioTipus;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private Integer ticketNumLiniesEnBlancFinal;
	@NotNull
	@Convert(converter = ImpressioTipusEnumConverter.class)
	private ImpressioTipus impressioTipus;
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String codiAperturaCaixa;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private Integer darrerAz;
	@Temporal(TemporalType.TIME)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov=true)
	@JsonFormat(pattern="HH:mm:ss")
	private Date horaIniciDia;
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String ticketCapçalera;
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String ticketPeu;
	@Size(max = 15)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String tallPaper;
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String adreçaIp;
	@Size(max = 80)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String carpetaImatges;
	@Temporal(TemporalType.DATE)
	private Date dataImp;
	@Size(max = 80)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String tpvCarpeta;
	@Size(max = 20)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov=true)
	private String tpvBaseDadesNom;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Caixa, CaixaPk> caixa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagamentCobrament;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	//@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operari;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisaSecundaria;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PuntVendaPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public PuntVendaPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

	public enum EnumeracioTipus implements ConvertedEnumInterface<String> {
		DIARIA("D"),
		GLOBAL("G");
		private final String value;
		private EnumeracioTipus(String value) {
			this.value = value;
		}
		public String toDbValue() {
			return value;
		}
	}

	public enum ImpressioTipus implements ConvertedEnumInterface<String> {
		SEMPRE("S"),
		MAI("N"),
		DEMANAR("P");
		private final String value;
		private ImpressioTipus(String value) {
			this.value = value;
		}
		public String toDbValue() {
			return value;
		}
	}

	public static class EnumeracioTipusEnumConverter extends AbstractEnumConverter<EnumeracioTipus, String> {
		public EnumeracioTipusEnumConverter() {
			super(EnumeracioTipus.class);
		}
	}

	public static class ImpressioTipusEnumConverter extends AbstractEnumConverter<ImpressioTipus, String> {
		public ImpressioTipusEnumConverter() {
			super(ImpressioTipus.class);
		}
	}

}
