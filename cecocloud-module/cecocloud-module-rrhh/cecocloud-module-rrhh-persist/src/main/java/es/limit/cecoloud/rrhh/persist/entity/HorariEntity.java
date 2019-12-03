/**
 * 
 */
package es.limit.cecoloud.rrhh.persist.entity;

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
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari.HorariPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_hor",
		indexes = {
				@Index(name = "irhu_hor_idf_fk", columnList = "hor_idf_cod"),
				@Index(name = "irrhu_hor_pk", columnList = "hor_idf_cod,hor_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "hor_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "hor_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "hor_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "hor_nom", length = 30, nullable = false)),	
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "hor_tip", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "hor_des", length = 1000)),			
	@AttributeOverride(name = "embedded.hores", column = @Column(name = "hor_hor")),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "hor_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "hor_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "hor_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "hor_datmod"))
})
public class HorariEntity extends AbstractAuditableCompositePkEntity<Horari, HorariPk> {

	@Embedded
	protected Horari embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "hor_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_hor_idf_fk"))
	protected IdentificadorEntity identificador;
	
	@Builder
	public HorariEntity(
			HorariPk pk,
			Horari embedded,
			IdentificadorEntity identificador,
			HorariEntity horari
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	
	}

	@Override
	public void update(Horari embedded) {
		this.embedded = embedded;
	}

}
