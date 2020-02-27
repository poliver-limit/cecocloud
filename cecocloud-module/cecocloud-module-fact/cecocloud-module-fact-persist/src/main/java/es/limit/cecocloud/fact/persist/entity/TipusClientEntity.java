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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.cecocloud.fact.logic.api.dto.TipusClient;
import es.limit.cecocloud.fact.logic.api.dto.TipusClient.TipusClientPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus client
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ctp",
		uniqueConstraints = {
				@UniqueConstraint(name = "tipusr_uk", columnNames = {"ctp_cli_cod", "ctp_tip_cod"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ctp_idf_cod", length = 4)),
	@AttributeOverride(name = "id.clientCodi", column = @Column(name = "ctp_cli_cod", length = 6)),
	@AttributeOverride(name = "id.tipusProveidorClientCodi", column = @Column(name = "ctp_tip_cod", length = 4)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "ctp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ctp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ctp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ctp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ctp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ctp_idf_fk"))
})
public class TipusClientEntity extends AbstractWithIdentificadorAuditableEntity<TipusClient, TipusClientPk> {

	@Embedded
	protected TipusClient embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ctp_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ctp_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ctp_cli_fk"))
	protected ClientEntity client;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ctp_idf_cod", referencedColumnName = "tip_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ctp_tip_cod", referencedColumnName = "tip_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ctp_tip_fk"))
	protected TipusProveidorClientEntity tipusProveidorClient;

	@Builder
	public TipusClientEntity(
			TipusClientPk pk,
			TipusClient embedded,
			IdentificadorEntity identificador,
			ClientEntity client,
			TipusProveidorClientEntity tipusProveidorClient) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.client = client;
		this.tipusProveidorClient = tipusProveidorClient;
		
	}

	@Override
	public void update(TipusClient embedded) {
		this.embedded = embedded;
	}
	
}
