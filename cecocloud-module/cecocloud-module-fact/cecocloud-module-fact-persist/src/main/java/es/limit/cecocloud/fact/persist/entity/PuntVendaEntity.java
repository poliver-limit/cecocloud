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

import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ptv",
		indexes = {
				@Index(name = "irges_ptv_pk", columnList = "ptv_idf_cod,ptv_emp_cod,ptv_cod", unique = true),
				@Index(name = "iges_ptv_idf_fk", columnList = "ptv_idf_cod"),
				@Index(name = "iges_ptv_emp_fk", columnList = "ptv_emp_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ptv_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ptv_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ptv_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ptv_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ptv_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "ptv_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ptv_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ptv_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ptv_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ptv_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ptv_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_idf_fk"))
})
public class PuntVendaEntity extends AbstractWithIdentificadorAuditableEntity<PuntVenda, PuntVendaPk> {

	@Embedded
	protected PuntVenda embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_emp_fk"))
	protected EmpresaEntity empresa;

	@Builder
	public PuntVendaEntity(
			PuntVendaPk pk,
			PuntVenda embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
	}

	@Override
	public void update(PuntVenda embedded) {
		this.embedded = embedded;
	}

}
