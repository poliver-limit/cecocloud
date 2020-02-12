/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio")
public class Identificador extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 4)
	@RestapiField(
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private int numUsuaris;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private int numEmpreses;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private int numOperaris;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataInici;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFi;
	@Size(max = 4000)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String llicencia;
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private boolean llicenciaOk;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReference<Usuari, Long> propietari;

	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private int usuarisCount;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private int empresesCount;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private int operarisCount;

}
