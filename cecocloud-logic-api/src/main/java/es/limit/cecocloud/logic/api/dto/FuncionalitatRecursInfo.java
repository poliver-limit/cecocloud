/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'un recurs (permisos per rol).
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionalitatRecursInfo {

	private String resourceClassName;
	private boolean principal;
	private String permis;
}
