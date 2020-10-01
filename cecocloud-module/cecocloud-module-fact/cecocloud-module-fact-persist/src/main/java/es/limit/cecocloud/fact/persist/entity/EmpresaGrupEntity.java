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

import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup.EmpresaGrupPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de empresa del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factEmpresaGrupEntity")
@Table(
		name = "tges_emg",
		indexes = {
				@Index(name = "iges_emg_idf_fk", columnList = "emg_idf_cod"),
				@Index(name = "irges_emg_pk", columnList = "emg_idf_cod, emg_gru_cod, emg_emp_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "emg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.grupCodi", column = @Column(name = "emg_gru_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "emg_emp_cod", length = 4)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "emg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "emg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "emg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "emg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "emg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_emg_idf_fk"))
})
public class EmpresaGrupEntity extends AbstractWithIdentificadorAuditableEntity<EmpresaGrup, EmpresaGrupPk> {

	@Embedded
	protected EmpresaGrup embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "emg_idf_cod", referencedColumnName = "gru_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "emg_gru_cod", referencedColumnName = "gru_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_emg_gru_fk"))			
	protected GroupEntity grup;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "emg_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "emg_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_emg_emp_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public EmpresaGrupEntity(
			EmpresaGrupPk pk,			
			IdentificadorEntity identificador,
			EmpresaGrup embedded,
			GroupEntity grup,
			EmpresaEntity empresa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.grup = grup;
		this.empresa = empresa;		

	}

	@Override
	public void update(EmpresaGrup embedded) {
		this.embedded = embedded;
	}

}
