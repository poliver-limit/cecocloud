/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un albara
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Albara extends AbstractIdentificableWithIdentificador<AlbaraPk> {

	@NotNull(groups = { OnCreate.class })
	/*@Size(max = 4)
	@RestapiField(
		disabledForUpdate = true, 
		toUpperCase = true,
		includeInQuickFilter = true)
	private String codi;*/
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Integer numeroDocument;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Integer numero;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true)
	private String classe;	

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true)
	private String serCodfac;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Date data;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true)
	private String formaPago;
	
	@NotNull	
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean facturable = false;
	
	@NotNull
	@Size(max = 1)
	@RestapiField(hiddenInGrid = true)
	private String desti;	

	@RestapiField(hiddenInGrid = true)
	private BigDecimal divisaValorEuros;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Integer facturaNumero;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private String facturaClasse;
	
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
	public static class AlbaraPk extends WithIdentificadorAndCodiPk<Integer> {
		private String empresaCodi;
		public AlbaraPk(
				String identificadorCodi,
				String empresaCodi,
				Integer codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
