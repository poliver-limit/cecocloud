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
import es.limit.cecocloud.facturacio.logic.api.dto.TipusRisc;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tri",
		indexes = {
				@Index(name = "iges_tri_idf_fk", columnList = "tri_idf_cod"),
				@Index(name = "irges_tri_pk", columnList = "tri_idf_cod,tri_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tri_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tri_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tri_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tri_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.tri_pensrv", column = @Column(name = "tri_pensrv", length = 3)),
	@AttributeOverride(name = "embedded.tri_albnotfac", column = @Column(name = "tri_albnotfac", length = 3)),
	@AttributeOverride(name = "embedded.tri_vtopennotvnt", column = @Column(name = "tri_vtopennotvnt", length = 3)),
	@AttributeOverride(name = "embedded.tri_vtopenvnt", column = @Column(name = "tri_vtopenvnt", length = 3)),
	@AttributeOverride(name = "embedded.tri_vtopenvnt", column = @Column(name = "tri_vtopenvnt", length = 3)),
	@AttributeOverride(name = "embedded.tri_efeneg", column = @Column(name = "tri_efeneg", length = 3)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tri_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tri_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tri_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tri_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tri_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tri_idf_fk"))
})
public class TipusRiscEntity extends AbstractAmbIdentificadorEntity<TipusRisc, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected TipusRisc embedded;

	@Builder
	public TipusRiscEntity(
			AmbIdentificadorICodiPk<String> pk,
			TipusRisc embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusRisc embedded) {
		this.embedded = embedded;
	}

}
