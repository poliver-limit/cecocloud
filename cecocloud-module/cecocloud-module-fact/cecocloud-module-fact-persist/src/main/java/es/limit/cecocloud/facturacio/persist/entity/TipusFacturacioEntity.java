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
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusFacturacio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de facturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tfc",
		indexes = {
				@Index(name = "iges_tfc_idf_fk", columnList = "tfc_idf_cod"),
				@Index(name = "irges_tfc_pk", columnList = "tfc_idf_cod,tfc_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tfc_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "tfc_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tfc_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tfc_des", nullable = false, length = 30)),	
	@AttributeOverride(name = "embedded.concedimCredit", column = @Column(name = "tfc_crd", length = 1)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "tfc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tfc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tfc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tfc_datmod"))
})
public class TipusFacturacioEntity extends AbstractAuditableCompositePkEntity<TipusFacturacio, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected TipusFacturacio embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tfc_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_tfc_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public TipusFacturacioEntity(
			AmbIdentificadorICodiPk<String> pk,
			TipusFacturacio embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(TipusFacturacio embedded) {
		this.embedded = embedded;
	}

}
