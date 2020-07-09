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
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.DocumentIdentitat;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.Factura.FacturaPk;
import es.limit.cecocloud.ecom.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.enums.FormaPagamentEnumDto;
import es.limit.cecocloud.ecom.logic.api.dto.enums.TipusNifEnumDto;
import es.limit.cecocloud.ecom.logic.api.converter.FormaPagamentConverter;
import es.limit.cecocloud.ecom.logic.api.converter.TipusNifConverter;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "numero"
)
@PrimaryKeyNotExists(fields = {"numero","classe","serieVenda","empresa"}, groups = { OnCreate.class })
public class Factura extends AbstractIdentificableWithIdentificador<FacturaPk> {

	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer numero;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String classe;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 7)
	private Date dia;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, type = RestapiFieldType.ENUM)
	@Convert(converter = FormaPagamentConverter.class)
	private FormaPagamentEnumDto formaPagament;
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 14, fraction = 8)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal valorDivisaEuros;	
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal importBrut;	
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal baseImposable;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true,
			includeInQuickFilter = true)
	private String recarrecEquivalencia = "N";
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal cos;	
	
//	@Size(max = 100)
	@Size(max = 24) // Per adaptacio pantalla
	@RestapiField(hiddenInGrid = true,
			includeInQuickFilter = true)
	private String referencia;	

	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)					
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)		
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;

	@Size(max = 40)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String nomFiscal;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Pressupost, PressupostPk> pressupost;
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = false,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuAmbIva;	
	
	@NotNull(groups = { OnCreate.class })
//	@Size(max = 40)
	@Size(max = 24) // Per adaptacio pantalla
	@RestapiField(
			includeInQuickFilter = true)
	private String nomFiscalClient;

	// Dades extres pel client no registrat:
	@Size(max = 6)
	@RestapiField(hiddenInGrid = true, disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codiClient;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true, 	disabledForCreate = false, disabledForUpdate = true)
	@Size(max = 40)
	private String nomComercial;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusNifConverter.class)
	private TipusNifEnumDto tipusNif;
	
	@Size(max = 12)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
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

//	@Size(max = 60)
	@Size(max = 45) // Per adaptacio pantalla
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String domiciliFiscal;

//	@Size(max = 60)
	@Size(max = 13) // Per adaptacio pantalla
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String telefon;

//	@Size(max = 60)
	@Size(max = 45) // Per adaptacio pantalla
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String email;
	
//	@Size(max = 100)
	@Size(max = 45) // Per adaptacio pantalla
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
	
	// Extres que originalment no hi eren a TGES:	
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
	
 	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<PuntVenda, PuntVendaPk> puntVenda;
	
//	FALTA QUE AQUESTES ENTITATS HI RELACIONIN
//	relacions	taules relacions amb albarà facturat
//	relacions	taules relacions amb bases factura
//	relacions	taules relacions amb venciment
//	relacions	donar per cobrada un factura.

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class FacturaPk extends WithIdentificadorPk {
		private String empresaCodi;
		private String serieVendaCodi;
		private String classe;
		private Integer numero;
		public FacturaPk(
				String identificadorCodi,
				String empresaCodi,
				String serieVendaCodi,
				String classe,
				Integer numero) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.serieVendaCodi = serieVendaCodi;
			this.classe = classe;
			this.numero = numero;
		}
	}

}
