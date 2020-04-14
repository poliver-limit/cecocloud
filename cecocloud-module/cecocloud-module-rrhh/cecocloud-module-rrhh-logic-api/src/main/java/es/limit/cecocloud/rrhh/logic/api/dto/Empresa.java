/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)

public class Empresa extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull
	@Size(max = 4)
	private String codi;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String domiciliPostal;
	
	@Size(max = 5)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String codiPostal;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String poble;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String telefon;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String email;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String paginaWeb;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String empresaComptabilitatCodi;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String exerciciComptabilitatTraspas;
	
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String dri001;
	
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String dri002;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String compte;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String compteRetencioIrpf;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String compteSS;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String compteEmbargo;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean compteTerminacio = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean compteTerminacioEmbargo = false;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String compteSSEmpresa;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean vacancesDiesNaturals = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean compteTerminacioRetencio = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean compteTerminacioSS = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean generarAsientos = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean traspasCrearComptesComptablesExistir = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean compteTerminacioSSEmpresa = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	protected String compteOrganismesSSEmpresa;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	protected String comptePagoNomina;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean asientoProrrateoPagaExtra = false;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	protected boolean logoImprimir = false;

}
