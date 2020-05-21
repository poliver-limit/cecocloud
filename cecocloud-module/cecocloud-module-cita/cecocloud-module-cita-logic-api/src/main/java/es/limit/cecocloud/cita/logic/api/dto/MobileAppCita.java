/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una cita per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppCita {

	private String codi;
	@NotNull
	private LocalDateTime data;
	@NotNull
	@NotEmpty
	private String nom;
	@NotNull
	@NotEmpty
	private String llinatges;
	@NotNull
	@NotEmpty
	private String telefon;
	private String email;
	private MobileAppEmpresa empresa;
	private MobileAppPuntVenda puntVenda;

}
