/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio.TransaccioPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una Transaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Transaccio extends AbstractIdentificableWithCompositePk<TransaccioPk> {
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Integer codi;
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Date dataHora;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReference<OperariRrhh, String> operari;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReference<TipusTransaccio, String> tipusTransaccio;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReference<EmpresaRrhh, String> empresa;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
	private GenericReference<Node, String> node;
	
	@Size(max = 1000)
	@RestapiField()
	private String observacions;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<IdentificadorRrhh, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class TransaccioPk implements Serializable {
		private String identificadorCodi;		
		private String codi;
	}

}
