/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.annotations.RestapiField;
import es.limit.cecocloud.logic.api.annotations.RestapiResource;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(descriptionField = "codi")
public class Operari extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	private GenericReference<Usuari, Long> usuari;
	@NotNull
	@Transient
	private GenericReference<Empresa, Long> empresa;
	@NotNull
	@Size(max = 6)
	private String codi;
	@NotNull
	@RestapiField(type = RestapiFieldType.DATE)
	private Date dataInici;
	@RestapiField(type = RestapiFieldType.DATE)
	private Date dataFi;

}
