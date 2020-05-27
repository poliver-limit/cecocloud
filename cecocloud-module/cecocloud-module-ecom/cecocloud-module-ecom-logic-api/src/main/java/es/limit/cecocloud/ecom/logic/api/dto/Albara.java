/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.DocumentIdentitat;
import es.limit.cecocloud.ecom.logic.api.converter.TipusNifConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.ecom.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.enums.TipusNifEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un albara
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Albara extends AbstractIdentificableWithIdentificador<AlbaraPk> {

	@NotNull(groups = { OnCreate.class })
	/*@Size(max = 4)
	@RestapiField(
		disabledForUpdate = true, 
		toUpperCase = true,
		includeInQuickFilter = true)
	private String codi;*/
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Integer numeroDocument;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Integer numero;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true)
	private String classe;	

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true)
	private String serCodfac;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Date data;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true)
	private String formaPago;
	
	@NotNull	
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean facturable = false;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true)
	private String desti;	

	@NotNull
	@RestapiField(hiddenInGrid = true)
	private BigDecimal divisaValorEuros;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Integer facturaNumero;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private String facturaClasse;	

	@Size(max = 2000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String observacions;	
	
	@Digits(integer = 7, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal preu;
	
	@Digits(integer = 7, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal preuAmbIva;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@NotNull
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = false,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<PuntVenda, PuntVendaPk> puntVenda;
	
	@NotNull
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
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = false,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = false,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = false,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<MagatzemPeriode, MagatzemPeriodePk> magatzemPeriode;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@NotNull
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = false,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariCml;
	
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
	private GenericReferenceWithCompositePk<Pressupost, PressupostPk> pressupost;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Idioma, WithIdentificadorAndCodiPk<String>> idioma;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Pais, WithIdentificadorAndCodiPk<String>> pais;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Provincia, ProvinciaPk> provincia;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagamentCobrament;
	
	// Dades extres pel client no registrat:
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codiClient;

	@Size(max = 40)
	@NotNull
	@RestapiField(hiddenInLov = true)
	private String nomFiscal;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true, 	disabledForCreate = false, disabledForUpdate = true)
	@Size(max = 40)
	private String nomComercial;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusNifConverter.class)
	private TipusNifEnumDto tipusNif;
	
	@Size(max = 12)
	@RestapiField(hiddenInLov = true)
	@DocumentIdentitat
	private String nif;
	
	@Size(max = 30)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String nomDomicili;

	@Size(max = 5)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String numeroDomicili;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String escalaDomicili;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String pisDomicili;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String portaDomicili;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String domiciliFiscal;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String telefon;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String email;
	
	@Size(max = 100)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String emailFactura;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true
			,
			lovDescriptionField = "nomCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					}
			)
	private GenericReference<PaisNif, String> paisNif;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,		
			lovDescriptionField = "descripcioCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "descripcio",
							direction = Direction.ASC
							)
					}
	)
	private GenericReference<TipusAdresa, String> tipusAdresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "codiPoblacioProvinciaTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "poblacio",
							direction = Direction.ASC
							)
					}
			)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostalClient;
	
	// Falta afegir "clients proveïdors"
	// Transportista i vehicles
	// codi,nom transportista, codis vehicles i descrupcions.
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class AlbaraPk extends WithIdentificadorAndCodiPk<Integer> {
		private String empresaCodi;
		public AlbaraPk(
				String identificadorCodi,
				String empresaCodi,
				Integer codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
