/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.Torn;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_tor",
		indexes = {
				@Index(name = "irhu_tor_idf_fk", columnList = "tor_idf_cod"),
				@Index(name = "irrhu_tor_pk", columnList = "tor_idf_cod,tor_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tor_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tor_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tor_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tor_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tor_obs", length = 1000, nullable = false)),
	@AttributeOverride(name = "embedded.prevalecenLosFestivos", column = @Column(name = "tor_prvfes")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tor_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tor_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tor_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tor_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tor_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_tor_idf_fk"))
})
public class TornEntity extends AbstractWithIdentificadorAuditableEntity<Torn, WithIdentificadorAndCodiPk<String>>{
	
	@Embedded
	protected Torn embedded;

	@Builder
	public TornEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Torn embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Torn embedded) {
		this.embedded = embedded;
	}

}
