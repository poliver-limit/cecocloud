/**
 * 
 */
package es.limit.cecocloud.cita.persist.entity;

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

import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.AbstractWithIdentificadorAuditableEntity;
import es.limit.cecocloud.fact.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tcit_fgr",
		indexes = {
				@Index(name = "ircit_fgr_pk", columnList = "fgr_idf_cod,fgr_cod", unique = true),
				@Index(name = "icit_fgr_idf_fk", columnList = "fgr_idf_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fgr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "fgr_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "fgr_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "fgr_nom", nullable = false, length = 100)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "fgr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "fgr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fgr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fgr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "fgr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_fgr_idf_fk"))
})
public class FestiuGrupEntity extends AbstractWithIdentificadorAuditableEntity<FestiuGrup, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected FestiuGrup embedded;

	@Builder
	public FestiuGrupEntity(
			WithIdentificadorAndCodiPk<String> pk,
			FestiuGrup embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(FestiuGrup embedded) {
		this.embedded = embedded;
	}

}
