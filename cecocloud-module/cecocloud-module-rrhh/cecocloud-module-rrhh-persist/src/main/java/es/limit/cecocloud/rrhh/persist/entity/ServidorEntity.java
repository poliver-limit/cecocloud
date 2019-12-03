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

import es.limit.cecocloud.rrhh.logic.api.dto.Servidor;
import es.limit.cecocloud.rrhh.logic.api.dto.Servidor.ServidorPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Servidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_sno",
		indexes = {
				@Index(name = "irhu_sno_idf_fk", columnList = "sno_idf_cod"),
				@Index(name = "irrhu_sno_pk", columnList = "sno_idf_cod,sno_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sno_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "sno_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "sno_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "sno_des", length = 1000)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "sno_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sno_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sno_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sno_datmod"))
})
public class ServidorEntity extends AbstractAuditableCompositePkEntity<Servidor, ServidorPk> {

	@Embedded
	protected Servidor embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "sno_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_sno_idf_fk"))
	protected IdentificadorEntity identificador;
	
	@Builder
	public ServidorEntity(
			ServidorPk pk,
			Servidor embedded,
			IdentificadorEntity identificador		
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(Servidor embedded) {
		this.embedded = embedded;
	}

}
