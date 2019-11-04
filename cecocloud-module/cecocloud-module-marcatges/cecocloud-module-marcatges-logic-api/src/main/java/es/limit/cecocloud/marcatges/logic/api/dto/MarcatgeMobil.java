/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Empresa;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge fet amb el mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MarcatgeMobil {

	@NotNull
	private Date data;
	private Date dataCreacio;
	@NotNull
	private GenericReference<Empresa, Long> empresa;
	private Double latitud;
	private Double longitud;

}
