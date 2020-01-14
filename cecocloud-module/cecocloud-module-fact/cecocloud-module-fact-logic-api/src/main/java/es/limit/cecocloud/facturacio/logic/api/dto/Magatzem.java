/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.ValoracioInventariTraspasEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Magatzem extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(hiddenInLov = true)
	private String domicili;
	@NotNull
	@RestapiField(hiddenInLov = true)
	private ValoracioInventariTraspasEnum valoracioInventariTraspas;
	
	@Size(max = 60)
	@RestapiField(hiddenInLov = true)
	private String telefon;
	
	@Size(max = 60)
	@RestapiField(hiddenInLov = true)
	private String fax;
	
	@Size(max = 60)
	@javax.validation.constraints.Email
	@RestapiField(hiddenInLov = true)
	private String email;
	
	@Size(max = 30)
	@RestapiField(hiddenInLov = true)
	private String responsable;
	
	@Size(max = 1000)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true, type = RestapiFieldType.TEXTAREA)
	private String observacions;
	
	@Size(max = 2)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private String tipusAssentamentComptable;
	
	@Size(max = 2)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private String diariComptableTraspassos1;
	
	@Size(max = 2)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private String diariComptableTraspassos2;
	
	@Size(max = 10)
	@RestapiField(hiddenInLov = true, hiddenInGrid = true)
	private String compteTraspassos;
	
//	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true, hiddenInLov = true)
//	private String periodeActualCodi;
//	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true, hiddenInLov = true)
//	private String periodeActualData;
	
	@Transient
	@Formula(value="( SELECT r.pmg_cod FROM tges_pmg r WHERE r.pmg_diaini = (SELECT MAX(r2.pmg_diaini) FROM tges_pmg r2 ))")
	private String periodeActualCodi;
	
	@Transient
	@Formula(value="( SELECT r.pmg_diaini FROM tges_pmg r WHERE r.pmg_diaini = (SELECT MAX(r2.pmg_diaini) FROM tges_pmg r2 ))")
	private String periodeActualData;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;

}
