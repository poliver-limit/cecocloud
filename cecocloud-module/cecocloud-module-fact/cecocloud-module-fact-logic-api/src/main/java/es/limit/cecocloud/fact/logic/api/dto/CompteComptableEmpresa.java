/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa.CompteComptableEmpresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un compte comptable empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class CompteComptableEmpresa extends AbstractIdentificableWithIdentificador<CompteComptableEmpresaPk> {

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
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;	
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 10)
	private String compteComptable;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 10)
	private String compteVendes;	

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class CompteComptableEmpresaPk extends WithIdentificadorPk {
		private String clientCodi;
		private String empresaCodi;	
		public CompteComptableEmpresaPk(
				String identificadorCodi,			
				String clientCodi,
				String empresaCodi) {
			super(identificadorCodi);
			this.clientCodi = clientCodi;
			this.empresaCodi = empresaCodi;		
		}
	}

}
