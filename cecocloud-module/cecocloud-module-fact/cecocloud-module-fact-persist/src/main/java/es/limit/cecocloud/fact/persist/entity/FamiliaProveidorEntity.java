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

import es.limit.cecocloud.fact.logic.api.dto.FamiliaProveidor;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una familia proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_fpr",
		indexes = {
				@Index(name = "iges_fpr_idf_fk", columnList = "fpr_idf_cod"),
				@Index(name = "irges_fpr_pk", columnList = "fpr_idf_cod,fpr_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fpr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "fpr_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "fpr_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "fpr_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.ctacprcmp", column = @Column(name = "fpr_ctacprcmp", length = 10, nullable = true)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "fpr_obs", length = 1000, nullable = true)),
	@AttributeOverride(name = "embedded.tipasicmp", column = @Column(name = "fpr_tipasicmp", length = 2, nullable = true)),
	@AttributeOverride(name = "embedded.dricmp", column = @Column(name = "fpr_dricmp" , length = 2, nullable = true)),
	@AttributeOverride(name = "embedded.driprfcmp", column = @Column(name = "fpr_driprfcmp",  length = 2, nullable = true)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "fpr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "fpr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fpr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fpr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "fpr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_fpr_idf_fk"))
})
public class FamiliaProveidorEntity extends AbstractWithIdentificadorAuditableEntity<FamiliaProveidor, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected FamiliaProveidor embedded;

	@Builder
	public FamiliaProveidorEntity(
			WithIdentificadorAndCodiPk<String> pk,
			FamiliaProveidor embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(FamiliaProveidor embedded) {
		this.embedded = embedded;
	}

}
