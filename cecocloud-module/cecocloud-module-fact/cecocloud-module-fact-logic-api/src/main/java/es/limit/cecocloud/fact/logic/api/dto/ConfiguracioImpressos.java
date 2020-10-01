/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import lombok.Getter;
import lombok.Setter;

/**
 * Information about configuracio d'impressos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 *
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
		)
public class ConfiguracioImpressos extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull
	@Size(max = 22)
	@Digits(integer = 10, fraction = 0)
	@RestapiField( 
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)
	private String codi;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(
			includeInQuickFilter = true)
	private String tipo;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true)
	private String cls;
	
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String subtipo;
	
}