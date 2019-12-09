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

import es.limit.cecocloud.rrhh.logic.api.dto.Parametre;
import es.limit.cecocloud.rrhh.logic.api.dto.Parametre.ParametrePk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Parametre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_par",
		indexes = {
				@Index(name = "irhu_par_idf_fk", columnList = "par_idf_cod"),
				@Index(name = "irrhu_par_pk", columnList = "par_idf_cod,par_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "par_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "par_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "par_cod", length = 4, insertable = false, updatable = false)),	
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "par_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "par_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "par_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "par_datmod"))
})
public class ParametreEntity extends AbstractAuditableCompositePkEntity<Parametre, ParametrePk> {

	@Embedded
	protected Parametre embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "par_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_par_idf_fk"))
	protected IdentificadorEntity identificador;

	
	@Builder
	public ParametreEntity(
			ParametrePk pk,
			Parametre embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	
	}

	@Override
	public void update(Parametre embedded) {
		this.embedded = embedded;
	}

}
