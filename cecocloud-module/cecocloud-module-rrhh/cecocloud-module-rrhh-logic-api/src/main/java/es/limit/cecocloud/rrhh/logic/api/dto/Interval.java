/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Interval
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)

public class Interval extends AbstractIdentificableWithIdentificadorAndCodi<String> {
	
	@Digits(integer = 22, fraction = 0)
	@NotNull
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Date dataEntrada;
	
	@RestapiField(hiddenInGrid = false, hiddenInLov = true)
	private Date dataInici;
	
	@Max(22)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Integer numeroNodeEnt;
	
	@Max(22)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Integer numeroNodeSor;
	
	@RestapiField(hiddenInGrid = false, hiddenInLov = true)
	private Date dataFi;
	
	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String observacio;
	
	@Size(max = 4)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String concepteFeinaCodi;
	
	@Size(max = 4)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Integer fullFeinaOperariCodi;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true
			)	
	private GenericReferenceWithCompositePk<Calendari, CalendariPk> diaCalendari;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,			
			disabledForUpdate = true			
			)
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zona;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,			
			disabledForUpdate = true			
			)
	private GenericReferenceWithCompositePk<Operari, WithIdentificadorAndCodiPk<String>> operari;

}
