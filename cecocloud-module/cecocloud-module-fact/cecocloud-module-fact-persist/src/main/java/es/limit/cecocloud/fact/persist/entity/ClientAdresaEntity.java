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

import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_acc",
		indexes = {
				@Index(name = "iges_acc_idf_fk", columnList = "acc_idf_cod"),
				@Index(name = "irges_acc_pk", columnList = "acc_idf_cod,acc_cod", unique = true)
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "acc_idf_cod", length = 4)),
		@AttributeOverride(name = "id.clientCodi", column = @Column(name = "acc_cli_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "acc_cod", length = 4)),
		
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "acc_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.domicili", column = @Column(name = "acc_dom", length = 30, nullable = false)),
		@AttributeOverride(name = "embedded.direccionExclusivaEnvio", column = @Column(name = "acc_env", length = 10)),
		
		@AttributeOverride(name = "embedded.domiciliDefecte", column = @Column(name = "acc_def", length = 1, nullable = false)),
		@AttributeOverride(name = "embedded.telefon", column = @Column(name = "acc_tel", length = 60)),
		@AttributeOverride(name = "embedded.fax", column = @Column(name = "acc_fax", length = 60)),
		@AttributeOverride(name = "embedded.email", column = @Column(name = "acc_eml", length = 60)),
		@AttributeOverride(name = "embedded.contacte", column = @Column(name = "acc_con", length = 60)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "acc_obs", length = 1000)),
		@AttributeOverride(name = "embedded.bloquejada", column = @Column(name = "acc_blo", length = 1, nullable = false)),
		@AttributeOverride(name = "embedded.telefonMovil", column = @Column(name = "acc_telmov", length = 60)),
		@AttributeOverride(name = "embedded.cif", column = @Column(name = "acc_ref001", length = 50)),
		@AttributeOverride(name = "embedded.activitat", column = @Column(name = "acc_ref002", length = 50)),
		@AttributeOverride(name = "embedded.adressaWeb", column = @Column(name = "acc_ref003", length = 50)),
		@AttributeOverride(name = "embedded.latitut", column = @Column(name = "acc_lat", length = 22)),
		@AttributeOverride(name = "embedded.longitut", column = @Column(name = "acc_lon", length = 22)),					
		
		@AttributeOverride(name = "createdBy", column = @Column(name = "acc_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "acc_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "acc_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "acc_datmod")) 
})
@AssociationOverrides({ 
		@AssociationOverride(
					name = "identificador",
					joinColumns = {
							@JoinColumn(name = "acc_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_acc_idf_fk")) 
		})

public class ClientAdresaEntity extends AbstractWithIdentificadorAuditableEntity<ClientAdresa, ClientAdresaPk> {

	@Embedded
	protected ClientAdresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(value = {
						@JoinColumn(name = "acc_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "acc_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
				},
				foreignKey = @ForeignKey(name = "rges_acc_cli_fk"))
	protected ClientEntity client;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "acc_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "acc_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "acc_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "acc_cpo_cod")
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "acc_idf_cod", referencedColumnName = "scl_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "acc_scl_cod", referencedColumnName = "scl_cod", insertable = false, updatable = false),
						@JoinColumn(name = "acc_cli_cod", referencedColumnName = "scl_cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "acc_scl_cod_fk"))
	private SubClientEntity subClient;
	@Column(name = "acc_scl_cod")
	private String subClientCodi;

	@Builder
	public ClientAdresaEntity(
			ClientAdresaPk pk, 
			ClientAdresa embedded, 
			IdentificadorEntity identificador,
			ClientEntity client, 
			CodiPostalEntity codiPostal,
			SubClientEntity subClient) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.client = client;
		updateCodiPostal(codiPostal);
		updateSubClient(subClient);
	}

	@Override
	public void update(ClientAdresa embedded) {
		this.embedded = embedded;
	}

	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}
	
	public void updateSubClient(SubClientEntity subClient) {
		this.subClient = subClient;
		if (subClient != null) {
			this.subClientCodi = subClient.getId().getCodi();
		}
	}

}
