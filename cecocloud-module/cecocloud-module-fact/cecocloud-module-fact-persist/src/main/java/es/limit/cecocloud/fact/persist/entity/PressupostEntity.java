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

import es.limit.cecocloud.fact.logic.api.dto.Pressupost;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_pre",
		indexes = {				
				@Index(name = "rges_pre_pk", columnList = "pre_idf_cod,pre_emp_cod,pre_cod", unique = true),
				@Index(name = "iges_pre_emp_fk", columnList = "pre_idf_cod, pre_emp_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pre_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pre_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pre_cod")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pre_cod", insertable = false, updatable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pre_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pre_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pre_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pre_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pre_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pre_idf_fk"))
})
public class PressupostEntity extends AbstractWithIdentificadorAuditableEntity<Pressupost, PressupostPk> {

	@Embedded
	protected Pressupost embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_pre_emp_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public PressupostEntity(
			PressupostPk pk,
			Pressupost embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
			
	}

	@Override
	public void update(Pressupost embedded) {
		this.embedded = embedded;
	}	

}
