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

import es.limit.cecocloud.fact.logic.api.dto.Rappel;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació sobre el tipus rappel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_rap",
		indexes = {
				@Index(name = "iges_rap_idf_fk", columnList = "rap_idf_cod"),
				@Index(name = "irges_rap_pk", columnList = "rap_idf_cod,rap_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "rap_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "rap_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "rap_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "rap_des", length = 30)),
	@AttributeOverride(name = "embedded.limitInferior", column = @Column(name = "rap_limini")),
	@AttributeOverride(name = "embedded.limitSuperior", column = @Column(name = "rap_limfin")),
	@AttributeOverride(name = "embedded.percentatge", column = @Column(name = "rap_pte")),
	@AttributeOverride(name = "embedded.percentatge2", column = @Column(name = "rap_pte001")),
	@AttributeOverride(name = "embedded.escalat", column = @Column(name = "rap_esc", length = 1)),
	@AttributeOverride(name = "embedded.absolut", column = @Column(name = "rap_abs", length = 1)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "rap_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "rap_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "rap_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "rap_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "rap_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_rap_idf_fk"))
})

public class RappelEntity extends AbstractWithIdentificadorAuditableEntity<Rappel, WithIdentificadorAndCodiPk<String>> {
	
	@Embedded
	protected Rappel embedded;

	@Builder
	public RappelEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Rappel embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Rappel embedded) {
		this.embedded = embedded;
	}

}
