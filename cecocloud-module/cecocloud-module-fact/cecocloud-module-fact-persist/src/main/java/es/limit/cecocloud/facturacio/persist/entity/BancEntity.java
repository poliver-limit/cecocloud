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
import es.limit.cecocloud.facturacio.logic.api.dto.Banc;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un idioma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ban",
		indexes = {
				@Index(name = "iges_ban_idf_fk", columnList = "ban_idf_cod"),
				@Index(name = "irges_ban_pk", columnList = "ban_idf_cod,ban_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ban_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ban_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ban_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "ban_nom", nullable = false, length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ban_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ban_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ban_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ban_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ban_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ban_idf_fk"))
})
public class BancEntity extends AbstractWithIdentificadorEntity<Banc, WithIdentificadorAndCodiPk<Integer>> {

	@Embedded
	protected Banc embedded;

	@Builder
	public BancEntity(
			WithIdentificadorAndCodiPk<Integer> pk,
			Banc embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Banc embedded) {
		this.embedded = embedded;
	}

}
