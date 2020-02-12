/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.dto;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Objecte de transferència que representa un avís d'una licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Avis extends AbstractIdentificable<Long> {

	private String tipus;
	private String tipusDescripcio;
	private String llocPublicacio;
	private Date data;

}
