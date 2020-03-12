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
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de ClientAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "domicili"
)

public class ClientAdresa extends AbstractIdentificableWithIdentificador<ClientAdresaPk> {

	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String domicili;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 10)
	private String direccionExclusivaEnvio;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@NotNull
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 1)
	private String domiciliDefecte;
	   
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 60)
	private String telefon;
	           
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 60)
	private String fax;
	               
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 60)
	private String email;
	             
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 60)
	private String contacte;
	          
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 1000)
	private String observacions;
	      
	@NotNull
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 1)
	private String bloquejada;
	        
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 60)
	private String telefonMovil;
	      
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 50)
	private String cif;
	               
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 50)
	private String activitat;
	         
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
	@Size(max = 50)
	private String adressaWeb;
	        
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
//	@Size(max = 10)
	private Float latitut;
	           
	@RestapiField(
		includeInQuickFilter = true,
		hiddenInGrid = true
	)
//	@Size(max = 10)
	private Float longitut;
		          

	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<SubClient, SubClientPk> subClient;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ClientAdresaPk extends WithIdentificadorAndCodiPk<String> {
		private String clientCodi;
		public ClientAdresaPk(
				String identificadorCodi,
				String clientCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.clientCodi = clientCodi;
		}
	}
	
	
}
