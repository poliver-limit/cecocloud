/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
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
	@Size(max = 4)
	@RestapiField(
		disabledForUpdate = true, 
		toUpperCase = true,
		includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private int numeroDocument;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private int numero;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private String classe;	

	@RestapiField(hiddenInGrid = true)
	private String serCodfac;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Date data;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private String formaPago;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private boolean facturable;
	
	@NotNull
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
	public static class AlbaraPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public AlbaraPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
