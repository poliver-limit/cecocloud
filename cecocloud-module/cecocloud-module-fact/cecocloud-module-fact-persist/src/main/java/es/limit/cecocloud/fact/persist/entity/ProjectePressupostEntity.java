/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost.ProjectePressupostPk;
import es.limit.cecocloud.fact.persist.entity.ProjectePressupostEntity.ProjectePressupostEntityListener;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un ProjectePressupost
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_pjp",
		indexes = {
				@Index(name = "rges_pjp_pk", columnList = "pjp_prj_num, pjp_num, pjp_emp_cod, pjp_idf_cod", unique = true),
				@Index(name = "iges_pjp_emp_fk", columnList = "pjp_idf_cod, pjp_emp_cod"),
				@Index(name = "iges_pjp_prj_fk", columnList = "pjp_idf_cod, pjp_prj_num"),
				@Index(name = "iges_pjp_pre_fk", columnList = "pjp_idf_cod, pjp_pre_cod"),
				@Index(name = "iges_pjp_pda_fk", columnList = "pjp_idf_cod, pjp_pda_cod"),
				@Index(name = "iges_pjp_cap_fk", columnList = "pjp_idf_cod, pjp_cap_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pjp_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pjp_emp_cod", length = 4)),
	@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "pjp_prj_num", length = 6)),
	@AttributeOverride(name = "id.projectePressupostCodi", column = @Column(name = "pjp_num", precision = 10)),	
	@AttributeOverride(name = "embedded.projecteNumero", column = @Column(name = "pjp_prj_num", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.projectePressupostCodi", column = @Column(name = "pjp_num", precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "pjp_obs", length = 1000)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pjp_usucre", nullable = false)),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pjp_datcre", nullable = false)),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pjp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pjp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pjp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
@EntityListeners({ProjectePressupostEntityListener.class})
public class ProjectePressupostEntity extends AbstractWithIdentificadorAuditableEntity<ProjectePressupost, ProjectePressupostPk> {

	@Embedded
	protected ProjectePressupost embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pjp_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_pjp_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pjp_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_pjp_prj_fk"))
	protected ProjecteEntity projecte;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pjp_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_pjp_pre_fk"))
	protected PressupostEntity pressupost;
	@Column(name = "pjp_pre_cod", length = 6)
	private Integer pressupostCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {					
					@JoinColumn(name = "pjp_idf_cod", referencedColumnName = "pda_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_cap_cod", referencedColumnName = "pda_cap_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_emp_cod", referencedColumnName = "pda_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_pre_cod", referencedColumnName = "pda_pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_pda_cod", referencedColumnName = "pda_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_pjp_pda_fk"))
	protected PartidaEntity partida;
	@Column(name = "pjp_pda_cod", length = 6)
	private String partidaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pjp_idf_cod", referencedColumnName = "cap_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_emp_cod", referencedColumnName = "cap_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_pre_cod", referencedColumnName = "cap_pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pjp_cap_cod", referencedColumnName = "cap_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_pjp_cap_fk"))
	protected CapitolEntity capitol;
	@Column(name = "pjp_cap_cod", length = 6)
	private String capitolCodi;
	
	// Segons funcional de Vendes: "No incloure el camp Capitol, pjp_cpp_cod"
	// Aquest camp existeix, actualment, al model de dades de Cecogest

	@Builder
	public ProjectePressupostEntity(
			ProjectePressupostPk pk,
			ProjectePressupost embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecte,
			PressupostEntity pressupost,
			PartidaEntity partida,
			CapitolEntity capitol) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;	
		this.projecte = projecte;
		
		this.updatePressupost(pressupost);
		this.updatePartida(partida);
		this.updateCapitol(capitol);
		
	}

	@Override
	public void update(ProjectePressupost embedded) {
		this.embedded = embedded;
	}
	
	public void updatePressupost(PressupostEntity pressupost) {
		this.pressupost = pressupost;
		if (pressupost != null) {
			this.pressupostCodi = pressupost.getEmbedded().getCodi();
		}
	}
	
	public void updatePartida(PartidaEntity partida) {
		this.partida = partida;
		if (partida != null) {
			this.partidaCodi = partida.getEmbedded().getCodi();
		}
	}
	
	public void updateCapitol(CapitolEntity capitol) {
		this.capitol = capitol;
		if (capitol != null) {
			this.capitolCodi = capitol.getEmbedded().getCodi();
		}
	}

	public static class ProjectePressupostEntityListener {
		@PrePersist
		public void calcular(ProjectePressupostEntity projectePressupost) {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					projectePressupost.getIdentificador().getId(),
					"TGES_PJP",
					null);
			projectePressupost.getEmbedded().setProjectePressupostCodi(seq);
			projectePressupost.getId().setProjectePressupostCodi(seq);
		}
	}

}
