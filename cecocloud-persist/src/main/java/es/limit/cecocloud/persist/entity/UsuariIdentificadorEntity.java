/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableCompositePkEntity;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa una relacio usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "usuari_ident")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.identificadorId", column = @Column(name = "identificador_id"))
})
public class UsuariIdentificadorEntity extends AbstractAuditableVersionableCompositePkEntity<UsuariIdentificador, UsuariIdentificadorPk> {

	@Embedded
	protected UsuariIdentificador embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuari_id", foreignKey = @ForeignKey(name = "usuidf_usuari_fk"), insertable = false, updatable = false)
	protected UsuariEntity usuari;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "identificador_id", foreignKey = @ForeignKey(name = "usuidf_identificador_fk"), insertable = false, updatable = false)
	protected IdentificadorEntity identificador;

	@Builder
	public UsuariIdentificadorEntity(
			UsuariIdentificadorPk pk,
			UsuariIdentificador embedded,
			UsuariEntity usuari,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.usuari = usuari;
		this.identificador = identificador;
	}

	@Override
	public void update(UsuariIdentificador embedded) {
		this.embedded = embedded;
	}

}
