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

import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una tarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tpr",
		indexes = {
				@Index(name = "rges_tpr_pk", columnList = "tpr_idf_cod,tpr_cod", unique = true)				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tpr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tpr_cod", length = 6)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tpr_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tpr_nom", length = 1000)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tpr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tpr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tpr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tpr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tpr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tpr_idf_fk"))
})
public class TarifaProveidorEntity extends AbstractWithIdentificadorAuditableEntity<TarifaProveidor, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TarifaProveidor embedded;

	@Builder
	public TarifaProveidorEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TarifaProveidor embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TarifaProveidor embedded) {
		this.embedded = embedded;
	}

}
