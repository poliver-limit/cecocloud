/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusRisc.TipusRiscPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una tipus de risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class TipusRisc extends AbstractIdentificableWithCompositePk<TipusRiscPk> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_pensrv;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_albnotfac;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_vtopennotvnt;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_vtopenvnt;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_efeneg;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean tri_nifigu;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class TipusRiscPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
