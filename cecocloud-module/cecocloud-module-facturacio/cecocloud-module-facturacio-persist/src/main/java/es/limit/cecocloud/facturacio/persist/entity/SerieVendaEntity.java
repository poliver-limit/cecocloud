/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
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
	@AttributeOverride(name = "embedded.condicioPagamentPressupostCodi", column = @Column(name = "ser_ped_cod", length = 4)),			
	@AttributeOverride(name = "embedded.peuDocumentCodi", column = @Column(name = "ser_ped_codfac", length = 4)),			
	@AttributeOverride(name = "embedded.compteVendesProforma", column = @Column(name = "ser_ctevenprfcmp", length = 10)),			
	@AttributeOverride(name = "embedded.validDesde", column = @Column(name = "ser_dia001", nullable = false)),			
	@AttributeOverride(name = "embedded.validFins", column = @Column(name = "ser_dia002", nullable = false)),			
	@AttributeOverride(name = "embedded.magatzemCodi", column = @Column(name = "ser_mag_cod", length = 4)),			
	@AttributeOverride(name = "embedded.empresaOpCodi", column = @Column(name = "ser_emp_codprn", length = 4)),			
	@AttributeOverride(name = "embedded.departamentCodi", column = @Column(name = "ser_dep_cod", length = 4)),			
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
public class SerieVendaEntity extends AbstractAuditableCompositePkEntity<SerieVenda, SerieVendaPk> {

	@Embedded
	protected SerieVenda embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "ser_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_ser_idf_fk"))
	protected IdentificadorEntity identificador;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "ped_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name ="ser_emp_cod", referencedColumnName = "ped_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_ped_cod", referencedColumnName = "ped_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_pedcondicio_fk"))
	protected PeuDocumentEntity condicioPagamentPressupost;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {					
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "ped_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name ="ser_emp_cod", referencedColumnName = "ped_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_ped_codfac", referencedColumnName = "ped_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_ped_fk"))			
	protected PeuDocumentEntity peuDocument;	

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_mag_fk"))			
	protected MagatzemEntity magatzem;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_emp_codprn", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ser_emp_fk"))			
	protected EmpresaFactEntity empresaOp;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ser_idf_cod", referencedColumnName = "dep_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_emp_cod", referencedColumnName = "dep_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ser_dep_cod", referencedColumnName = "dep_cod", insertable = false, updatable = false)
			},
					foreignKey = @ForeignKey(name = "rges_ser_dep_fk"))			
	protected DepartamentEntity departament;
	
	@Builder
	public SerieVendaEntity(
			SerieVendaPk pk,
			SerieVenda embedded,
			IdentificadorEntity identificador,
			PeuDocumentEntity condicioPagamentPressupost,
			PeuDocumentEntity peuDocument,
			MagatzemEntity magatzem,
			EmpresaFactEntity empresaOp,
			DepartamentEntity departament			
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.condicioPagamentPressupost = condicioPagamentPressupost;
		this.peuDocument = peuDocument;
		this.magatzem = magatzem;
		this.empresaOp = empresaOp;
		this.departament = departament;		
	}

	@Override
	public void update(SerieVenda embedded) {
		this.embedded = embedded;
	}

}
