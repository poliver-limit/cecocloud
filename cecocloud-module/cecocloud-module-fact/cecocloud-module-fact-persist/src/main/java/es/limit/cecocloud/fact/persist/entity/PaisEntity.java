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

import es.limit.cecocloud.fact.logic.api.dto.Pais;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un pais
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_pas",
		indexes = {
				@Index(name = "iges_pas_idf_fk", columnList = "pas_idf_cod"),
				@Index(name = "irges_pas_pk", columnList = "pas_idf_cod,pas_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pas_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pas_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pas_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "pas_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "pas_nif", length = 2)),
	@AttributeOverride(name = "embedded.codiso", column = @Column(name = "pas_codiso", length = 3)),
	@AttributeOverride(name = "embedded.codiso002", column = @Column(name = "pas_codiso002", length = 2)),
	@AttributeOverride(name = "embedded.cee", column = @Column(name = "pas_cee", length = 1)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "pas_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pas_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pas_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pas_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pas_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pas_idf_fk"))
})
public class PaisEntity extends AbstractWithIdentificadorEntity<Pais, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Pais embedded;

	@Builder
	public PaisEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Pais embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Pais embedded) {
		this.embedded = embedded;
	}

}
