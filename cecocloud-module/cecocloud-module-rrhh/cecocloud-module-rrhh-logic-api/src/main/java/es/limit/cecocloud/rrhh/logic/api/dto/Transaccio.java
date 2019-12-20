/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.util.Date;

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
 * DTO amb informació d'una Transaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Transaccio extends AbstractIdentificableAmbIdentificadorICodi<Integer> {
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Integer codi;
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Date dataHora;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
//	private GenericReference<Operari, String> operari;
	private GenericReferenceWithCompositePk<Operari> operari;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
//	private GenericReference<TipusTransaccio, String> tipusTransaccio;
	private GenericReferenceWithCompositePk<TipusTransaccio> tipusTransaccio;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
//	private GenericReference<Empresa, String> empresa;
	private GenericReferenceWithCompositePk<Empresa> empresa;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)	
//	private GenericReference<Node, String> node;
	private GenericReferenceWithCompositePk<Node> node;
	
	@Size(max = 1000)
	@RestapiField()
	private String observacions;

}
