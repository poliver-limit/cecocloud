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

import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusIncidenciaFactura;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus incidenciaFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tin",
		indexes = {
				@Index(name = "iges_tin_idf_fk", columnList = "tin_idf_cod"),
				@Index(name = "irges_tin_pk", columnList = "tin_idf_cod,tin_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tin_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tin_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tin_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tin_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tin_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tin_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tin_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tin_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tin_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tin_idf_fk"))
})
public class TipusIncidenciaFacturaEntity extends AbstractWithIdentificadorEntity<TipusIncidenciaFactura, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusIncidenciaFactura embedded;

	@Builder
	public TipusIncidenciaFacturaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusIncidenciaFactura embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusIncidenciaFactura embedded) {
		this.embedded = embedded;
	}

}
