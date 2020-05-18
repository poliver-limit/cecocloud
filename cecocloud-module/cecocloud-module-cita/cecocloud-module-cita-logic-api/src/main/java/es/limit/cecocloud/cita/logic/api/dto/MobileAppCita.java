/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalDateTime;

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
	private String nom;
	@NotNull
	private String llinatges;
	@NotNull
	private String telefon;
	private String email;
	private MobileAppEmpresa empresa;
	private MobileAppPuntVenda puntVenda;

}