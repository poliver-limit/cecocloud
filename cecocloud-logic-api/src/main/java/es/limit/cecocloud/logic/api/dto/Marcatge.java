/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.cecocloud.logic.api.annotations.RestapiField;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificableChild;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Marcatge extends AbstractIdentificableChild<Long, Long> {

	@NotNull
	@Transient
	private GenericReference<Operari, Long> operari;
	@NotNull
	@RestapiField(type = RestapiFieldType.DATETIME)
	private Date data;

}
