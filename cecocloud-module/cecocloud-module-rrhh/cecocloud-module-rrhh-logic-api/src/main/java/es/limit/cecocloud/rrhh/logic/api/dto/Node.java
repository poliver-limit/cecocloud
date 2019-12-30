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
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Node.NodePk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Node.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Node extends AbstractIdentificableWithIdentificador<NodePk> {

	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Integer numero;
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String tipus;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zonaOrigen;
	
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zonaDesti;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Servidor, WithIdentificadorAndCodiPk<String>> servidor;
	
	@Size(max = 10)
	@RestapiField()
	private String tipus1;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class NodePk extends WithIdentificadorPk {
		private Integer numero;
		public NodePk(
				String identificadorCodi,
				Integer numero) {
			super(identificadorCodi);
			this.numero = numero;
		}
	}

}
