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

import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
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
		name = "tcit_cit",
		indexes = {
				@Index(name = "ircit_cit_pk", columnList = "cit_idf_cod,cit_ptv_cod,cit_cod", unique = true),
				@Index(name = "icit_cit_idf_fk", columnList = "cit_idf_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cit_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "cit_emp_cod", length = 4)),
	@AttributeOverride(name = "id.puntVendaCodi", column = @Column(name = "cit_ptv_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "cit_cod", length = 10)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cit_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "cit_data", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "cit_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cit_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cit_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cit_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cit_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cit_idf_fk"))
})
public class CitaEntity extends AbstractWithIdentificadorAuditableEntity<Cita, CitaPk> {

	@Embedded
	protected Cita embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cit_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cit_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cit_emp_cod_fk"))
	private EmpresaEntity empresa;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cit_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cit_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cit_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cit_ptv_cod_fk"))
	private PuntVendaEntity puntVenda;

	@Builder
	public CitaEntity(
			CitaPk pk,
			Cita embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PuntVendaEntity puntVenda) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.puntVenda = puntVenda;
	}

	@Override
	public void update(Cita embedded) {
		this.embedded = embedded;
	}

}
