/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una llicència.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
@RestapiResource(descriptionField = "descripcio")
public class Llicencia {

	@JsonProperty("c")
	private String codi;
	@JsonProperty("d")
	private String descripcio;
	@JsonProperty("e")
	private Integer nombreMaxEmpreses;
	@JsonProperty("u")
	private Integer nombreMaxUsuaris;
	@JsonProperty("i")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataInici;
	@JsonProperty("f")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataFi;
	@JsonProperty("m")
	private List <String> modulsDisponibles;
	@JsonProperty("a")
	private List <String> caracteristiques;

}
