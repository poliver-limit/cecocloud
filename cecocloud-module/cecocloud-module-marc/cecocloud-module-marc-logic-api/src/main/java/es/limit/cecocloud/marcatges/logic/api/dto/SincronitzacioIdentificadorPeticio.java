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
 * Petició de sincronització amb la informació associada a un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioIdentificadorPeticio {

	@NotNull
	@Size(max = 4)
	private String codi;
	@NotNull
	@Size(max = 40)
	private String nom;
	private List<SincronitzacioEmpresa> empreses;
	private List<SincronitzacioOperari> operaris;

}
