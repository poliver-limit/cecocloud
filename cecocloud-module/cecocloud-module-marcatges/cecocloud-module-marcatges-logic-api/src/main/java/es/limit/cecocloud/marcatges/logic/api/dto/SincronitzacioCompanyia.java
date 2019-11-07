/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar una companyia de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioCompanyia {

	@NotNull
	@Size(max = 30)
	private String companyiaCodi;
	@NotNull
	private List<SincronitzacioEmpresaAmbOperaris> empreses;

}