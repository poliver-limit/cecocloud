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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.fact.logic.api.dto.Partida;
import es.limit.cecocloud.fact.logic.api.dto.Partida.PartidaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Partida.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_pda",
		indexes = {				
				@Index(name = "rges_pda_pk", columnList = "pda_idf_cod,pda_emp_cod,pda_pre_cod,pda_cap_cod,pda_cod", unique = true),
				@Index(name = "iges_pda_emp_fk", columnList = "pda_idf_cod, pda_emp_cod"),
				@Index(name = "iges_pda_pre_fk", columnList = "pda_idf_cod, pda_emp_cod, pda_pre_cod"),
				@Index(name = "iges_pda_cap_fk", columnList = "pda_idf_cod, pda_emp_cod, pda_pre_cod,pda_cap_cod")
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pda_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pda_emp_cod", length = 4)),
	@AttributeOverride(name = "id.pressupostCodi", column = @Column(name = "pda_pre_cod")),
	@AttributeOverride(name = "id.capitolCodi", column = @Column(name = "pda_cap_cod")),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pda_cod",length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pda_cod",length = 4, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pda_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pda_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pda_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pda_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pda_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
public class PartidaEntity extends AbstractWithIdentificadorAuditableEntity<Partida, PartidaPk> {

	@Embedded
	protected Partida embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pda_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pda_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_pda_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pda_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pda_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pda_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_pda_pre_fk"))
	protected PressupostEntity pressupost;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pda_idf_cod", referencedColumnName = "cap_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pda_emp_cod", referencedColumnName = "cap_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pda_pre_cod", referencedColumnName = "cap_pre_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pda_cap_cod", referencedColumnName = "cap_cod", insertable = false, updatable = false),
				},
				foreignKey = @ForeignKey(name = "rges_pda_cap_fk"))
	protected CapitolEntity capitol;
	
//	@Formula(value="(SELECT CONCAT(CONCAT(pda.pda_cod,' - '),pda.pda_des) FROM tges_pda pda where pda.pda_cod = pda_cod and pda.pda_idf_cod = pda_idf_cod and pda.pda_emp_cod = pda_emp_cod and pda.pda_pre_cod = pda_pre_cod and pda.pda_cap_cod = pda_cap_cod)")
//	private String descCodiDesc;
	
	@Builder
	public PartidaEntity(
			PartidaPk pk,
			Partida embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PressupostEntity pressupost,
			CapitolEntity capitol
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.pressupost = pressupost;
		this.capitol = capitol;
			
	}

	@Override
	public void update(Partida embedded) {
		this.embedded = embedded;
	}	

}
