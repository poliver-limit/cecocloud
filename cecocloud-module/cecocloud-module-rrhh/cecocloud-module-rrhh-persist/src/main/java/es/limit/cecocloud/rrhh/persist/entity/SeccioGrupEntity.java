/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.persist.entity.EmpresaEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup.SeccioGrupPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una seccio grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_gse",
		indexes = {
				@Index(name = "irhu_gse_idf_fk", columnList = "gse_idf_cod"),
				@Index(name = "irrhu_gse_pk", columnList = "gse_idf_cod,gse_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gse_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "gse_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "gse_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "gse_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "gse_nom", length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "gse_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "gse_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "gse_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "gse_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "gse_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_gse_idf_fk"))
})
public class SeccioGrupEntity extends AbstractWithIdentificadorAuditableEntity<SeccioGrup, SeccioGrupPk> {

	@Embedded
	protected SeccioGrup embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "gse_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "gse_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rrhu_gse_emp_fk"))
	protected EmpresaEntity empresa;

	@Builder
	public SeccioGrupEntity(
			SeccioGrupPk pk,
			SeccioGrup embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;	
		this.empresa = empresa;
		
	}

	@Override
	public void update(SeccioGrup embedded) {
		this.embedded = embedded;
	}

}
