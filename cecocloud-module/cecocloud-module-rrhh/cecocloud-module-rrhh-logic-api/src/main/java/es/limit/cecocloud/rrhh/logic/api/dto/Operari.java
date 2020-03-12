/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.converter.OperariConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.OperariEnumDto;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Operari extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)	
	private String nom;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean actiu;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean entsor;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean comercial;
	
//	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
//	private String horariCodi;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean mostrTurno;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String pin;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean enc;	
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean incidencia;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean horesp;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean aplicaDiesLab;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDilluns;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDimarts;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDimecres;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDijous;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDivendres;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDissabte;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDiumenge;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean nonGrato;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer ptenmn;
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean ado;	
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = OperariConverter.class)
	private OperariEnumDto controlPartes;	
	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = OperariConverter.class)
	private OperariEnumDto controlHoresExtras;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false			
			)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;
	
}
