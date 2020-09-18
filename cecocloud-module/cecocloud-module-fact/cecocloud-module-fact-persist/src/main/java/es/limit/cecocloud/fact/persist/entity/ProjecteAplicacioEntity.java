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

import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio.ProjecteAplicacioPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un projecte aplicacio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_aap",
		indexes = {
				@Index(name = "rges_aap_pk", columnList = "aap_idf_cod, aap_emp_cod, aap_prj_num, aap_apl", unique = true),
				@Index(name = "iges_aap_emp_fk", columnList = "aap_idf_cod, aap_emp_cod"),
				@Index(name = "iges_aap_prj_fk", columnList = "aap_idf_cod, aap_prj_num")				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "aap_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "aap_emp_cod", length = 4)),
	@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "aap_prj_num", length = 6)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "aap_apl")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "aap_apl", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.valorPercentual", column = @Column(name = "aap_percen")),
	@AttributeOverride(name = "embedded.codiProjecteAap", column = @Column(name = "aap_codapl", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "aap_obs", length = 1000))

})

@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "aap_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_aap_idf_fk"))
})
public class ProjecteAplicacioEntity extends AbstractWithIdentificadorEntity<ProjecteAplicacio, ProjecteAplicacioPk> {

	@Embedded
	protected ProjecteAplicacio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "aap_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "aap_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_aap_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "aap_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "aap_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "aap_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_aap_prj_fk"))
	protected ProjecteEntity projecte;	
	
	@Builder
	public ProjecteAplicacioEntity(
			ProjecteAplicacioPk pk,
			ProjecteAplicacio embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecte
		) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.projecte = projecte;
				
	}

	@Override
	public void update(ProjecteAplicacio embedded) {
		this.embedded = embedded;
	}
	
}
