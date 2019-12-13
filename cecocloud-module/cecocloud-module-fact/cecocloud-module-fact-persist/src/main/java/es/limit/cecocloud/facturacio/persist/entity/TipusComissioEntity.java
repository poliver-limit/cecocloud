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
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusComissio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tcs",
		indexes = {
				@Index(name = "iges_tcs_idf_fk", columnList = "tcs_idf_cod"),
				@Index(name = "irges_tcs_pk", columnList = "tcs_idf_cod,tcs_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tcs_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "tcs_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tcs_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tcs_nom", length = 30, nullable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tcs_des", length = 1000)),
	@AttributeOverride(name = "embedded.percentatge", column = @Column(name = "tcs_pte")),	
	@AttributeOverride(name = "embedded.minim", column = @Column(name = "tcs_min")),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tcs_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tcs_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tcs_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tcs_datmod"))
})
public class TipusComissioEntity extends AbstractAuditableCompositePkEntity<TipusComissio, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected TipusComissio embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tcs_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_tcs_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public TipusComissioEntity(
			AmbIdentificadorICodiPk<String> pk,
			TipusComissio embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(TipusComissio embedded) {
		this.embedded = embedded;
	}

}
