/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.Empresa;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factEmpresaEntity")
@Table(
		name = "tges_emp",
		indexes = {
				@Index(name = "iges_emp_idf_fk", columnList = "emp_idf_cod"),
				@Index(name = "irges_emp_pk", columnList = "emp_idf_cod,emp_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "emp_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "emp_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "emp_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "emp_nomcom", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.domiciliComercial", column = @Column(name = "emp_domcom", length = 60, nullable = false)),
//	@AttributeOverride(name = "embedded.codiPostalComercialCodi", column = @Column(name = "emp_cpocodcom", length = 8, nullable = false)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "emp_nomfis", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.domiciliFiscal", column = @Column(name = "emp_domfis", length = 60, nullable = false)),
//	@AttributeOverride(name = "embedded.codiPostalFiscalCodi", column = @Column(name = "emp_cpo_codfis", length = 8, nullable = false)),
	@AttributeOverride(name = "embedded.facturacioTipus", column = @Column(name = "emp_tipfac")),
//	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "emp_div_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.recarrecEquivalencia", column = @Column(name = "emp_rec", length = 1)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "emp_tel", length = 60)),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "emp_fax", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "emp_eml", length = 60)),
	@AttributeOverride(name = "embedded.web", column = @Column(name = "emp_www", length = 60)),
//	@AttributeOverride(name = "embedded.magatzemCodi", column = @Column(name = "emp_mag_cod", length = 4)),
	@AttributeOverride(name = "embedded.comptabilitatClients", column = @Column(name = "emp_clicmp", length = 1)),
	@AttributeOverride(name = "embedded.comptabilitatProveidors", column = @Column(name = "emp_procmp", length = 1)),
	@AttributeOverride(name = "embedded.comptabilitatAssentamentTipus", column = @Column(name = "emp_tipasicmp", length = 2)),
	@AttributeOverride(name = "embedded.diarioFactProveedores", column = @Column(name = "emp_dricmp", length = 2)),
	@AttributeOverride(name = "embedded.diarioProfProveedores", column = @Column(name = "emp_driprfcmp", length = 2)),
	@AttributeOverride(name = "embedded.comptabilitatCodi", column = @Column(name = "emp_codcmp", length = 60)),
	@AttributeOverride(name = "embedded.registreMercantil", column = @Column(name = "emp_rgtmtl", length = 250)),
	@AttributeOverride(name = "embedded.valorFacturacio", column = @Column(name = "emp_valfac")),
	@AttributeOverride(name = "embedded.regimCriteriCaixa", column = @Column(name = "emp_regcricxa", length = 1)),
	@AttributeOverride(name = "embedded.personaTipus", column = @Column(name = "emp_tipper", length = 1)),
	@AttributeOverride(name = "embedded.tipoResidencia", column = @Column(name = "emp_tipext", length = 1)),
	@AttributeOverride(name = "embedded.nomFiscal1", column = @Column(name = "emp_nomfis001", length = 40)),
	@AttributeOverride(name = "embedded.llinatgeFiscal1", column = @Column(name = "emp_llnfis001", length = 40)),
	@AttributeOverride(name = "embedded.llinatgeFiscal2", column = @Column(name = "emp_llnfis002", length = 40)),
	@AttributeOverride(name = "embedded.logoImprimir", column = @Column(name = "emp_prnlog", length = 1)),
	@AttributeOverride(name = "embedded.logoPath", column = @Column(name = "emp_dirlog", length = 300)),
	@AttributeOverride(name = "embedded.tancamentData", column = @Column(name = "emp_dattan")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "emp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "emp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "emp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "emp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "emp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_emp_idf_fk"))
})
public class EmpresaEntity extends AbstractWithIdentificadorEntity<Empresa, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Empresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "emp_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "emp_cpo_codcom", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_emp_cpo_fk"))
	private CodiPostalEntity codiPostalComercial;	
	@Column(name = "emp_cpo_codcom", length = 8, nullable = false)
	private String codiPostalComercialCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "emp_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "emp_cpo_codfis", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_emp_cpofis_fk"))
	private CodiPostalEntity codiPostalFiscal;
	@Column(name = "emp_cpo_codfis", length = 8, nullable = false)
	private String codiPostalFiscalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "emp_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "emp_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_emp_div_fk"))
	private DivisaEntity divisa;	
	@Column(name = "emp_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@ManyToOne(optional = true)
	@JoinColumns(
			value = {
					@JoinColumn(name = "emp_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "emp_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
					foreignKey = @ForeignKey(name = "rges_emp_mag_fk"))
	private MagatzemEntity magatzem;
	@Column(name = "emp_mag_cod", length = 4)
	private String magatzemCodi;

	@Builder
	public EmpresaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Empresa embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostalComercial,
			CodiPostalEntity codiPostalFiscal,
			DivisaEntity divisa,
			MagatzemEntity magatzem) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.codiPostalComercial = codiPostalComercial;
		this.codiPostalFiscal = codiPostalFiscal;
		this.divisa = divisa;
		this.magatzem = magatzem;
		
//		this.setEmbeddedCodis();
		this.codiPostalComercialCodi = codiPostalComercial.getEmbedded().getCodi();
		this.codiPostalFiscalCodi = codiPostalFiscal.getEmbedded().getCodi();
		this.divisaCodi = divisa.getEmbedded().getCodi();
		
		if (magatzem != null) {
			this.magatzemCodi = magatzem.getEmbedded().getCodi();
		}
		
	}

	@Override
	public void update(Empresa embedded) {
		this.embedded = embedded;
//		this.setEmbeddedCodis();
	}
	
	public void updateCodiPostalComercial(CodiPostalEntity codiPostalComercial) {
		this.codiPostalComercialCodi = codiPostalComercial.getEmbedded().getCodi();
	}
	
	public void updateCodiPostalFiscal(CodiPostalEntity codiPostalFiscal) {
		this.codiPostalFiscalCodi = codiPostalFiscal.getEmbedded().getCodi();
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisaCodi = divisa.getEmbedded().getCodi();
	}
	
	public void updateMagatzem(MagatzemEntity magatzem) {
		if (magatzem != null) {
			this.magatzemCodi = magatzem.getEmbedded().getCodi();
		}
	}	
	
//	private void setEmbeddedCodis () {		
//			
//		// Referencies sobre camps obligatoris
//		this.codiPostalComercialCodi = embedded.getCodiPostalComercial().getPk().getCodi();
//		this.codiPostalFiscalCodi = embedded.getCodiPostalFiscal().getPk().getCodi();
//		this.divisaCodi = embedded.getDivisa().getPk().getCodi();
//		
//		// Referencies sobre camps no obligastoris		
//		if (embedded.getMagatzem() != null) {
//			this.magatzemCodi = embedded.getMagatzem().getPk().getCodi();
//		}
//		
//	}
	
}
