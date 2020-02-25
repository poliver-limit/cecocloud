/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.Empresa;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(descriptionField = "nom")
public class Licitacio extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 200)
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	private String codi;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 250)
	private String uri;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 200)
	private String url;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Size(max = 2000)
	private String projecteTitol;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Size(max = 200)
	private String unitatNom;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@Size(max = 200)
	private String projecteProvinciaDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Digits(integer = 15, fraction = 2)
	private BigDecimal projecteImportSenseTaxes;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Digits(integer = 15, fraction = 2)
	private BigDecimal projecteImportTotal;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataActualitzacio;
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataLimit;	
	@RestapiField(hiddenInLov = true)
	private boolean destacada;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 500)
	private String resum;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 100)
	private String expedientId;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Size(max = 3)
	private String expedientEstat;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 100)
	private String expedientEstatDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 2)
	private String unitatTipus;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 100)
	private String unitatTipusDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 9)
	private String unitatDir3Codi;		
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 4)
	private String projecteTipus;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 2000)
	private String projecteTipusDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 4)
	private String projecteSubTipus;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 1000)
	private String projecteSubTipusDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 3)
	private String projecteMoneda;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 2)
	private String projectePaisCodi;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 200)
	private String projectePaisDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 5)
	private String projecteProvinciaCodi;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Digits(integer = 10, fraction = 0)
	private Integer projecteTerminiExecucioNum;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 3)
	private String projecteTerminiExecucioUnitat;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 2)
	private String procedimentTipus;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true)
	@NotNull
	@Size(max = 1000)
	private String procedimentTipusDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@NotNull
	@Size(max = 2)
	private String urgenciaTipus;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true,hiddenInGrid = true)
	@NotNull
	@Size(max = 100)
	private String urgenciaTipusDescripcio;	
	@RestapiField(disabledForCreate = true, disabledForUpdate = true, hiddenInGrid = true)
	@Size(max = 2000)
	private String nota;	
	@RestapiField(hiddenInLov = true, disabledForUpdate = true, hiddenInGrid = true)
	private boolean esborrada;		
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = false,
			hiddenInGrid = true)
	private GenericReference<Empresa, Long> empresa;
}
