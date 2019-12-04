/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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
	@AttributeOverride(name = "id.calendariData", column = @Column(name = "rdi_cln_dat")),
	
	@AttributeOverride(name = "embedded.calendariData", column = @Column(name = "rdi_cln_dat", insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.operariCodi", column = @Column(name = "rdi_ope_cod", length = 6, insertable = false, updatable = false)),			
	@AttributeOverride(name = "embedded.horesTeoriques", column = @Column(name = "rdi_horteo", length = 22, precision = 22, scale = 0, nullable = false)),			
	@AttributeOverride(name = "embedded.horesNormals", column = @Column(name = "rdi_hornor", length = 22, precision = 22, scale = 0, nullable = false)),			
	@AttributeOverride(name = "embedded.horesExtras", column = @Column(name = "rdi_horext", length = 22, precision = 22, scale = 0, nullable = false)),			
	@AttributeOverride(name = "embedded.preuHoresExtras", column = @Column(name = "rdi_pruext", length = 22, precision = 22, scale = 0, nullable = false)),			
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
public class RegistreDiariEntity extends AbstractAuditableCompositePkEntity<RegistreDiari, RegistreDiariPk> {

	@Embedded
	protected RegistreDiari embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "rdi_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_rdi_idf_fk"))
	protected IdentificadorEntity identificador;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
		@JoinColumns(
				value = {
						@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "cln_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "rdi_cln_dat", referencedColumnName = "cln_dat", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rrhu_rdi_cln_fk"))
	protected CalendariEntity calendari;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_ope_fk"))
	protected OperariEntity operari;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_hor_cod", referencedColumnName = "hor_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_hor_fk"))
	protected HorariEntity horari;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "reg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_reg_cod", referencedColumnName = "reg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_reg_fk"))
	protected RegimEntity regim;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "sec_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_sec_cod", referencedColumnName = "sec_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_emp_cod", referencedColumnName = "sec_emp_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_sec_fk"))
	protected SeccioEntity seccio;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "cat_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_cat_cod", referencedColumnName = "cat_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_cat_fk"))
	protected CategoriaEntity categoria;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rdi_idf_cod", referencedColumnName = "sct_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rdi_sct_cod", referencedColumnName = "sct_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_rdi_sct_fk"))
	protected SubcategoriaEntity subcategoria;
	
	@Builder
	public RegistreDiariEntity(
			RegistreDiariPk pk,
			RegistreDiari embedded,
			IdentificadorEntity identificador,
			CalendariEntity calendari,
			OperariEntity operari,
			HorariEntity horari,
			RegimEntity regim,
			SeccioEntity seccio,
			EmpresaEntity empresa,
			CategoriaEntity categoria,
			SubcategoriaEntity subcategoria
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.calendari = calendari;
		this.operari = operari;
		this.horari = horari;
		this.regim = regim;
		this.seccio = seccio;
		this.empresa = empresa;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
	}

	@Override
	public void update(RegistreDiari embedded) {
		this.embedded = embedded;
	}

}
