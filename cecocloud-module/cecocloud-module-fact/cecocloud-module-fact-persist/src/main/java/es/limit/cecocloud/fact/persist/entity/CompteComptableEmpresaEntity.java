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

import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa.CompteComptableEmpresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un compte comptable empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_cce",
		indexes = {
				@Index(name = "iges_cce_idf_fk", columnList = "cce_idf_cod"),				
				@Index(name = "irges_cce_pk", columnList = "cce_idf_cod, cce_cli_cod, cce_emp_cod", unique = true)
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cce_idf_cod", length = 4)),
	@AttributeOverride(name = "id.clientCodi", column = @Column(name = "cce_cli_cod", length = 6)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "cce_emp_cod", length = 4)),	
	@AttributeOverride(name = "embedded.compteComptable", column = @Column(name = "cce_ctecmp", length = 10)),
	@AttributeOverride(name = "embedded.compteVendes", column = @Column(name = "cce_cteven", length = 10))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cce_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cce_idf_fk"))
})
public class CompteComptableEmpresaEntity extends AbstractWithIdentificadorEntity<CompteComptableEmpresa, CompteComptableEmpresaPk> {

	@Embedded
	protected CompteComptableEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cce_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cce_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cce_cli_fk"))
	protected ClientEntity client;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cce_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cce_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cce_emp_fk"))
	protected EmpresaEntity empresa;	

	@Builder
	public CompteComptableEmpresaEntity(
			CompteComptableEmpresaPk pk,
			CompteComptableEmpresa embedded,
			IdentificadorEntity identificador,			
			ClientEntity client,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	
		this.client = client;
		this.empresa = empresa;		
	}

	@Override
	public void update(CompteComptableEmpresa embedded) {
		this.embedded = embedded;
	}

}
