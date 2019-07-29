/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge per a enviar cap a CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioMarcatge {

	private String empresaIdentificadorCodi;
	private String empresaCodi;
	private String operariCodi;
	private Date data;
	private Date dataCreacio;

}
