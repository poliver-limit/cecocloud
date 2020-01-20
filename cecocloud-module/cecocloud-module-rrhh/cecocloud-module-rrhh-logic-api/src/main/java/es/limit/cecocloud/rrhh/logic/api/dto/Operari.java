/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.OperariEnumDto;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Operari extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)	
	private String nom;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean actiu;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean entsor;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean comercial;
	
//	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
//	private String horariCodi;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean mostrTurno;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String pin;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean enc;	
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean incidencia;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean horesp;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean aplicaDiesLab;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDilluns;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDimarts;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDimecres;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDijous;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDivendres;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDissabte;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean laboralDiumenge;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean nonGrato;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer ptenmn;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private boolean ado;	
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private OperariEnumDto controlPartes;	
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private OperariEnumDto controlHoresExtras;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true			
			)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;
	
}
