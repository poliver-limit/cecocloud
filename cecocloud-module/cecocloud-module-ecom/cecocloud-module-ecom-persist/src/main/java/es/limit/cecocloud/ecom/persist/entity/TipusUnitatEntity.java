/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.ecom.logic.api.dto.TipusUnitat;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomTipusUnitatEntity")
@Table(
		name = "tcom_tun",
		indexes = {
				@Index(name = "icom_tun_idf_fk", columnList = "tun_idf_cod"),
				@Index(name = "ircom_tun_pk", columnList = "tun_idf_cod,tun_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tun_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tun_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tun_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tun_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.tunFc", column = @Column(name = "tun_fc", length = 22)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tun_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tun_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tun_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tun_datmod"))
})

@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tun_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tun_idf_fk"))
})
public class TipusUnitatEntity extends AbstractWithIdentificadorAuditableEntity<TipusUnitat, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusUnitat embedded;

	@Builder
	public TipusUnitatEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusUnitat embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusUnitat embedded) {
		this.embedded = embedded;
	}

}
