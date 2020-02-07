/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource
public class FuncionalitatRecurs extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV)
	private GenericReference<Funcionalitat, Long> funcionalitat;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV)
	private GenericReference<Recurs, Long> recurs;
	private boolean principal;

}
