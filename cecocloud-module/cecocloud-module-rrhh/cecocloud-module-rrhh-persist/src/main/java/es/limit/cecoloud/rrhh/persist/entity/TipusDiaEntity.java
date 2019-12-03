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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia.TipusDiaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un TipusDia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_tdi",
		indexes = {
				@Index(name = "irhu_tdi_idf_fk", columnList = "tdi_idf_cod"),
				@Index(name = "irrhu_tdi_pk", columnList = "tdi_idf_cod,tdi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tdi_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "tdi_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tdi_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.regimCodi", column = @Column(name = "tdi_reg_cod", length = 4)),	
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tdi_nom", length = 30, nullable = false)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "tdi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tdi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tdi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tdi_datmod"))
})
public class TipusDiaEntity extends AbstractAuditableCompositePkEntity<TipusDia, TipusDiaPk> {

	@Embedded
	protected TipusDia embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tdi_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_tdi_idf_fk"))
	protected IdentificadorEntity identificador;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tdi_idf_cod", referencedColumnName = "reg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tdi_reg_cod", referencedColumnName = "reg_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tdi_reg_fk"))
	@NotFound(action = NotFoundAction.IGNORE)
	protected RegimEntity regim;	
	
	@Builder
	public TipusDiaEntity(
			TipusDiaPk pk,
			TipusDia embedded,
			IdentificadorEntity identificador,
			RegimEntity regim
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.regim = regim;		
	}

	@Override
	public void update(TipusDia embedded) {
		this.embedded = embedded;
	}

}