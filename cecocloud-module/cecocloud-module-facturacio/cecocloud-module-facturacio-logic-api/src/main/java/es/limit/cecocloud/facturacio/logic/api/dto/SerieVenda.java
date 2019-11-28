/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.SerieFacturaRectificativaEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
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
public class SerieVenda extends AbstractIdentificableWithCompositePk<SerieVendaPk> {

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
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer darrerPressupost;
	
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
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)
	private PeuDocument condicioPagamentPressupost;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)
	private PeuDocument peuDocument;
	
 	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String compteVendesProforma;
 	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String facturaDesc;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	private Date validDesde;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	private Date validFins;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)
	private Magatzem magatzem;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)
	private Empresa empresaOp;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
					hiddenInLov = true,
			includeInQuickFilter = true)
	private Departament departament;
	
	@Size(max = 20)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String ncf;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean numeracioManual;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean aplicarDescompte;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private SerieFacturaRectificativaEnumDto facturaRectificativa;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	private boolean desglossarIva;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Empresa, String> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class SerieVendaPk implements Serializable {
		private String identificadorCodi;
		private String empresaCodi;
		private String codi;
	}

}
