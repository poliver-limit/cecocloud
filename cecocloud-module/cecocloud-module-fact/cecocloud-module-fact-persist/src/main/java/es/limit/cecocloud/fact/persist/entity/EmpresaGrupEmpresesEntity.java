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

import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses.EmpresaGrupEmpresesPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de empresa del grup de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factEmpresaGrupEmpresesEntity")
@Table(
		name = "tges_gre",
		indexes = {
				@Index(name = "iges_gre_idf_fk", columnList = "gre_idf_cod"),
				@Index(name = "irges_gre_pk", columnList = "gre_idf_cod, gre_grp_cod, gre_emp_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gre_idf_cod", length = 4)),
	@AttributeOverride(name = "id.grupEmpresesCodi", column = @Column(name = "gre_grp_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "gre_emp_cod", length = 4)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "gre_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "gre_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "gre_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "gre_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "gre_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_gre_idf_fk"))
})
public class EmpresaGrupEmpresesEntity extends AbstractWithIdentificadorAuditableEntity<EmpresaGrupEmpreses, EmpresaGrupEmpresesPk> {

	@Embedded
	protected EmpresaGrupEmpreses embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "gre_idf_cod", referencedColumnName = "grp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "gre_grp_cod", referencedColumnName = "grp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_gre_gru_fk"))			
	protected BusinessGroupEntity grupEmpreses;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "gre_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "gre_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_gre_emp_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public EmpresaGrupEmpresesEntity(
			EmpresaGrupEmpresesPk pk,			
			IdentificadorEntity identificador,
			EmpresaGrupEmpreses embedded,
			BusinessGroupEntity grupEmpreses,
			EmpresaEntity empresa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.grupEmpreses = grupEmpreses;
		this.empresa = empresa;		

	}

	@Override
	public void update(EmpresaGrupEmpreses embedded) {
		this.embedded = embedded;
	}

}
