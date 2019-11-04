/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar una empresa de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioEmpresaAmbOperaris extends SincronitzacioEmpresa {

	private List<SincronitzacioOperari> operaris;

}
