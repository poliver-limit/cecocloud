/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
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
import es.limit.cecocloud.ecom.logic.api.converter.TipusNifConverter;
import es.limit.cecocloud.ecom.logic.api.dto.enums.TipusNifEnumDto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació de un client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@RestapiResource(descriptionField = "nomComercial")
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class Client extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 6)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;

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
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
				hiddenInGrid = true,
				lovDescriptionField = "nomCodiTxt"	,
				lovSortFields =  {
						@RestapiSort(
								field = "nom",
								direction = Direction.ASC
								)
						}
			)
	private GenericReferenceWithCompositePk<FamiliaClient, WithIdentificadorAndCodiPk<String>> familiaClient;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descripcioCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					}
			)
	private GenericReferenceWithCompositePk<Idioma, WithIdentificadorAndCodiPk<String>> idioma;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descripcioPercentatgeCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					}
			)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;	
	
	@Transient
	@NotNull
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
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TipusFacturacio, WithIdentificadorAndCodiPk<String>> tipusFacturacio;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;

	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagament;	

}
