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

import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient;
import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient.DepartamentClientPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un departament-client
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_dpc",
		indexes = {
				@Index(name = "iges_dpc_idf_fk", columnList = "dpc_idf_cod"),
				@Index(name = "irges_dpc_pk", columnList = "dpc_idf_cod,dpc_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "dpc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.clientCodi", column = @Column(name = "dpc_cli_cod", length = 6)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "dpc_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "dpc_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "dpc_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "dpc_dom", length = 60)),
	@AttributeOverride(name = "embedded.telefon1", column = @Column(name = "dpc_tel001", length = 60)),
	@AttributeOverride(name = "embedded.telefon2", column = @Column(name = "dpc_tel002", length = 60)),
	@AttributeOverride(name = "embedded.fax1", column = @Column(name = "dpc_fax001", length = 60)),
	@AttributeOverride(name = "embedded.fax2", column = @Column(name = "dpc_fax002", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "dpc_eml", length = 60)),	
	@AttributeOverride(name = "embedded.adressaWeb", column = @Column(name = "dpc_www", length = 60)),
	@AttributeOverride(name = "embedded.responsable", column = @Column(name = "dpc_con", length = 60)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "dpc_obs", length = 1000)),	
	@AttributeOverride(name = "embedded.cif", column = @Column(name = "dpc_ref001", length = 50)),
	@AttributeOverride(name = "embedded.activitat", column = @Column(name = "dpc_ref002", length = 50)),
	@AttributeOverride(name = "embedded.bloquejat", column = @Column(name = "dpc_blo", length = 1)),	

	@AttributeOverride(name = "createdBy", column = @Column(name = "dpc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "dpc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "dpc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "dpc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "dpc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpc_idf_fk"))
})
public class DepartamentClientEntity extends AbstractWithIdentificadorAuditableEntity<DepartamentClient, DepartamentClientPk> {

	@Embedded
	protected DepartamentClient embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dpc_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpc_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpc_cli_fk"))
	protected ClientEntity client;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dpc_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpc_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpc_cpo_fk"))
	protected CodiPostalEntity codiPostal;
	@Column(name = "dpc_cpo_cod", length = 10)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dpc_idf_cod", referencedColumnName = "scl_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpc_scl_cod", referencedColumnName = "scl_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpc_cli_cod", referencedColumnName = "scl_cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpc_scl_fk"))
	protected SubClientEntity subClient;
	@Column(name = "dpc_scl_cod", length = 10)
	private String subClientCodi;
	
	@Builder
	public DepartamentClientEntity(
			DepartamentClientPk pk,
			DepartamentClient embedded,
			IdentificadorEntity identificador,
			ClientEntity client,
			CodiPostalEntity codiPostal,
			SubClientEntity subClient) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.client = client;
		
		if (codiPostal!=null) {
			this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		}
		
		if (subClient != null) {
			this.subClientCodi = subClient.getEmbedded().getCodi();
		}
	}

	@Override
	public void update(DepartamentClient embedded) {
		this.embedded = embedded;
	}
	
	public void updateCodiPostal (CodiPostalEntity codiPostal) {
		if (codiPostal!=null) {
			this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		}
	}
	
	public void updateSubClient (SubClientEntity subClient) {
		if (subClient!=null) {
			this.subClientCodi = subClient.getEmbedded().getCodi();
		}
	}

}
 