/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.fact.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.fact.logic.api.dto.Avaria.AvariaPk;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.logic.api.dto.Taller.TallerPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una avaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcioAvaria"
)
@PrimaryKeyNotExists(fields = {"empresa"}, groups = { OnCreate.class })
public class Avaria extends AbstractIdentificableWithIdentificador<AvariaPk> {

	@NotNull
	@Digits(integer = 10, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal num;	
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInLov = true, includeInQuickFilter = true)
	private String descripcioAvaria;
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInLov = true, includeInQuickFilter = true)
	private String descripcioTrab;
	
	@Size(max = 20)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String numSerie;
	
	@Size(max = 250)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String situacio;
	
	@Size(max = 20)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String matricula;
	
	@Size(max = 15)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String maquinaCodi;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String marca;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String model;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String referencia;
	
	@Digits(integer = 8, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal quilometres;	
	
	@Digits(integer = 3, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal hores;	
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String garantia;
	
	@Digits(integer = 1, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal repararAnomalia;	
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaFin;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaRecollida;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String confCliente;
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String observacions;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaCreacio;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String persEntrega;
	
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String nom;
	
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String persComunica;
	
	@Size(max = 20)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String numParte;
	
	@Size(max = 15)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String numVale;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ubicacioIni;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ubicacioTrab;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String ubicacioFin;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaAviso;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String domicili;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String telefon;
	
	@Digits(integer = 0, fraction = 127)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal visita;	
	
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 12)
	private BigDecimal nif;	
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String estat;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date dataEntrada;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date dataTancament;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String pendentRecollir;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String telefon002;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String eml;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaSolent;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaRectal;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String pagaCta;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String represCli;
	
	// Referencia con la clase Aviso, por hacer
	@Digits(integer = 10, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal aviVadCodi;
	
	@Digits(integer = 19, fraction = 16)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal latitud;
	
	@Digits(integer = 19, fraction = 16)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal longitud;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String fin;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String pen;
	
	@Digits(integer = 2, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal ordre;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaPrt;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaPrtIni;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private Date diaPrtFin;
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String obserOperari;
	
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String con;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String pda;
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String maquina;
	
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String descripcioMaquina;
	
	@Size(max = 2000)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String observacioPrn;
	
	@Digits(integer = 18, fraction = 2)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal impMat;
	
	@Digits(integer = 18, fraction = 2)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal impMao;
	
	@Digits(integer = 18, fraction = 2)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal impDesp;
	
	@Digits(integer = 18, fraction = 2)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal impTot;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String conCrg;
	
	@Size(max = 50)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String guid;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String cobDpl;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String cobMo;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String cobCon;
	
	// Referencia con la clase FullObra, por hacer
	@Digits(integer = 10, fraction = 0)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal fullObraNum;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String tip;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true,
			hiddenInForm = true)	
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Taller, TallerPk> taller;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Pressupost, PressupostPk> pressupost;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<SubClient, SubClientPk> subClient;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> Client;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operari;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Projecte, ProjectePk> projecte;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Albara, AlbaraPk> albara;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<MantenimentDeTipus, WithIdentificadorAndCodiPk<String>> mantenimentDeTipus;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<ClientAdresa, ClientAdresaPk> clientAdresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagamentCobrament;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			hiddenInForm = false,
			disabledForUpdate = false,
			disabledForCreate = false,
			includeInQuickFilter = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class AvariaPk extends WithIdentificadorPk {
		private String empresaCodi;
		private BigDecimal num;
		public AvariaPk(
				String identificadorCodi,
				String empresaCodi,
				BigDecimal num) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.num = num;
		}
	}

}
