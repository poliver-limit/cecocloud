/**
 * 
 */
package es.limit.cecocloud.logic.api.generic.dto;

import java.io.Serializable;

import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.generic.dto.CompositePkAmbIdentificador.AmbIdentificadorPk;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementació per defecte de la interfície CompositePK amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractCompositePkAmbIdentificador <ID extends Serializable> extends AbstractIdentificableWithCompositePk<AmbIdentificadorPk> implements CompositePkAmbIdentificador<AmbIdentificadorPk> {

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,			
			hiddenInForm = true)
	private GenericReference<Identificador, Long> identificador;
	
}
