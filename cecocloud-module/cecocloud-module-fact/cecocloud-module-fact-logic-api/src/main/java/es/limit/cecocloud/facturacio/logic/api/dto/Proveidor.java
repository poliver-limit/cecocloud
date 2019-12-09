/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.Proveidor.ProveidorPk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un proveidor
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nomComercial"
)
public class Proveidor extends AbstractIdentificableWithCompositePk<ProveidorPk> {

	@Size(max = 6)
	@RestapiField(disabledForUpdate = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 40)
	private String nomComercial;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 40)
	private String nomFiscal;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private boolean bloquetjat;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private boolean subcontratista;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private boolean dhm;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<RegimIva, String> regimIva;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<CodiPostal, String> codiPostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<TipusVenciment, String> tipusVenciment;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<Divisa, String> divisa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<DocumentPagamentCobrament, String> documentPagamentCobrament;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<FamiliaProveidor, String> familiaProveidor;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class ProveidorPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
