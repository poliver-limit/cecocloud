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
		name = "tcec_hpv",
		indexes = {
				@Index(name = "ircec_hpv_pk", columnList = "hpv_idf_cod,hpv_emp_cod,hpv_ptv_cod,hpv_hor_cod", unique = true),
				@Index(name = "icec_hpv_idf_fk", columnList = "hpv_idf_cod"),
				@Index(name = "icec_hpv_emp_fk", columnList = "hpv_idf_cod,hpv_emp_cod"),
				@Index(name = "icec_hpv_ptv_fk", columnList = "hpv_idf_cod,hpv_emp_cod,hpv_ptv_cod"),
				@Index(name = "icec_hpv_hor_fk", columnList = "hpv_idf_cod,hpv_hor_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "hpv_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "hpv_emp_cod", length = 4)),
	@AttributeOverride(name = "id.puntVendaCodi", column = @Column(name = "hpv_ptv_cod", length = 4)),
	@AttributeOverride(name = "id.horariCodi", column = @Column(name = "hpv_hor_cod", length = 4)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "hpv_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "hpv_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "hpv_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "hpv_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "hpv_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_hpv_idf_fk"))
})
public class PuntVendaHorariEntity extends AbstractWithIdentificadorAuditableEntity<PuntVendaHorari, PuntVendaHorariPk> {

	@Embedded
	protected PuntVendaHorari embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "hpv_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hpv_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "hpv_emp_cod_fk"))
	private EmpresaEntity empresa;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "hpv_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hpv_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hpv_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "hpv_ptv_cod_fk"))
	private PuntVendaEntity puntVenda;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "hpv_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hpv_hor_cod", referencedColumnName = "hor_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "hpv_hor_cod_fk"))
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
