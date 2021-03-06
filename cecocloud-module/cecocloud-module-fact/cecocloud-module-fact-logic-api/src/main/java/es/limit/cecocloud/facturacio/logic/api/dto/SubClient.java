package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.AlbaraClientSubtipusEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.RebutsEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusDescompteEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusRetencioEnumDto;
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
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String nom;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String domicili;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Boolean bloquejat;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Boolean preusPerVolum;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Tarifa, WithIdentificadorAndCodiPk<String>> tarifa1;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Tarifa, WithIdentificadorAndCodiPk<String>> tarifa2;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<TarifaDescompte, WithIdentificadorAndCodiPk<String>> tarifaDescompte;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private TipusDescompteEnumDto tipusDescompte;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<TipusComissio, WithIdentificadorAndCodiPk<String>> tipusComissio;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk< TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment1;

	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Float percentatgeRetencio;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private TipusRetencioEnumDto tipusRetencio;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk< ClasseRetencio, WithIdentificadorAndCodiPk<String>> claseRetencio;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk< Zona, WithIdentificadorAndCodiPk<String>> zona;

	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private AlbaraClientSubtipusEnumDto albaraClientSubtipus;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private RebutsEnumDto rebuts;
	
	@Size(max = 100)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String emailFactura;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
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
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operarioEncargado;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
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
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<ClientAdresa,ClientAdresaPk > adresaComercialClient;
	
	
	
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
