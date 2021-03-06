/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.SerieFacturaRectificativaEnumDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una serie venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class SerieVenda extends AbstractIdentificableWithIdentificador<SerieVendaPk> {

	@NotNull
	@Size(max = 2)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darrerAlbara;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darreraFactura;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darrerPressupost;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darreraFacturaProforma;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darrerAlbaraProforma;
	
	
 	@NotNull 
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darreraFacturaAnyAnterior;
 	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean traspassarAComptabilitat;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean combinarCompteVendaAmbClient;
	
	@Size(max = 2)	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String tipusAssentamentContable;
	
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContable;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteVendes;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteVendesEntitatsPubliques;
	
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableProformes;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteVendesProformaEntPub;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String comptePressupost;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteEntPubPressupost;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteProformaPressupost;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteProformaEntPubPressupost;
	
	@Size(max = 500)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String facturaTitol;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<PeuDocument, PeuDocumentPk> condicioPagamentPressupost;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<PeuDocument, PeuDocumentPk> peuDocument;
	
 	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteVendesProforma;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private Date validDesde;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private Date validFins;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresaOp;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Departament, DepartamentPk> departament;
	
	@Size(max = 20)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String ncf;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean numeracioManual;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean aplicarDescompte;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private SerieFacturaRectificativaEnumDto facturaRectificativa;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private boolean desglossarIva;

	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SerieVendaPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public SerieVendaPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
