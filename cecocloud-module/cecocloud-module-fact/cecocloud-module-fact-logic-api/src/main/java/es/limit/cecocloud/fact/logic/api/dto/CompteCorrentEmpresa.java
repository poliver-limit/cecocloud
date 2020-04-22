/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.Identificable.OnUpdate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.validation.CCEmpresaNotExists;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa.CompteCorrentEmpresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un compte corrent empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@CCEmpresaNotExists(field = "empresa", groups = { OnCreate.class, OnUpdate.class })
public class CompteCorrentEmpresa extends AbstractIdentificableWithIdentificador<CompteCorrentEmpresaPk> {

	@Transient
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Transient
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false,
			lovDescriptionField = "nomCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "nomComercial",
							direction = Direction.ASC
							)
					}
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)
	private GenericReferenceWithCompositePk<Banc, WithIdentificadorAndCodiPk<Integer>> banc;
	
	@Transient
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false)
	private GenericReferenceWithCompositePk<OficinaBancaria, OficinaBancariaPk> oficinaBancaria;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			includeInQuickFilter = true)	
	private Integer numeroCompteCorrent;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			includeInQuickFilter = true)
	@Size(max = 2)
	private String digitControl;	
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 1000)
	private String observacions;
	
	@RestapiField(
			hiddenInGrid = false,
			includeInQuickFilter = true
	)
	@Size(max = 2)
	private String paisIban;
	
	@RestapiField(
			hiddenInGrid = false,
			includeInQuickFilter = true
	)
	@Size(max = 2)
	private String digitControlIban;
	
	@RestapiField(
			hiddenInGrid = false,
			includeInQuickFilter = true
	)
	@Size(max = 11)
	private String codiIdentificadorBanc;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class CompteCorrentEmpresaPk extends WithIdentificadorPk {
		private String clientCodi;
		private String empresaCodi;
		private Integer bancCodi;
		private Integer oficinaBancariaCodi;
		private Integer numeroCompteCorrent;
		private String digitControl;
		public CompteCorrentEmpresaPk(
				String identificadorCodi,
				Integer bancCodi,
				String clientCodi,
				String empresaCodi,				
				Integer oficinaBancariaCodi,
				Integer numeroCompteCorrent,
				String digitControl) {
			super(identificadorCodi);
			this.clientCodi = clientCodi;
			this.empresaCodi = empresaCodi;
			this.bancCodi = bancCodi;
			this.oficinaBancariaCodi = oficinaBancariaCodi;
			this.numeroCompteCorrent = numeroCompteCorrent;
			this.digitControl = digitControl;
		}
	}

}
