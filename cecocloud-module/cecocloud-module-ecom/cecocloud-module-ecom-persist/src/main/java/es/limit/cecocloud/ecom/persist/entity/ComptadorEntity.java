/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.logic.api.dto.Comptador;
import es.limit.cecocloud.logic.api.dto.Comptador.ComptadorPk;
import es.limit.cecocloud.persist.entity.AbstractComptadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un comptador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Entity
@Table(
		name = "tcom_cnt",
		indexes = {
				@Index(name = "icom_cnt_idf_fk", columnList = "cnt_idf_cod"),
				@Index(name = "ircom_cnt_pk", columnList = "cnt_idf_cod,cnt_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cnt_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "cnt_cod", length = 15)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cnt_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.darrerValor", column = @Column(name = "cnt_ultval", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "cnt_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cnt_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cnt_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cnt_datmod"))
})
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class ComptadorEntity extends AbstractComptadorEntity {

	@Embedded
	protected Comptador embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "cnt_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rcom_cnt_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public ComptadorEntity(
			ComptadorPk pk,
			Comptador embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Comptador embedded) {
		this.embedded = embedded;
	}

}
