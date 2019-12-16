/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.rrhh.logic.api.dto.OperariRrhh.OperariRrhhPk;
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
public class OperariRrhh extends AbstractIdentificableWithCompositePk<OperariRrhhPk> {

	private String codi;
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
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<IdentificadorRrhh, String> identificador;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Horari, String> horari;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class OperariRrhhPk implements Serializable {
		private String identificadorCodi;		
		private String codi;
	}

}
