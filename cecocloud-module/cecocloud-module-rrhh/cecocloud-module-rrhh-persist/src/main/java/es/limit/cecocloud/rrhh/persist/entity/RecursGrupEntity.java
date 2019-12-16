/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup.RecursGrupPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un recurs grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_gre",
		indexes = {
				@Index(name = "irhu_gre_idf_fk", columnList = "gre_idf_cod"),
				@Index(name = "irrhu_gre_pk", columnList = "gre_idf_cod,gre_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gre_idf_cod", length = 4)),
	@AttributeOverride(name = "id.paisCodi", column = @Column(name = "gre_pas_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "gre_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "gre_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "gre_nom", length = 30, nullable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "gre_des", nullable = false)),
	@AttributeOverride(name = "embedded.numHor", column = @Column(name = "gre_numhor", nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "gre_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "gre_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "gre_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "gre_datmod"))
})
public class RecursGrupEntity extends AbstractAuditableCompositePkEntity<RecursGrup, RecursGrupPk> {

	@Embedded
	protected RecursGrup embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "gre_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_gre_idf_fk"))
	protected IdentificadorRrhhEntity identificador;

	@Builder
	public RecursGrupEntity(
			RecursGrupPk pk,
			RecursGrup embedded,
			IdentificadorRrhhEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(RecursGrup embedded) {
		this.embedded = embedded;
	}

}
