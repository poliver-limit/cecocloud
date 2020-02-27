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

import es.limit.cecocloud.fact.logic.api.dto.SituacioComercial;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una situacio comercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_stc",
		indexes = {
				@Index(name = "iges_stc_idf_fk", columnList = "stc_idf_cod"),
				@Index(name = "irges_stc_pk", columnList = "stc_idf_cod,stc_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "stc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "stc_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "stc_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "stc_nom", length = 30)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "stc_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "stc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "stc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "stc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "stc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "stc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_stc_idf_fk"))
})
public class SituacioComercialEntity extends AbstractWithIdentificadorAuditableEntity<SituacioComercial, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected SituacioComercial embedded;

	@Builder
	public SituacioComercialEntity(
			WithIdentificadorAndCodiPk<String> pk,
			SituacioComercial embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(SituacioComercial embedded) {
		this.embedded = embedded;
	}

}
