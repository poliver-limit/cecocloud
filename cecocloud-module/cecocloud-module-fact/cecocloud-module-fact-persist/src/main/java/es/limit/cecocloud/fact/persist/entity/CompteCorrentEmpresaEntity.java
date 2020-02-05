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

import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa.CompteCorrentEmpresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un compte corrent empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_cbc",
		indexes = {
				@Index(name = "iges_cbc_idf_fk", columnList = "cbc_idf_cod"),
				@Index(name = "irges_cbc_pk", columnList = "cbc_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cbc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.clientCodi", column = @Column(name = "cbc_cli_cod", length = 6)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "cbc_emp_cod", length = 4)),
	@AttributeOverride(name = "id.bancCodi", column = @Column(name = "cbc_ban_cod", length = 4)),
	@AttributeOverride(name = "id.oficinaBancariaCodi", column = @Column(name = "cbc_ofb_cod", length = 4)),
	@AttributeOverride(name = "id.numeroCompteCorrent", column = @Column(name = "cbc_ccr", length = 10)),
	@AttributeOverride(name = "id.digitControl", column = @Column(name = "cbc_dcc", length = 2)),
	
	@AttributeOverride(name = "embedded.numeroCompteCorrent", column = @Column(name = "cbc_ccr", length = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.digitControl", column = @Column(name = "cbc_dcc", length = 2, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "cbc_obs", length = 1000)),
	@AttributeOverride(name = "embedded.paisIban", column = @Column(name = "cbc_ibnpai", length = 2)),
	@AttributeOverride(name = "embedded.digitControlIban", column = @Column(name = "cbc_ibndcc", length = 2)),
	@AttributeOverride(name = "embedded.codiIdentificadorBanc", column = @Column(name = "cbc_ibnbic", length = 11)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "cbc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cbc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cbc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cbc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cbc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cbc_idf_fk"))
})
public class CompteCorrentEmpresaEntity extends AbstractWithIdentificadorEntity<CompteCorrentEmpresa, CompteCorrentEmpresaPk> {

	@Embedded
	protected CompteCorrentEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cbc_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cbc_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cbc_cli_fk"))
	protected ClientEntity client;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cbc_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cbc_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cbc_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cbc_idf_cod", referencedColumnName = "ban_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cbc_ban_cod", referencedColumnName = "ban_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cbc_ban_fk"))
	protected BancEntity banc;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cbc_idf_cod", referencedColumnName = "ofb_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cbc_ofb_cod", referencedColumnName = "ofb_cod", insertable = false, updatable = false),
					@JoinColumn(name = "cbc_ban_cod", referencedColumnName = "ofb_ban_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_cbc_ofb_fk"))
	protected OficinaBancariaEntity oficinaBancaria;	

	@Builder
	public CompteCorrentEmpresaEntity(
			CompteCorrentEmpresaPk pk,
			CompteCorrentEmpresa embedded,
			IdentificadorEntity identificador,
			BancEntity banc,
			ClientEntity client,
			EmpresaEntity empresa,			
			OficinaBancariaEntity oficinaBancaria) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.banc = banc;
		this.client = client;
		this.empresa = empresa;
		this.oficinaBancaria = oficinaBancaria;
		
	}

	@Override
	public void update(CompteCorrentEmpresa embedded) {
		this.embedded = embedded;
	}
	
}
