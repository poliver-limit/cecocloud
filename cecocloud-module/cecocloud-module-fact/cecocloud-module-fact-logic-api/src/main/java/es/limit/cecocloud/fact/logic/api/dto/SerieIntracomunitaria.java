/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una serie intracomunitaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class SerieIntracomunitaria extends AbstractIdentificableWithIdentificador<SerieIntracomunitariaPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(
		disabledForUpdate = true, 
		toUpperCase = true,
		includeInQuickFilter = true)
	private String codi;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String descSerieNomCodi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 60)
	private String descripcio;
	
	@Digits(integer=2, fraction=3)
	@RestapiField(includeInQuickFilter = true, hiddenInGrid = true, hiddenInLov = true)
	@Digits(integer=4, fraction=3)
	private BigDecimal ultimaFactura;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private Date dia1;
	
	@NotNull
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private Date dia2;
	
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true, hiddenInLov = true) 
	@Convert(converter = StringBooleanConverter.class)
	private Boolean serieDefecto = false;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = true
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SerieIntracomunitariaPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public SerieIntracomunitariaPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
