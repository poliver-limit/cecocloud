/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusIncidenciaFactura;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusIncidenciaFactura.TipusIncidenciaFacturaPk;
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
public class TipusIncidenciaFacturaEntity extends AbstractAuditableCompositePkEntity<TipusIncidenciaFactura, TipusIncidenciaFacturaPk> {

	@Embedded
	protected TipusIncidenciaFactura embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tin_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_tin_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public TipusIncidenciaFacturaEntity(
			TipusIncidenciaFacturaPk pk,
			TipusIncidenciaFactura embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(TipusIncidenciaFactura embedded) {
		this.embedded = embedded;
	}

}
