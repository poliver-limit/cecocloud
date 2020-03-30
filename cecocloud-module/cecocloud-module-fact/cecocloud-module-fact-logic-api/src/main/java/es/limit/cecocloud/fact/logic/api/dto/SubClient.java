/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientSubtipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.RebutsConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusDescompteConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusRetencioConverter;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientSubtipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RebutsEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusDescompteEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusRetencioEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de SubClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)

public class SubClient extends AbstractIdentificableWithIdentificador<SubClientPk>{

	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Size(max = 30)
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			hiddenInLov = true)
	private String nom;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String domicili;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
//	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean bloquejat;
	
//	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean preusPerVolum;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Tarifa, WithIdentificadorAndCodiPk<String>> tarifa1;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Tarifa, WithIdentificadorAndCodiPk<String>> tarifa2;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<TarifaDescompte, WithIdentificadorAndCodiPk<String>> tarifaDescompte;
	
//	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TipusDescompteConverter.class)
	private TipusDescompteEnumDto tipusDescompte;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<TipusComissio, WithIdentificadorAndCodiPk<String>> tipusComissio;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk< TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment1;

	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Float percentatgeRetencio;
	
//	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TipusRetencioConverter.class)
	private TipusRetencioEnumDto tipusRetencio;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk< ClasseRetencio, WithIdentificadorAndCodiPk<String>> claseRetencio;

	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk< Zona, WithIdentificadorAndCodiPk<String>> zona;

	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = AlbaraClientSubtipusConverter.class)
	private AlbaraClientSubtipusEnumDto albaraClientSubtipus;
	
//	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = RebutsConverter.class)
	private RebutsEnumDto rebuts;
	
//	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean publicarDocumentsWeb;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String telefon;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String fax;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String actividad;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operarioEncargado;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operarioResp;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal latitud;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal longitud;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<ClientAdresa,ClientAdresaPk > adresaComercialClient;
	
	@Size (max = 255)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String contacte;
	
	@Size (max = 8)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String cpOficinaComptable;
	          
	@Size (max = 8)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String cpOrganGestor;
	               
	@Size (max = 8)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String cpUnitatTramitadora;
	         
	@Size (max = 60)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String domiciliOficinaComptable;
	    
	@Size (max = 60)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String domiciliOrganGestor;
	         
	@Size (max = 60)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String domiciliUnitatTramitadora;
	   
	@Size (max = 100)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String emailFactures;
	               
	@Size (max = 60)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String email;
	                       
	@Size (max = 2000)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String observacions;
	                
	@Size (max = 30)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String codiOficinaComptable;
	        
	@Size (max = 30)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String codiOrganGestor;
	             
	@Size (max = 2)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String rgiInversio;
	                 
	@Size (max = 2)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String seiInversio;
	                 
	@Size (max = 6)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String tarifaDescompte2;
	            
	@Size (max = 60)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String telefonFactura;
	                     
	@Size (max = 1)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String tipusInversio;
	               
	@Size (max = 30)
	@RestapiField(
		hiddenInGrid = true,
		hiddenInLov = true
	)
	private String codiUnitatTramitadora;
	       
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SubClientPk extends WithIdentificadorAndCodiPk<String> {
		private String clientCodi;
		public SubClientPk(
				String identificadorCodi,
				String clientCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.clientCodi = clientCodi;
		}
	}
	
}
