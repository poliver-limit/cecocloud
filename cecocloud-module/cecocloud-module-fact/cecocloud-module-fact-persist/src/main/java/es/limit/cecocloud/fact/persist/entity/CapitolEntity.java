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

import es.limit.cecocloud.fact.logic.api.dto.Capitol;
import es.limit.cecocloud.fact.logic.api.dto.Capitol.CapitolPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Capitol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_cap",
		indexes = {				
				@Index(name = "rges_cap_pk", columnList = "cap_idf_cod,cap_emp_cod,cap_pre_cod,cap_cod", unique = true),
				@Index(name = "iges_cap_emp_fk", columnList = "cap_idf_cod, cap_emp_cod"),
				@Index(name = "iges_cap_pre_fk", columnList = "cap_idf_cod, cap_emp_cod, cap_pre_cod")
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cap_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "cap_emp_cod", length = 4)),
	@AttributeOverride(name = "id.pressupostCodi", column = @Column(name = "cap_pre_cod")),
	@AttributeOverride(name = "id.codi", column = @Column(name = "cap_cod",length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cap_cod",length = 4, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "cap_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cap_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cap_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cap_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cap_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
public class CapitolEntity extends AbstractWithIdentificadorAuditableEntity<Capitol, CapitolPk> {

	@Embedded
	protected Capitol embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "cap_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cap_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_cap_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "cap_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cap_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cap_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_cap_pre_fk"))
	protected PressupostEntity pressupost;
	
	@Builder
	public CapitolEntity(
			CapitolPk pk,
			Capitol embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PressupostEntity pressupost
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.pressupost = pressupost;
			
	}

	@Override
	public void update(Capitol embedded) {
		this.embedded = embedded;
	}	

}
