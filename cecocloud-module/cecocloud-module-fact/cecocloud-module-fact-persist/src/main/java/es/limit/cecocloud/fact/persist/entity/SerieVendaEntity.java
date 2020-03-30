/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.SerieVenda;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una serie venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ser",
		indexes = {
				@Index(name = "iges_ser_idf_fk", columnList = "ser_idf_cod"),
				@Index(name = "irges_ser_pk", columnList = "ser_idf_cod,ser_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ser_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ser_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ser_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ser_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ser_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.darrerAlbara", column = @Column(name = "ser_ultalb", nullable = false)),
	@AttributeOverride(name = "embedded.darreraFactura", column = @Column(name = "ser_ultfac", nullable = false)),
	@AttributeOverride(name = "embedded.darrerPressupost", column = @Column(name = "ser_ultpre", nullable = false)),
	@AttributeOverride(name = "embedded.darreraFacturaProforma", column = @Column(name = "ser_ultpreprf", nullable = false)),
	@AttributeOverride(name = "embedded.darrerAlbaraProforma", column = @Column(name = "ser_ultalbprf", nullable = false)),
	@AttributeOverride(name = "embedded.darreraFacturaAnyAnterior", column = @Column(name = "ser_ultfacprf", nullable = false)),
	@AttributeOverride(name = "embedded.traspassarAComptabilitat", column = @Column(name = "ser_trscmp", length = 1)),
	@AttributeOverride(name = "embedded.combinarCompteVendaAmbClient", column = @Column(name = "ser_cnrvencli", length = 1)),
	@AttributeOverride(name = "embedded.tipusAssentamentContable", column = @Column(name = "ser_tipasicmp", length = 2)),
	@AttributeOverride(name = "embedded.diariContable", column = @Column(name = "ser_dricmp", length = 2)),
	@AttributeOverride(name = "embedded.compteVendes", column = @Column(name = "ser_ctevencmp", length = 10)),
	@AttributeOverride(name = "embedded.compteVendesEntitatsPubliques", column = @Column(name = "ser_ctevenettpubcmp", length = 10)),
	@AttributeOverride(name = "embedded.diariContableProformes", column = @Column(name = "ser_driprfcmp", length = 2)),
	@AttributeOverride(name = "embedded.compteVendesProformaEntPub", column = @Column(name = "ser_ctevenettpubprfcmp", length = 10)),
	@AttributeOverride(name = "embedded.comptePressupost", column = @Column(name = "ser_ctepre", length = 10)),
	@AttributeOverride(name = "embedded.compteEntPubPressupost", column = @Column(name = "ser_cteadmpre", length = 10)),
	@AttributeOverride(name = "embedded.compteProformaPressupost", column = @Column(name = "ser_cteprfpre", length = 10)),
	@AttributeOverride(name = "embedded.compteProformaEntPubPressupost", column = @Column(name = "ser_cteprfadmpre", length = 10)),
	@AttributeOverride(name = "embedded.facturaTitol", column = @Column(name = "ser_titfac", length = 500)),
//	@AttributeOverride(name = "embedded.condicioPagamentPressupostCodi", column = @Column(name = "ser_ped_cod", length = 4)),
//	@AttributeOverride(name = "embedded.peuDocumentCodi", column = @Column(name = "ser_ped_codfac", length = 4)),
	@AttributeOverride(name = "embedded.compteVendesProforma", column = @Column(name = "ser_ctevenprfcmp", length = 10)),
	@AttributeOverride(name = "embedded.validDesde", column = @Column(name = "ser_dia001", nullable = false)),
	@AttributeOverride(name = "embedded.validFins", column = @Column(name = "ser_dia002", nullable = false)),
//	@AttributeOverride(name = "embedded.magatzemCodi", column = @Column(name = "ser_mag_cod", length = 4)),
//	@AttributeOverride(name = "embedded.empresaOpCodi", column = @Column(name = "ser_emp_codprn", length = 4)),
//	@AttributeOverride(name = "embedded.departamentCodi", column = @Column(name = "ser_dep_cod", length = 4)),
	@AttributeOverride(name = "embedded.ncf", column = @Column(name = "ser_ncf", length = 20)),
	@AttributeOverride(name = "embedded.numeracioManual", column = @Column(name = "ser_man", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.aplicarDescompte", column = @Column(name = "ser_dte", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.facturaRectificativa", column = @Column(name = "ser_facrct", length = 1)),
	@AttributeOverride(name = "embedded.desglossarIva", column = @Column(name = "ser_dsgivacmp", length = 1, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ser_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ser_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ser_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ser_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ser_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_idf_fk"))
})
public class SerieVendaEntity extends AbstractWithIdentificadorAuditableEntity<SerieVenda, SerieVendaPk> {

	@Embedded
	protected SerieVenda embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ser_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ser_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ser_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "ped_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name ="ser_emp_cod", referencedColumnName = "ped_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_ped_cod", referencedColumnName = "ped_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_pedcondicio_fk"))
	protected PeuDocumentEntity condicioPagamentPressupost;	
	@Column(name = "ser_ped_cod", length = 4)
	private String condicioPagamentPressupostCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {					
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "ped_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name ="ser_emp_cod", referencedColumnName = "ped_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_ped_codfac", referencedColumnName = "ped_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_ped_fk"))			
	protected PeuDocumentEntity peuDocument;	
	@Column(name = "ser_ped_codfac", length = 4)
	private String peuDocumentCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_mag_fk"))			
	protected MagatzemEntity magatzem;
	@Column(name = "ser_mag_cod", length = 4)
	private String magatzemCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_emp_codprn", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_empOp_fk"))			
	protected EmpresaEntity empresaOp;	
	@Column(name = "ser_emp_codprn", length = 4)
	private String empresaOpCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "dep_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_emp_cod", referencedColumnName = "dep_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_dep_cod", referencedColumnName = "dep_cod", insertable = false, updatable = false)
			},
					foreignKey = @ForeignKey(name = "rges_ser_dep_fk"))			
	protected DepartamentEntity departament;
	@Column(name = "ser_dep_cod", length = 4)
	private String departamentCodi;
	
	@Builder
	public SerieVendaEntity(
			SerieVendaPk pk,
			SerieVenda embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			DepartamentEntity departament,
			EmpresaEntity empresaOp,
			PeuDocumentEntity condicioPagamentPressupost,
			PeuDocumentEntity peuDocument,
			MagatzemEntity magatzem) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;		
		
		this.updateCondicioPagamentPressupost(condicioPagamentPressupost);		
		this.updatePeuDocument(peuDocument);		
		this.updateMagatzem(magatzem);		
		this.updateEmpresaOp(empresaOp);		
		this.updateDepartament(departament);		
	}

	@Override
	public void update(SerieVenda embedded) {
		this.embedded = embedded;
	}
	
	public void updateCondicioPagamentPressupost (PeuDocumentEntity condicioPagamentPressupost) {
		this.condicioPagamentPressupost = condicioPagamentPressupost;
		if (condicioPagamentPressupost!=null) this.condicioPagamentPressupostCodi = condicioPagamentPressupost.getEmbedded().getCodi();
	}
	
	public void updatePeuDocument (PeuDocumentEntity peuDocument) {
		this.peuDocument = peuDocument;
		if (peuDocument!=null) this.peuDocumentCodi = peuDocument.getEmbedded().getCodi();
	}
	
	public void updateMagatzem (MagatzemEntity magatzem) {
		this.magatzem = magatzem;
		if (magatzem!=null) this.magatzemCodi = magatzem.getEmbedded().getCodi();
	}
	
	public void updateEmpresaOp (EmpresaEntity empresaOp) {
		this.empresaOp = empresaOp;
		if (empresaOp!=null) this.empresaOpCodi = empresaOp.getEmbedded().getCodi();
	}
	
	public void updateDepartament (DepartamentEntity departament) {
		this.departament = departament;
		if (departament!=null) this.departamentCodi = departament.getEmbedded().getCodi();
	}

}
