/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient.DepartamentClientPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un departament-client
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class DepartamentClient extends AbstractIdentificableWithIdentificador<DepartamentClientPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true,includeInQuickFilter = true)
	private String codi;	
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String domicili;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String telefon1;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String telefon2;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String fax1;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String fax2;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String email;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String adressaWeb;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 60)
	private String responsable;	
		
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 1000)
	private String observacions;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 50)
	private String cif;	
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 50)
	private String activitat;		
	
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true)
	@Size(max = 1)
	private String bloquejat;
	
	@Transient	
	@RestapiField(
			hiddenInGrid = false,
			hiddenInForm = false,
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false
			)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "poblacioMunicipiCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					}
			)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<SubClient, SubClientPk> subClient;	


	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class DepartamentClientPk extends WithIdentificadorAndCodiPk<String> {
		private String clientCodi;
		public DepartamentClientPk(
				String identificadorCodi,
				String clientCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.clientCodi = clientCodi;
		}
	}

}
