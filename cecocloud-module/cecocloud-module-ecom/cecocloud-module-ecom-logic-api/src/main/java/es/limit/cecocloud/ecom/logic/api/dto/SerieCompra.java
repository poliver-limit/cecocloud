/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una serie compra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = {"codi","empresa"}, groups = { OnCreate.class })
public class SerieCompra extends AbstractIdentificableWithIdentificador<SerieCompraPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(
			disabledForUpdate = true, 
		toUpperCase = true,
		includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 2)
	private String tipusSeientComptable;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 2)
	private String diariComptable;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 10)
	private String compteComptableCompres;
	
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 2)
	private String diariComptableProformes;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Size(max = 10)
	private String compteComptableCompresProformes;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private Date validDesde;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private Date validFins;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV,			
			hiddenInLov = true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV,			
			hiddenInLov = true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresaOp;
	
	/*@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String departament;*/
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, hiddenInLov = true) 
	@Convert(converter = StringBooleanConverter.class)
	private Boolean desglossarIva = false;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;


	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class SerieCompraPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public SerieCompraPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
