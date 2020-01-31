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

import es.limit.cecocloud.fact.logic.api.dto.FinalFactura;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de FinalFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ffa",
		indexes = {
				@Index(name = "iges_ffa_idf_fk", columnList = "ffa_idf_cod"),
				@Index(name = "irges_ffa_pk", columnList = "ffa_idf_cod,ffa_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ffa_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ffa_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ffa_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "ffa_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ffa_des", length = 1000)),
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "ffa_act", length = 1, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ffa_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ffa_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ffa_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ffa_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ffa_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ffa_idf_fk"))
})
public class FinalFacturaEntity extends AbstractWithIdentificadorEntity<FinalFactura, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected FinalFactura embedded;

	@Builder
	public FinalFacturaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			FinalFactura embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(FinalFactura embedded) {
		this.embedded = embedded;
	}

}
