/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa.EmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Empresa extends AbstractIdentificableWithCompositePk<EmpresaPk> {
	
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
	protected boolean compteTerminacio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean compteTerminacioEmbargo;
	
	@Size(max = 10)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected String compteSSEmpresa;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean vacancesDiesNaturals;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean compteTerminacioRetencio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean compteTerminacioSS;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean generarAsientos;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean traspasCrearComptesComptablesExistir;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean compteTerminacioSSEmpresa;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 10)
	protected String compteOrganismesSSEmpresa;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean compteTerminacioOrganismesSSEmpresa;
	
	@Size(max = 10)
	protected String comptePagoNomina;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean asientoProrrateoPagaExtra;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	protected boolean logoImprimir;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class EmpresaPk implements Serializable {
		private String identificadorCodi;		
		private String codi;
	}

}
