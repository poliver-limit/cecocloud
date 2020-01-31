/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.marc.logic.api.dto.CompositePkTest.CompositePkTestPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi")
public class CompositePkTest extends AbstractIdentificableWithCompositePk<CompositePkTestPk> {

	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private GenericReference<Empresa, Long> empresa;
	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private GenericReference<Usuari, Long> usuari;
	@Size(max = 16)
	@RestapiField(includeInQuickFilter = true)
	private String codi;
	@Size(max = 100)
	@RestapiField(includeInQuickFilter = true)
	private String descripcio;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class CompositePkTestPk implements Serializable {
		private Long empresaId;
		private Long usuariId;
		private String codi;
	}

}
