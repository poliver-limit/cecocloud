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
	
	/*private boolean actiu;
	private boolean entsor;
	private boolean comercial;
	private String horariCodi;
	private boolean mostrTurno;
	private String pin;
	private boolean enc;
	private boolean incidencia;
	private boolean horesp;
	private boolean aplicaDiesLab;
	private boolean laboralDilluns;
	private boolean laboralDimarts;
	private boolean laboralDimecres;
	private boolean laboralDijous;
	private boolean laboralDivendres;
	private boolean laboralDissabte;
	private boolean laboralDiumenge;
	private boolean nonGrato; 
	private Integer ptenmn;
	private boolean ado;
	@Transient
	private OperariEnumDto controlPartes;
	@Transient
	private OperariEnumDto controlHoresExtras;
	private String usuariCodi;*/

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true
//			,hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;



}
