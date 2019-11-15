/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom")
public class Empresa extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Identificador, Long> identificador;
	@NotNull
	@Size(max = 4)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 12)
	@RestapiField(includeInQuickFilter = true)
	private String nif;
	@NotNull
	@Size(max = 40)
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInLov = true,
			includeInQuickFilter = true,
			disabledForUpdate = true)
	@Enumerated
	protected TipusEmpresaEnum tipus;
	@RestapiField(hiddenInLov = true)
	private boolean activa;

	@Transient
	@RestapiField(hiddenInForm = true, hiddenInGrid = true)
	private Long companyiaId;

}
