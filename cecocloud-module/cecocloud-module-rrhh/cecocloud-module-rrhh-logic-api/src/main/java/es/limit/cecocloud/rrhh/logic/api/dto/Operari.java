/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.converter.OperariConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.OperariEnumDto;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@RestapiResource(descriptionField = "nom")
public class Operari extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;

	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean actiu;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean entsor;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean comercial;

//	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
//	private String horariCodi;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean mostrTurno;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String pin;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean enc;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean incidencia;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean horesp;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean aplicaDiesLab;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDilluns;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDimarts;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDimecres;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDijous;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDivendres;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDissabte;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean laboralDiumenge;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean nonGrato;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer ptenmn;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private boolean ado;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = OperariConverter.class)
	private OperariEnumDto controlPartes;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = OperariConverter.class)
	private OperariEnumDto controlHoresExtras;

	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;
		
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer calculoHorasPartesTrabajo;

	
	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String horasCalculNominas;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String estadoCivil;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String digitsControl;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer numeroFills;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer horesLliuresPerAny;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer horesLliures;

	/*@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horari;*/

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<TipusComissio, WithIdentificadorAndCodiPk<String>> tipusComissio;

	/*@Transient
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Banc, WithIdentificadorAndCodiPk<Integer>> banc;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<OficinaBancaria,  OficinaBancariaPk> oficinaBancariaCcr;
	 
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zona;

	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horariBocadillo;

	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<RecursGrup, WithIdentificadorAndCodiPk<String>> recursGrup;*/

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer oficinaBancaria;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer entitatBancaria;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer horesVacances;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String codiPostalPoblacio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer numeroMatricula;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String codiAlternatiu;

	/*@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Operari, WithIdentificadorAndCodiPk<String>> operari;*/

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String compteComptable;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Float compteCorrent;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Date dataNaixement;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Date dataAltaEmpresa;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String nif;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String numeroSeguretatSocial;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer nmn1;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer nmn2;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDilluns;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDimarts;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDimecres;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDijous;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDivendres;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDisabte;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresExtresDiumenge;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer importHoresNormals;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdls;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdms;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdcs;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdjs;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdvs;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdse;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer prunitdme;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer complementSalarial1;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer complementSalarial2;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer costeAdicional;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String poblacio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String provincia;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String nomDelPare;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String nomDeLaMare;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String llocNaixement;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String email;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String telefon;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String domicili;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String observacions;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Date datvaltrg;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean operariPrejubilat;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Date dataPrejubilacio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer horesAnualsPrejubilacio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer horesPendentsAnysAnteriorJubilacio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String observacionsPrejubilacio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean plusProductivitat;

	/*@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<MantenimentDeTipus, WithIdentificadorAndCodiPk<String>> mantenimentDeTipus;*/

	/*@Transient
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Torn, WithIdentificadorAndCodiPk<String>> torn;*/

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Date dataIniciTorn;

	/*@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<GrupFestiu, WithIdentificadorAndCodiPk<String>> grupFestiu;*/

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String sexe;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String telefonEmpresa;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String targetesProfessionalsContruccio;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer percentatgeMinusvalia;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String tgtcod;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean horesRuta;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean dietes;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String ibnpai;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String ibndcc;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String ibnbic;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String discos;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String anecmp;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String depcmp;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean depcmpfxe;

	/*@Transient
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Centre, WithIdentificadorAndCodiPk<String>> centre;*/

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer dtehor;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer maxhoe001;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private Integer ptenmn002;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String emailEmpresa;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean costIndirecte;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String pas;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean app;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String ali;

	/*@Transient
	@RestapiField(type = RestapiFieldType.LOV, disabledForCreate = false, disabledForUpdate = false)
	private GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horariCod003;*/

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean mdcntf;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean nothorext;

	@RestapiField(hiddenInGrid = true, hiddenInForm = false)
	private String usucld;

}
