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
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieCompra.SerieCompraPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una serie compra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class SerieCompra extends AbstractIdentificableAmbIdentificador<SerieCompraPk> {

	@NotNull(groups = { OnCreate.class })
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
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 2)
	private String tipusSeientComptable;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 2)
	private String diariComptable;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 10)
	private String compteComptableCompres;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 2)
	private String diariComptableProformes;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 10)
	private String compteComptableCompresProformes;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	private Date validDesde;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	private Date validFins;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV,			
			hiddenInLov = true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Magatzem, AmbIdentificadorICodiPk<String>> magatzem;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV,			
			hiddenInLov = true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Empresa, AmbIdentificadorICodiPk<String>> empresaOp;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String departament;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, hiddenInLov = true) 
	private boolean desglossarIva;

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Empresa, AmbIdentificadorICodiPk<String>> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SerieCompraPk extends AmbIdentificadorICodiPk<String> {
		private String empresaCodi;
		public SerieCompraPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
