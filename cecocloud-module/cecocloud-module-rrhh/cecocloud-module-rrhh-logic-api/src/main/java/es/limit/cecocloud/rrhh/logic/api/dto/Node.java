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

//import es.limit.base.boot.logic.api.dto.util.Identificable.OnCreate;
//import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;
//import es.limit.cecocloud.rrhh.logic.api.dto.Node.NodePk;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;

import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Node.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
//public class Node extends AbstractIdentificableAmbIdentificador<NodePk> {
public class Node extends AbstractIdentificableWithIdentificadorAndCodi<String> {


//	@RestapiField(disabledForUpdate = true, toUpperCase = true)
//	private Integer numero;	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true, hiddenInGrid = true)
	private String tipus;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV)	
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zonaOrigen;
	
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV)	
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zonaDesti;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV)	
	private GenericReferenceWithCompositePk<Servidor, WithIdentificadorAndCodiPk<String>> servidor;
	
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true)
	private String tipus1;

//	@NoArgsConstructor
//	@AllArgsConstructor
//	@EqualsAndHashCode(callSuper = true)
//	@Getter
//	@SuppressWarnings("serial")
//	public static class NodePk extends AmbIdentificadorPk {
//		private Integer numero;
//		public NodePk(
//				String identificadorCodi,
//				Integer numero) {
//			super(identificadorCodi);
//			this.numero = numero;
//		}
//	}


}
