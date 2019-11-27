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
import es.limit.cecocloud.facturacio.logic.api.dto.Transportista.TransportistaPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un transportista.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Transportista extends AbstractIdentificableWithCompositePk<TransportistaPk> {

	@Size(max = 6)
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;
	@NotNull
	@RestapiField(hiddenInGrid = true,
	hiddenInLov=true)
	@Size(max = 12)
	private String nif;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String domicili;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	@Size(max = 60)
	private String telefon;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String fax;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String email;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String adresaWeb;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String contacte;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String formaPagament;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String horariRepartiment;
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean vehicleEmpresa;

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
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
			includeInQuickFilter = true)
	private CodiPostal codiPostal;
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	private Divisa divisa;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	private Proveidor proveidor;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class TransportistaPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
