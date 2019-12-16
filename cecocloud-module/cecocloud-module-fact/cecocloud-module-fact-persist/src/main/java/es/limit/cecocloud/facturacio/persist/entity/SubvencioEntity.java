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
import es.limit.cecocloud.facturacio.logic.api.dto.Subvencio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una subvencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_sue",
		indexes = {
				@Index(name = "iges_sue_idf_fk", columnList = "sue_idf_cod"),
				@Index(name = "irges_sue_pk", columnList = "sue_idf_cod,sue_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sue_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "sue_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "sue_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "sue_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.origen", column = @Column(name = "sue_ori", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.preuPerKilo", column = @Column(name = "sue_prukgr", length = 22, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "sue_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sue_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sue_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sue_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "sue_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_sue_idf_fk"))
})
public class SubvencioEntity extends AbstractAmbIdentificadorEntity<Subvencio, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Subvencio embedded;

	@Builder
	public SubvencioEntity(
			AmbIdentificadorICodiPk<String> pk,
			Subvencio embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Subvencio embedded) {
		this.embedded = embedded;
	}

}
