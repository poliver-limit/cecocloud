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
import es.limit.cecocloud.facturacio.logic.api.dto.TarifaDescompte;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una tarifa descompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tds",
		indexes = {
				@Index(name = "iges_tds_idf_fk", columnList = "tds_idf_cod"),
				@Index(name = "irges_tds_pk", columnList = "tds_idf_cod,tds_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tds_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tds_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tds_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tds_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tds_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tds_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tds_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tds_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tds_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tds_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tds_idf_fk"))
})
public class TarifaDescompteEntity extends AbstractAmbIdentificadorEntity<TarifaDescompte, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected TarifaDescompte embedded;

	@Builder
	public TarifaDescompteEntity(
			AmbIdentificadorICodiPk<String> pk,
			TarifaDescompte embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TarifaDescompte embedded) {
		this.embedded = embedded;
	}

}
