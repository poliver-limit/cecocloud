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
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una naturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_npg",
		indexes = {
				@Index(name = "iges_npg_idf_fk", columnList = "npg_idf_cod"),
				@Index(name = "irges_npg_pk", columnList = "npg_idf_cod,npg_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "npg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "npg_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "npg_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "npg_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "npg_obs", length = 1000, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "npg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "npg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "npg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "npg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "npg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_npg_idf_fk"))
})
public class NaturalesaPagamentCobramentEntity extends AbstractWithIdentificadorAuditableEntity<NaturalesaPagamentCobrament, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected NaturalesaPagamentCobrament embedded;

	@Builder
	public NaturalesaPagamentCobramentEntity(
			WithIdentificadorAndCodiPk<String> pk,
			NaturalesaPagamentCobrament embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(NaturalesaPagamentCobrament embedded) {
		this.embedded = embedded;
	}

}
