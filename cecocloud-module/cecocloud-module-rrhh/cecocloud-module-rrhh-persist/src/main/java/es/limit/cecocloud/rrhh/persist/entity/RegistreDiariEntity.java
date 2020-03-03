/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari.RegistreDiariPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un RegistreDiari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_rdi",
		indexes = {
				@Index(name = "irhu_rdi_idf_fk", columnList = "rdi_idf_cod"),
				@Index(name = "irrhu_rdi_pk", columnList = "rdi_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "rdi_idf_cod", length = 4)),
	@AttributeOverride(name = "id.calendariDataCodi", column = @Column(name = "rdi_cln_dat")),
//	@AttributeOverride(name = "id.operariCodi", column = @Column(name = "rdi_ope_cod", length = 6)),
//	@AttributeOverride(name = "embedded.calendariData", column = @Column(name = "rdi_cln_dat", insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.horesTeoriques", column = @Column(name = "rdi_horteo", length = 22, precision = 22, scale = 0, nullable = false)),
	@AttributeOverride(name = "embedded.horesNormals", column = @Column(name = "rdi_hornor", length = 22, precision = 22, scale = 0, nullable = false)),
	@AttributeOverride(name = "embedded.horesExtras", column = @Column(name = "rdi_horext", length = 22, precision = 22, scale = 0, nullable = false)),
	@AttributeOverride(name = "embedded.preuHoresExtras", column = @Column(name = "rdi_pruext", length = 22, precision = 22, scale = 0, nullable = false)),
	@AttributeOverride(name = "embedded.operariCodi", column = @Column(name = "rdi_ope_cod", nullable = false)),
	@AttributeOverride(name = "embedded.horariCodi", column = @Column(name = "rdi_hor_cod", nullable = false)),
	@AttributeOverride(name = "embedded.regimCodi", column = @Column(name = "rdi_reg_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.seccioCodi", column = @Column(name = "rdi_sec_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.empresaCodi", column = @Column(name = "rdi_emp_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.categoriaCodi", column = @Column(name = "rdi_cat_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.subcategoriaCodi", column = @Column(name = "rdi_sct_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.preuHoraNormal", column = @Column(name = "rdi_pruhornor", length = 22, precision = 15, scale = 2, nullable = false)),
	@AttributeOverride(name = "embedded.preuHoraNit", column = @Column(name = "rdi_pruhornit", length = 22, precision = 15, scale = 2, nullable = false)),
	@AttributeOverride(name = "embedded.horesNit", column = @Column(name = "rdi_hornit", length = 22, precision = 22, scale = 0, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "rdi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "rdi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "rdi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "rdi_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "rdi_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_idf_fk"))
})
public class RegistreDiariEntity extends AbstractWithIdentificadorAuditableEntity<RegistreDiari, RegistreDiariPk> {

	@Embedded
	protected RegistreDiari embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
		@JoinColumns(
				value = {
						@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "cln_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "rdi_cln_dat", referencedColumnName = "cln_dat", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rrhu_rdi_cln_fk"))
	protected CalendariEntity calendariData;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_ope_fk"))
	protected OperariEntity operari;
	@Column(name = "rdi_ope_cod", length = 6, nullable = false)
	private String operariCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_hor_cod", referencedColumnName = "hor_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_hor_fk"))
	protected HorariEntity horari;	
	@Column(name = "rdi_hor_cod", nullable = false)
	private String horariCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "reg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_reg_cod", referencedColumnName = "reg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_reg_fk"))
	protected RegimEntity regim;	
	@Column(name = "rdi_reg_cod", length = 4, nullable = false)
	private String regimCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "sec_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_sec_cod", referencedColumnName = "sec_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_emp_cod", referencedColumnName = "sec_emp_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_sec_fk"))
	protected SeccioEntity seccio;	
	@Column(name = "rdi_sec_cod", length = 4, nullable = false)
	private String seccioCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_emp_fk"))
	protected EmpresaEntity empresa;
	@Column(name = "rdi_emp_cod", length = 4, nullable = false)
	private String empresaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "cat_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_cat_cod", referencedColumnName = "cat_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_cat_fk"))
	protected CategoriaEntity categoria;
	@Column(name = "rdi_cat_cod", length = 4, nullable = false)
	private String categoriaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "sct_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_sct_cod", referencedColumnName = "sct_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_sct_fk"))
	protected SubcategoriaEntity subcategoria;
	@Column(name = "rdi_sct_cod", length = 4, nullable = false)
	private String subcategoriaCodi;
	
	@Builder
	public RegistreDiariEntity(
			RegistreDiariPk pk,
			RegistreDiari embedded,
			IdentificadorEntity identificador,
			CalendariEntity calendariData,	
			CategoriaEntity categoria,
			EmpresaEntity empresa,
			HorariEntity horari,
			OperariEntity operari,
			RegimEntity regim,
			SeccioEntity seccio,		
			SubcategoriaEntity subcategoria) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.calendariData = calendariData;		
		
		this.operariCodi = operari.getEmbedded().getCodi();
		this.horariCodi = horari.getEmbedded().getCodi();
		this.regimCodi = regim.getEmbedded().getCodi();
		this.seccioCodi = seccio.getEmbedded().getCodi();
		this.empresaCodi = empresa.getEmbedded().getCodi();
		this.categoriaCodi = categoria.getEmbedded().getCodi();
		this.subcategoriaCodi = subcategoria.getEmbedded().getCodi();
	}

	@Override
	public void update(RegistreDiari embedded) {
		this.embedded = embedded;
	}
	
	public void updateOperari (OperariEntity operari) {
		this.operariCodi = operari.getEmbedded().getCodi();
	}
	
	public void updateHorari (HorariEntity horari) {
		this.horariCodi = horari.getEmbedded().getCodi();
	}
	
	public void updateRegim (RegimEntity regim) {
		this.regimCodi = regim.getEmbedded().getCodi();
	}
	
	public void updateSeccio (SeccioEntity seccio) {
		this.seccioCodi = seccio.getEmbedded().getCodi();
	}
	
	public void updateEmpresa (EmpresaEntity empresa) {
		this.empresaCodi = empresa.getEmbedded().getCodi();
	}
	
	public void updateCategoria (CategoriaEntity categoria) {
		this.categoriaCodi = categoria.getEmbedded().getCodi();
	}
	
	public void updateSubcategoria (SubcategoriaEntity subCategoria) {
		this.subcategoriaCodi = subcategoria.getEmbedded().getCodi();
	}

}
