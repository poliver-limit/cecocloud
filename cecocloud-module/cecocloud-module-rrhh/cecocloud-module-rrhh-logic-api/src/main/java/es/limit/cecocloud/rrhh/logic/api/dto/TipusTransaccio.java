/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

//import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
//import es.limit.base.boot.logic.api.dto.util.Identificable.OnCreate;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un TipusTransaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)

//public class TipusTransaccio extends AbstractIdentificableAmbIdentificadorICodi<Integer> {
public class TipusTransaccio extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	
//	@Max(Integer.MAX_VALUE)
//	@RestapiField(disabledForUpdate = true, toUpperCase = true)
//	private Integer codi;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@Size(max = 1000)
	@RestapiField()
	private String descripcio;

}
