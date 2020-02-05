/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador.AplicadorPk;
import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient.AplicadorClientPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un aplicador-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class AplicadorClient extends AbstractIdentificableWithIdentificador<AplicadorClientPk> {
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)
	private GenericReferenceWithCompositePk<Aplicador, AplicadorPk> aplicador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class AplicadorClientPk extends WithIdentificadorPk {
		private String clientCodi;
		private String aplicadorContracte;
		public AplicadorClientPk(
				String identificadorCodi,
				String clientCodi,
				String aplicadorContracte) {
			super(identificadorCodi);
			this.clientCodi = clientCodi;
			this.aplicadorContracte = aplicadorContracte;
		}
	}

}
