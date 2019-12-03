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

import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari.OperariPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_ope",
		indexes = {
				@Index(name = "irhu_ope_idf_fk", columnList = "ope_idf_cod"),
				@Index(name = "irrhu_ope_pk", columnList = "ope_idf_cod,ope_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ope_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "ope_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ope_cod", length = 4, insertable = false, updatable = false)),	
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "ope_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ope_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ope_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ope_datmod"))
})
public class ParametreEntity extends AbstractAuditableCompositePkEntity<Operari, OperariPk> {

	@Embedded
	protected Operari embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "ope_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_ope_idf_fk"))
	protected IdentificadorEntity identificador;

	
	@Builder
	public ParametreEntity(
			OperariPk pk,
			Operari embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	
	}

	@Override
	public void update(Operari embedded) {
		this.embedded = embedded;
	}

}
