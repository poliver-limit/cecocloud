/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatTipus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una unitat tipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tun",
		indexes = {
				@Index(name = "iges_tun_idf_fk", columnList = "tun_idf_cod"),
				@Index(name = "irges_tun_pk", columnList = "tun_idf_cod,tun_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tun_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tun_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tun_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tun_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.factorConversio", column = @Column(name = "tun_fc", precision = 14, scale = 4, nullable = true)),
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
			foreignKey = @ForeignKey(name = "rges_tun_idf_fk"))
})
public class UnitatTipusEntity extends AbstractWithIdentificadorEntity<UnitatTipus, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected UnitatTipus embedded;

	@Builder
	public UnitatTipusEntity(
			WithIdentificadorAndCodiPk<String> pk,
			UnitatTipus embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(UnitatTipus embedded) {
		this.embedded = embedded;
	}

}
