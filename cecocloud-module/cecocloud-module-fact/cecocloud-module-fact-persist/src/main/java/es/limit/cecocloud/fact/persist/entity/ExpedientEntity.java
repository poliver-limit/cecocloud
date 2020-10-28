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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.fact.logic.api.dto.Expedient;
import es.limit.cecocloud.fact.logic.api.dto.Expedient.ExpedientPk;
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
@Entity(name = "factExpedientEntity")
@Table(
		name = "tges_exd",
		indexes = {
				@Index(name = "iges_exd_idf_fk", columnList = "exd_idf_cod"),
				@Index(name = "irges_exd_pk", columnList = "exd_idf_cod, exd_emp_cod, exd_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "exd_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "exd_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "exd_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "exd_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "exd_nom", length = 60, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "exd_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "exd_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "exd_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "exd_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "exd_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_exd_idf_fk"))
})
public class ExpedientEntity extends AbstractWithIdentificadorAuditableEntity<Expedient, ExpedientPk> {

	@Embedded
	protected Expedient embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "exd_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "exd_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_exd_emp_fk"))			
	protected EmpresaEntity empresa;	
	
	@Formula(value="(SELECT CONCAT(CONCAT(exd.exd_nom,' - '),exd.exd_cod) FROM tges_exd exd where exd.exd_cod = exd_cod and exd.exd_idf_cod = exd_idf_cod and exd.exd_emp_cod = exd_emp_cod)")
	private String descExpNomCodi;
	
	@Builder
	public ExpedientEntity(
			ExpedientPk pk,			
			IdentificadorEntity identificador,
			Expedient embedded,
			EmpresaEntity empresa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
	}

	@Override
	public void update(Expedient embedded) {
		this.embedded = embedded;
	}

}
