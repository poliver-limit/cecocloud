/**
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

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "rrhhZonaEntity")
@Table(
		name = "trhu_zon",
		indexes = {
				@Index(name = "irhu_zon_idf_fk", columnList = "zon_idf_cod"),
				@Index(name = "irrhu_zon_pk", columnList = "zon_idf_cod,zon_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "zon_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "zon_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "zon_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.zonaTreball", column = @Column(name = "zon_zontre", nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "zon_nom", length = 30)),
	@AttributeOverride(name = "embedded.observacio", column = @Column(name = "zon_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "zon_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "zon_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "zon_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "zon_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "zon_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_zon_idf_fk"))
})
public class ZonaEntity extends AbstractWithIdentificadorAuditableEntity<Zona, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Zona embedded;

	@Builder
	public ZonaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Zona embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(Zona embedded) {
		this.embedded = embedded;
	}

}
