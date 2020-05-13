/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

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
import es.limit.base.boot.logic.api.annotation.RestapiResourcePermission;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.EnumeracioTipus;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.EnumeracioTipusEnumConverter;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.ImpressioTipus;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.ImpressioTipusEnumConverter;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom",
		permissionsAllowed = {
				RestapiResourcePermission.READ,
				RestapiResourcePermission.WRITE
		}
)
public class PuntVenda extends AbstractIdentificableWithIdentificador<PuntVendaPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			toUpperCase = true,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 60)
	@RestapiField(
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private String nom;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean ticketIvaInclos = false;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	@Convert(converter = EnumeracioTipusEnumConverter.class)
	private EnumeracioTipus enumeracioTipus;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private Integer ticketNumLiniesEnBlancFinal;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	@Convert(converter = ImpressioTipusEnumConverter.class)
	private ImpressioTipus impressioTipus;
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String codiAperturaCaixa;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private Integer darrerAz;
	@Temporal(TemporalType.TIME)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	@JsonFormat(pattern="HH:mm:ss")
	private Date horaIniciDia;
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String ticketCapçalera;
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String ticketPeu;
	@Size(max = 15)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String tallPaper;
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String adreçaIp;
	@Size(max = 80)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String carpetaImatges;
	@Temporal(TemporalType.DATE)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private Date dataImp;
	@Size(max = 80)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String tpvCarpeta;
	@Size(max = 20)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String tpvBaseDadesNom;
	@RestapiField(
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean citaActiva;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer citaIntervalMinuts;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer citaNumPlaces;
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
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Caixa, CaixaPk> caixa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagamentCobrament;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	//@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operari;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisaSecundaria;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<FestiuGrup, WithIdentificadorAndCodiPk<String>> festiuGrup;

}
