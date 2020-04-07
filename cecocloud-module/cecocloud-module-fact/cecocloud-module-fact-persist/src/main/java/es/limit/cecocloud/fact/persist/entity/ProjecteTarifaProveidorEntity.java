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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.ProjecteTarifaProveidor;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteTarifaProveidor.ProjecteTarifaProveidorPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de ProjecteTarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_taj",
		indexes = {
				@Index(name = "rges_taj_pk", columnList = "taj_idf_cod, taj_emp_cod, taj_prj_num, taj_pro_cod, taj_tpr_cod", unique = true),
				@Index(name = "iges_taj_emp_fk", columnList = "taj_idf_cod, taj_emp_cod"),
				@Index(name = "iges_taj_prj_fk", columnList = "taj_idf_cod, taj_prj_num"),
				@Index(name = "iges_taj_pro_fk", columnList = "taj_idf_cod, taj_pro_cod"),
				@Index(name = "iges_taj_tpr_fk", columnList = "taj_idf_cod, taj_tpr_cod"),
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "taj_idf_cod", length = 4)),
		@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "taj_emp_cod", length = 4)),
		@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "taj_prj_num", length = 6)),
		@AttributeOverride(name = "id.proveidorCodi", column = @Column(name = "taj_pro_cod", length = 6)),
		@AttributeOverride(name = "id.tarifaProveidorCodi", column = @Column(name = "taj_tpr_cod", length = 6)),	
		
		@AttributeOverride(name = "createdBy", column = @Column(name = "taj_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "taj_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "taj_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "taj_datmod")) 
})

@AssociationOverrides({ 
		@AssociationOverride(
					name = "identificador", 
					joinColumns = {
							@JoinColumn(name = "taj_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})

public class ProjecteTarifaProveidorEntity extends AbstractWithIdentificadorAuditableEntity<ProjecteTarifaProveidor, ProjecteTarifaProveidorPk> {

	@Embedded
	protected ProjecteTarifaProveidor embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "taj_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "taj_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_taj_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "taj_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "taj_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "taj_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_taj_prj_fk"))
	protected ProjecteEntity projecte;	

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "taj_idf_cod", referencedColumnName = "pro_idf_cod", insertable = false, updatable = false),						
						@JoinColumn(name = "taj_pro_cod", referencedColumnName = "pro_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_taj_pro_fk"))
	protected ProveidorEntity proveidor;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "taj_idf_cod", referencedColumnName = "tpr_idf_cod", insertable = false, updatable = false),						
						@JoinColumn(name = "taj_tpr_cod", referencedColumnName = "tpr_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_taj_tpr_fk"))
	protected TarifaProveidorEntity tarifaProveidor;
	
	@Builder
	public ProjecteTarifaProveidorEntity(
			ProjecteTarifaProveidorPk pk, 
			ProjecteTarifaProveidor embedded, 
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecte,
			ProveidorEntity proveidor,
			TarifaProveidorEntity tarifaProveidor) {
		
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.projecte = projecte;
		this.proveidor = proveidor;
		this.tarifaProveidor = tarifaProveidor;	
		
	}

	@Override
	public void update(ProjecteTarifaProveidor embedded) {
		this.embedded = embedded;
	}	

}
