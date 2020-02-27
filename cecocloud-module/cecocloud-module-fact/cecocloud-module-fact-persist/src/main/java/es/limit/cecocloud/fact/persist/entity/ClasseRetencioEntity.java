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

import es.limit.cecocloud.fact.logic.api.dto.ClasseRetencio;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una classe de retenció.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tges_clr", indexes = { @Index(name = "iges_clr_idf_fk", columnList = "clr_idf_cod"),
		@Index(name = "irges_clr_pk", columnList = "clr_idf_cod,clr_cod", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "clr_idf_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "clr_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "clr_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "clr_des", length = 30, nullable = false)),
		@AttributeOverride(name = "embedded.compteVentes", column = @Column(name = "clr_ctecmpven", length = 10)),
		@AttributeOverride(name = "embedded.compteCompres", column = @Column(name = "clr_ctecmpcpr", length = 10)),
		@AttributeOverride(name = "embedded.tipusComptabilitzacio", column = @Column(name = "clr_cmp", length = 10)),
		@AttributeOverride(name = "createdBy", column = @Column(name = "clr_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "clr_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "clr_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "clr_datmod"))
})
@AssociationOverrides({
		@AssociationOverride(
					name = "identificador", 
					joinColumns = {
							@JoinColumn(name = "clr_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_clr_idf_fk"))
})

public class ClasseRetencioEntity
		extends AbstractWithIdentificadorAuditableEntity<ClasseRetencio, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ClasseRetencio embedded;

	@Builder
	public ClasseRetencioEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ClasseRetencio embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(ClasseRetencio embedded) {
		this.embedded = embedded;
	}

}
