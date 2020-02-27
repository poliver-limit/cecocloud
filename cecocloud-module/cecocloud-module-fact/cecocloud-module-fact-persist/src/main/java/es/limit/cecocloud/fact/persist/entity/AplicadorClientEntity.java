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

import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient;
import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient.AplicadorClientPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un aplicador-client
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_clm",		
		uniqueConstraints = {
				@UniqueConstraint(name = "mancli_uk", columnNames = {"clm_man_cne", "clm_cli_cod"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "clm_idf_cod", length = 4)),
	@AttributeOverride(name = "id.clientCodi", column = @Column(name = "clm_cli_cod", length = 6)),
	@AttributeOverride(name = "id.aplicadorContracte", column = @Column(name = "clm_man_cne", length = 30)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "clm_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "clm_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "clm_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "clm_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "clm_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_clm_idf_fk"))
})
public class AplicadorClientEntity extends AbstractWithIdentificadorAuditableEntity<AplicadorClient, AplicadorClientPk> {

	@Embedded
	protected AplicadorClient embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "clm_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "clm_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_clm_cli_fk"))
	protected ClientEntity client;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "clm_idf_cod", referencedColumnName = "man_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "clm_man_cne", referencedColumnName = "man_cne", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_clm_man_fk"))
	protected AplicadorEntity aplicador;

	@Builder
	public AplicadorClientEntity(
			AplicadorClientPk pk,
			AplicadorClient embedded,
			IdentificadorEntity identificador,
			ClientEntity client,
			AplicadorEntity aplicador) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.client = client;
		this.aplicador = aplicador;
		
	}

	@Override
	public void update(AplicadorClient embedded) {
		this.embedded = embedded;
	}
	
}
