/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari.OperariPk;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.OperariEnumDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class Operari extends AbstractIdentificableWithCompositePk<OperariPk> {
	
	private String codi;
	
	private String nom;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean actiu;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean entsor;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean comercial;
	
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)
	private String horariCodi;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV, 			
			hiddenInGrid = true)
	private Horari horari;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean mostrTurno;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String pin;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean enc;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean incidencia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean horesp;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean aplicaDiesLab;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDilluns;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDimarts;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDimecres;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDijous;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDivendres;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDissabte;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean laboralDiumenge;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean nonGrato; 
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Integer ptenmn;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean ado;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM)
	private OperariEnumDto controlPartes;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM)
	private OperariEnumDto controlHoresExtras;
	
	@Size(max = 30)
	private String usuariCodi;

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
	public static class OperariPk implements Serializable {
		private String identificadorCodi;		
		private String codi;
	}

}
