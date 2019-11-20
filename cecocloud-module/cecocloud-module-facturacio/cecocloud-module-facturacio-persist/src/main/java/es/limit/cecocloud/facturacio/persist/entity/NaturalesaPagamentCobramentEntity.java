/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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
import es.limit.cecocloud.facturacio.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.facturacio.logic.api.dto.NaturalesaPagamentCobrament.NaturalesaPagamentCobramentPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una naturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_npg",
		indexes = { @Index(name = "iges_npg_idf_fk", columnList = "npg_idf_cod"),
					@Index(name = "irges_npg_pk", columnList = "npg_idf_cod,npg_cod", unique = true)
		}
)
@AttributeOverrides({

	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "npg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "npg_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "npg_cod", length = 4, insertable = false, updatable = false)),
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class NaturalesaPagamentCobramentEntity)
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "npg_des", length = 30, nullable = false)),		
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "npg_obs", length = 1000, nullable = false)),	
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "npg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "npg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "npg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "npg_datmod"))
})
public class NaturalesaPagamentCobramentEntity extends AbstractAuditableCompositePkEntity<NaturalesaPagamentCobrament, NaturalesaPagamentCobramentPk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected NaturalesaPagamentCobrament embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "npg_idf_cod",
			foreignKey = @ForeignKey(name = "rges_npg_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest
	
	@Builder
	public NaturalesaPagamentCobramentEntity(
			NaturalesaPagamentCobramentPk pk,
			NaturalesaPagamentCobrament embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(NaturalesaPagamentCobrament embedded) {
		this.embedded = embedded;
	}

}
