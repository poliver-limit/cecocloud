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

import es.limit.cecocloud.fact.logic.api.dto.Taller;
import es.limit.cecocloud.fact.logic.api.dto.Taller.TallerPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de taller.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factTallerEntity")
@Table(
		name = "tges_tal",
		indexes = {
				@Index(name = "iges_tal_idf_fk", columnList = "tal_idf_cod"),
				@Index(name = "irges_tal_pk", columnList = "tal_idf_cod, tal_emp_cod, tal_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tal_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "tal_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tal_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tal_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tal_nom", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.direccio", column = @Column(name = "tal_dir", length = 60)),
	@AttributeOverride(name = "embedded.col", column = @Column(name = "tal_col", length = 15)),
	@AttributeOverride(name = "embedded.diaOberta", column = @Column(name = "tal_diaobe", length = 22, precision = 3)),
	@AttributeOverride(name = "embedded.diaSensa", column = @Column(name = "tal_diasen", length = 22, precision = 3)),
	@AttributeOverride(name = "embedded.percControl", column = @Column(name = "tal_diaobe", length = 22, precision = 5, scale = 2)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tal_obs", length = 1000)),
	@AttributeOverride(name = "embedded.ana", column = @Column(name = "tal_ana", length = 1)),
	@AttributeOverride(name = "embedded.ctecmpexi", column = @Column(name = "tal_ctecmpexi", length = 10)),
	@AttributeOverride(name = "embedded.ctecmpfacpdt", column = @Column(name = "tal_ctecmpfacpdt", length = 10)),
	@AttributeOverride(name = "embedded.ctecmpdsp", column = @Column(name = "tal_ctecmpdsp", length = 10)),
	@AttributeOverride(name = "embedded.prjnumtlr", column = @Column(name = "tal_prj_numtlr", length = 6)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tal_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tal_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tal_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tal_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tal_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tal_idf_fk"))
})
public class TallerEntity extends AbstractWithIdentificadorAuditableEntity<Taller, TallerPk> {

	@Embedded
	protected Taller embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tal_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tal_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tal_emp_fk"))			
	protected EmpresaEntity empresa;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tal_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tal_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tal_mag_fk"))			
	protected MagatzemEntity magatzem;	
	@Column(name = "tal_mag_cod", length = 4)
	private String magatzemCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "tal_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "tal_prj_cod", referencedColumnName = "prj_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_tal_prj_fk"))
	protected ProjecteEntity projecte;
	@Column(name = "tal_prj_num", length = 6)
	private String projecteCodi;
	
	@Builder
	public TallerEntity(
			TallerPk pk,			
			IdentificadorEntity identificador,
			Taller embedded,
			EmpresaEntity empresa,
			MagatzemEntity magatzem,
			ProjecteEntity projecte) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;

		updateMagatzem(magatzem);
		updateProjecte(projecte);
	}

	@Override
	public void update(Taller embedded) {
		this.embedded = embedded;
	}

	public void updateMagatzem(MagatzemEntity magatzem) {
		this.magatzem = magatzem;
		if (magatzem != null) {
			this.magatzemCodi = magatzem.getId().getCodi();
		}
	}
	
	public void updateProjecte(ProjecteEntity projecte) {
		this.projecte = projecte;
		if (projecte != null) {
			this.projecteCodi = projecte.getId().getCodi();
		}
	}

}
