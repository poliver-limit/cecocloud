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
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost.ProjectePressupostPk;
import es.limit.cecocloud.fact.persist.listener.ProjectePressupostEntityListener;
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
				@Index(name = "rges_pjp_pk", columnList = "pjp_prj_num, pjp_num, pjp_emp_cod, pjp_idf_cod", unique = true)
				,
//				@Index(name = "iges_pjp_emp_fk", columnList = "pjp_idf_cod, pjp_emp_cod"),
//				@Index(name = "iges_pjp_cli_fk", columnList = "pjp_idf_cod, pjp_cli_cod"),
//				@Index(name = "iges_pjp_apl_fk", columnList = "pjp_idf_cod, pjp_apl_ref")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "pjp_prj_num", length = 6)),
	@AttributeOverride(name = "id.pressupostNumero", column = @Column(name = "pjp_num", precision = 10)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pjp_emp_cod", length = 4)),
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pjp_idf_cod", length = 4)),	
	
	@AttributeOverride(name = "embedded.projecteNumero", column = @Column(name = "pjp_prj_num", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.pressupostNumero", column = @Column(name = "pjp_num", precision = 10, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.pressupostCodi", column = @Column(name = "pjp_pre_cod", precision = 10)),
	@AttributeOverride(name = "embedded.capitolCodi", column = @Column(name = "pjp_cap_cod", length = 4)),
	@AttributeOverride(name = "embedded.partidaCodi", column = @Column(name = "pjp_pda_cod", length = 4)),
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

	@Builder
	public ProjectePressupostEntity(
			ProjectePressupostPk pk,
			ProjectePressupost embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;	
	}

	@Override
	public void update(ProjectePressupost embedded) {
		this.embedded = embedded;
	}
	
}
