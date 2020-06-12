/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat;
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat.VencimentPagatPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomVencimentPagatEntity")
@Table(
		name = "tcom_vcx",
		indexes = {
				@Index(name = "ircom_vcx_pk", columnList = "vcx_idf_cod,vcx_cxa_cod,vcx_emp_cod,vcx_mdc_num,vcx_mov", unique = true),
				@Index(name = "icom_vcx_idf_fk", columnList = "vcx_idf_cod"),
				@Index(name = "icom_vcx_cxa_fk", columnList = "vcx_cxa_cod"),
				@Index(name = "icom_vcx_emp_fk", columnList = "vcx_emp_cod"),
				@Index(name = "icom_vcx_mdc_fk", columnList = "vcx_mdc_num"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "vcx_idf_cod", length = 4)),
	@AttributeOverride(name = "id.caixaCodi", column = @Column(name = "vcx_cxa_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "vcx_emp_cod", length = 4)),
	@AttributeOverride(name = "id.caixaMovimentNumero", column = @Column(name = "vcx_mdc_num", length = 22, precision = 10)),
	@AttributeOverride(name = "id.moviment", column = @Column(name = "vcx_mov", length = 22, precision = 10)),	
	
	@AttributeOverride(name = "embedded.moviment", column = @Column(name = "vcx_mov", length = 22, precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "vcx_imp", length = 22, precision = 15, scale = 3, nullable = false)),
	
//	@AttributeOverride(name = "embedded.facturaClasse", column = @Column(name = "vcx_fac_cls", length = 1)),
//	@AttributeOverride(name = "embedded.facturaNumero", column = @Column(name = "vcx_fac_num", length = 22, precision = 10)),
	
	@AttributeOverride(name = "embedded.cmpvcpseq", column = @Column(name = "vcx_cmpvcpseq", length = 22, precision = 10)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "vcx_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "vcx_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "vcx_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "vcx_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "vcx_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_idf_fk"))
})

public class VencimentPagatEntity extends AbstractWithIdentificadorAuditableEntity<VencimentPagat, VencimentPagatPk> {

	@Embedded
	protected VencimentPagat embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "vcx_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "vcx_idf_cod", referencedColumnName = "cxa_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_cxa_cod", referencedColumnName = "cxa_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_emp_cod", referencedColumnName = "cxa_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_cxa_fk"))
	protected CaixaEntity caixa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "vcx_idf_cod", referencedColumnName = "mdc_idf_cod", insertable = false, updatable = false),					
					@JoinColumn(name = "vcx_emp_cod", referencedColumnName = "mdc_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_cxa_cod", referencedColumnName = "mdc_cxa_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_mdc_num", referencedColumnName = "mdc_num", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_mdc_fk"))
	protected CaixaMovimentEntity caixaMoviment;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "vcx_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_ser_fk"))
	private SerieVendaEntity serieVenda;	
	@Column(name = "vcx_ser_cod", length = 2)
	private String serieVendaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "vcx_idf_cod", referencedColumnName = "fac_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_emp_cod", referencedColumnName = "fac_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_ser_cod", referencedColumnName = "fac_ser_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_fac_num", referencedColumnName = "fac_num", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_fac_cls", referencedColumnName = "fac_cls", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_fac_fk"))
	private FacturaEntity factura;
	@Column(name = "vcx_fac_num", length = 22)
	private Integer facturaNumero;
	@Column(name = "vcx_fac_cls", length = 1)
	private String facturaClasse;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "vcx_idf_cod", referencedColumnName = "ven_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_emp_cod", referencedColumnName = "ven_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_ser_cod", referencedColumnName = "ven_ser_cod", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_fac_cls", referencedColumnName = "ven_fac_cls", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_fac_num", referencedColumnName = "ven_fac_num", insertable = false, updatable = false),
					@JoinColumn(name = "vcx_ven_num", referencedColumnName = "ven_num", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_vcx_ven_fk"))
	private VencimentEntity venciment;	
	@Column(name = "vcx_ven_num", length = 22)
	private Integer vencimentNumero;
	
	@Builder
	public VencimentPagatEntity(
			VencimentPagatPk pk,
			VencimentPagat embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,			
			CaixaEntity caixa,
			CaixaMovimentEntity caixaMoviment,
			SerieVendaEntity serieVenda,
			FacturaEntity factura,
			VencimentEntity venciment) {
		
		setId(pk);		
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.caixa = caixa;
		this.caixaMoviment = caixaMoviment;
		
		this.updateSerieVenda (serieVenda);			
		this.updateVenciment(venciment);
		
//		Actualitzarem la factura en cas d'actualització del venciment
//		this.updateFactura (factura);
	}

	@Override
	public void update(VencimentPagat embedded) {
		this.embedded = embedded;
	}
	
	public void updateSerieVenda(SerieVendaEntity serieVenda) {
		this.serieVenda = serieVenda;
		if (serieVenda != null) {
			this.serieVendaCodi = serieVenda.getEmbedded().getCodi();
		}
	}
	
//	public void updateFactura(FacturaEntity factura) {
//		this.factura = factura;
//		if (factura != null) {
//			this.facturaNumero = factura.getEmbedded().getNumero();
//			this.facturaClasse = factura.getEmbedded().getClasse();			
//		}
//	}
	
	public void updateVenciment(VencimentEntity venciment) {
		this.venciment = venciment;		
		if (venciment != null) {
			this.factura = venciment.getFactura();
			this.facturaNumero = this.factura.getEmbedded().getNumero();
			this.facturaClasse = this.factura.getEmbedded().getClasse();			
			this.vencimentNumero = venciment.getEmbedded().getNumero();
		}
	}

}
