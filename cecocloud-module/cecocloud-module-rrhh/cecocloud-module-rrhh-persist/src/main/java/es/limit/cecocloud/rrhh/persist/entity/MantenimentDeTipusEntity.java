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

import es.limit.cecocloud.rrhh.logic.api.dto.MantenimentDeTipus;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un MantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_vad",
		indexes = {
				@Index(name = "irhu_vad_idf_fk", columnList = "vad_idf_cod"),
				@Index(name = "irrhu_vad_pk", columnList = "vad_idf_cod,vad_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "vad_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "vad_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "vad_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "vad_tip", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "vad_des", length = 1, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "vad_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "vad_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "vad_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "vad_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "vad_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_vad_idf_fk"))
})
public class MantenimentDeTipusEntity extends AbstractWithIdentificadorAuditableEntity<MantenimentDeTipus, WithIdentificadorAndCodiPk<String>>{

	@Embedded
	protected MantenimentDeTipus embedded;

	@Builder
	public MantenimentDeTipusEntity(
			WithIdentificadorAndCodiPk<String> pk,
			MantenimentDeTipus embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(MantenimentDeTipus embedded) {
		this.embedded = embedded;
	}
}