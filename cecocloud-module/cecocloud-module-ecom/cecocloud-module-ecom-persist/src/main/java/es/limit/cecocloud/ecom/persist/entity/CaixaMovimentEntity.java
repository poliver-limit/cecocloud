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

import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment.CaixaMovimentPk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
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
@Entity(name = "ecomCaixaMovimentEntity")
@Table(
		name = "tcom_mdc",
		indexes = {
				@Index(name = "ircom_mdc_pk", columnList = "mdc_idf_cod,mdc_emp_cod,mdc_num,mdc_cxa_cod", unique = true),
				@Index(name = "icom_mdc_idf_fk", columnList = "mdc_idf_cod"),
				@Index(name = "icom_mdc_emp_fk", columnList = "mdc_emp_cod"),
				@Index(name = "icom_mdc_cxa_fk", columnList = "mdc_cxa_cod")				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mdc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "mdc_emp_cod", length = 4)),
	@AttributeOverride(name = "id.caixaCodi", column = @Column(name = "mdc_cxa_cod", length = 4)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "mdc_num", length = 22, precision = 10)),	
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "mdc_num", length = 22, precision = 10, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "embedded.cls", column = @Column(name = "mdc_cls", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.dia", column = @Column(name = "mdc_dia", length = 7, nullable = false)),
	@AttributeOverride(name = "embedded.tip", column = @Column(name = "mdc_tip", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "mdc_imp", length = 22, precision = 15, scale = 3, nullable = false)),
	@AttributeOverride(name = "embedded.valorDivisaEuros", column = @Column(name = "mdc_valdiveur", length = 22, precision = 15, scale = 8, nullable = false)),	
	@AttributeOverride(name = "embedded.anc", column = @Column(name = "mdc_anc", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.trs", column = @Column(name = "mdc_trs", length = 1, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "mdc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mdc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mdc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mdc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mdc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_idf_fk"))
})

public class CaixaMovimentEntity extends AbstractWithIdentificadorAuditableEntity<CaixaMoviment, CaixaMovimentPk> {

	@Embedded
	protected CaixaMoviment embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mdc_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mdc_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mdc_idf_cod", referencedColumnName = "cxa_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mdc_cxa_cod", referencedColumnName = "cxa_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mdc_emp_cod", referencedColumnName = "cxa_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_cxa_fk"))
	protected CaixaEntity caixa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mdc_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mdc_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_ope_fk"))
	private OperariEntity operari;
	@Column(name = "mdc_ope_cod", length = 6, nullable = false)
	private String operariCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "mdc_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "mdc_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "mdc_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "mdc_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "mdc_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;
	@Column(name = "mdc_dpg_cod", length = 4, nullable = false)
	private String documentPagamentCobramentCodi;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mdc_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mdc_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mdc_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mdc_pre_fk"))
	protected PressupostEntity pressupost;
	@Column(name = "mdc_pre_cod", length = 22)
	private Integer pressupostCodi;


	@Builder
	public CaixaMovimentEntity(
			CaixaMovimentPk pk,
			CaixaMoviment embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			CaixaEntity caixa,
			OperariEntity operari,
			DivisaEntity divisa,
			DocumentPagamentCobramentEntity documentPagamentCobrament,			
			PressupostEntity pressupost
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.caixa = caixa;		
		
		this.updateOperari (operari);
		this.updateDivisa (divisa);
		this.updateDocumentPagamentCobrament (documentPagamentCobrament);
		this.updatePressupost (pressupost);
	}

	@Override
	public void update(CaixaMoviment embedded) {
		this.embedded = embedded;
	}
	
	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
		}
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getEmbedded().getCodi();
		}
	}
	
	public void updateDocumentPagamentCobrament(DocumentPagamentCobramentEntity documentPagamentCobrament) {
		this.documentPagamentCobrament = documentPagamentCobrament;
		if (documentPagamentCobrament != null) {
			this.documentPagamentCobramentCodi = documentPagamentCobrament.getEmbedded().getCodi();
		}
	}
	
	public void updatePressupost(PressupostEntity pressupost) {
		this.pressupost = pressupost;
		if (pressupost != null) {
			this.pressupostCodi = pressupost.getEmbedded().getCodi();
		}
	}
	
	

}
