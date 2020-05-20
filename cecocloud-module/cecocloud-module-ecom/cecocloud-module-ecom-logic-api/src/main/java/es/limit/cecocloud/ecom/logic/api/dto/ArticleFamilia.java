/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un article familia
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(type = RestapiPermissionConstraintType.ACL_RESOURCE)
		}
)
public class ArticleFamilia extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@RestapiField(disabledForUpdate = true, 
			toUpperCase = true,
			includeInQuickFilter = true)
	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@NotNull
	@Size(max = 30)
	private String descripcio;
	
	@RestapiField(
			hiddenInLov = true,hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean artExportables = false;

}
