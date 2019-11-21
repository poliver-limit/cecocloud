/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una llicència.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(descriptionField = "nomCompanyia")
public class Llicencia {

	private String codi;
	private String nomCompanyia;
	private String emailCompanyia;
	private String telefonCompanyia;
	private Integer nombreMaxEmpreses;
	private Integer nombreMaxUsuaris;
	private boolean caduca;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataCaducitat;
	private List <String> modulsDisponibles;
	@RestapiField(hiddenInGrid=true,
			hiddenInLov=true,
			hiddenInForm=true)
	private String defaultIdentifier;

}
