/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.ecom.logic.api.dto.Caixa;
import es.limit.cecocloud.ecom.logic.api.dto.Caixa.CaixaPk;
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
@Entity(name = "ecomCaixaEntity")
@Table(
		name = "tcom_cxa",
		indexes = {
				@Index(name = "ircom_cxa_pk", columnList = "cxa_idf_cod,cxa_emp_cod,cxa_cod", unique = true),
				@Index(name = "icom_cxa_idf_fk", columnList = "cxa_idf_cod"),
				@Index(name = "icom_cxa_emp_fk", columnList = "cxa_emp_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cxa_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "cxa_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "cxa_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cxa_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "cxa_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.ferApuntComptable", column = @Column(name = "cxa_apucmp", nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "cxa_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "cxa_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cxa_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cxa_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cxa_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cxa_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_cxa_idf_fk"))
})
public class CaixaEntity extends AbstractWithIdentificadorAuditableEntity<Caixa, CaixaPk> {

	@Embedded
	protected Caixa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cxa_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cxa_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_cxa_emp_fk"))
	protected EmpresaEntity empresa;

	@Builder
	public CaixaEntity(
			CaixaPk pk,
			Caixa embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
	}

	@Override
	public void update(Caixa embedded) {
		this.embedded = embedded;
	}

}
