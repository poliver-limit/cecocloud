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

import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Idioma;
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
		name = "tges_idi",
		indexes = {
				@Index(name = "iges_idi_idf_fk", columnList = "idi_idf_cod"),
				@Index(name = "irges_idi_pk", columnList = "idi_idf_cod,idi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "idi_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "idi_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "idi_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "idi_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.codiIso", column = @Column(name = "idi_codiso", length = 2, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "idi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "idi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "idi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "idi_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "idi_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_idi_idf_fk"))
})
public class IdiomaEntity extends AbstractAmbIdentificadorEntity<Idioma, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Idioma embedded;

	@Builder
	public IdiomaEntity(
			AmbIdentificadorICodiPk<String> pk,
			Idioma embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Idioma embedded) {
		this.embedded = embedded;
	}

}
