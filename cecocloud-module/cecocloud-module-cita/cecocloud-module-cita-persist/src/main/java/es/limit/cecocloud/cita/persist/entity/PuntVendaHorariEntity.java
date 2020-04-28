/**
 * 
 */
package es.limit.cecocloud.cita.persist.entity;

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

import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari.PuntVendaHorariPk;
import es.limit.cecocloud.fact.persist.entity.AbstractWithIdentificadorAuditableEntity;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;
import es.limit.cecocloud.fact.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tcit_pvh",
		indexes = {
				@Index(name = "ircit_pvh_pk", columnList = "pvh_idf_cod,pvh_emp_cod,pvh_ptv_cod,pvh_hor_cod", unique = true),
				@Index(name = "icit_pvh_idf_fk", columnList = "pvh_idf_cod"),
				@Index(name = "icit_pvh_emp_fk", columnList = "pvh_idf_cod,pvh_emp_cod"),
				@Index(name = "icit_pvh_ptv_fk", columnList = "pvh_idf_cod,pvh_emp_cod,pvh_ptv_cod"),
				@Index(name = "icit_pvh_hor_fk", columnList = "pvh_idf_cod,pvh_hor_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pvh_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pvh_emp_cod", length = 4)),
	@AttributeOverride(name = "id.puntVendaCodi", column = @Column(name = "pvh_ptv_cod", length = 4)),
	@AttributeOverride(name = "id.horariCodi", column = @Column(name = "pvh_hor_cod", length = 4)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "pvh_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pvh_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pvh_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pvh_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pvh_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pvh_idf_fk"))
})
public class PuntVendaHorariEntity extends AbstractWithIdentificadorAuditableEntity<PuntVendaHorari, PuntVendaHorariPk> {

	@Embedded
	protected PuntVendaHorari embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pvh_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pvh_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "pvh_emp_cod_fk"))
	private EmpresaEntity empresa;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pvh_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pvh_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pvh_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "pvh_ptv_cod_fk"))
	private PuntVendaEntity puntVenda;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pvh_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pvh_hor_cod", referencedColumnName = "hor_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "pvh_hor_cod_fk"))
	private HorariEntity horari;

	@Builder
	public PuntVendaHorariEntity(
			PuntVendaHorariPk pk,
			PuntVendaHorari embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PuntVendaEntity puntVenda,
			HorariEntity horari) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.puntVenda = puntVenda;
		this.horari = horari;
	}

	@Override
	public void update(PuntVendaHorari embedded) {
		this.embedded = embedded;
	}

}
