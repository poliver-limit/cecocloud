/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(descriptionField = "nom")
public class Document extends AbstractIdentificable<Long> {

	@Size(max = 5)
	private String codi;
	@Size(max = 200)
	private String nom;
	@NotNull
	private DocumentTipus tipus;
	@NotNull
	@Size(max = 200)
	private String uri;
	@NotNull
	@Size(max = 30)
	private String hash;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = false)
	private GenericReference<Licitacio, Long> licitacio;

	public enum DocumentTipus {
		TECNIC,
		ADMINISTRATIU,
		ADDICIONAL
	}

}
