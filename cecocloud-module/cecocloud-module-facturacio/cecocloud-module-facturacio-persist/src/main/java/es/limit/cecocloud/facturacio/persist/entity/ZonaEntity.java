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
import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona.ZonaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_zon",
		indexes = { @Index(name = "iges_zon_idf_fk", columnList = "zon_idf_cod"),
					@Index(name = "irges_zon_pk", columnList = "zon_idf_cod,zon_cod", unique = true)
		}
)
@AttributeOverrides({
//	@AttributeOverride(
//			name = "pk.identificadorCodi",
//			column = @Column(name = TaulesPrefix.ZONA_ + TaulesPrefix.IDENTIFICADOR_ + "cod", length = 4)),
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "zon_idf_cod", length = 4)),
	
//	@AttributeOverride(
//			name = "pk.id",
//			column = @Column(name = TaulesPrefix.ZONA_ + "cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "zon_cod", length = 4)),
	
//	@AttributeOverride(
//			name = "identificadorCodi",
//			column = @Column(name = TaulesPrefix.ZONA_ + TaulesPrefix.IDENTIFICADOR_ + "cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "zon_cod", length = 4, insertable = false, updatable = false)),
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class ZonaEntity)
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "zon_nom", length = 30)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "zon_des", length = 1000)),
	@AttributeOverride(name = "embedded.radioKm", column = @Column(name = "zon_radio_km")),
	@AttributeOverride(name = "embedded.preu", column = @Column(name = "zon_precio")),
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "zon_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "zon_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "zon_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "zon_datmod"))
})
public class ZonaEntity extends AbstractAuditableCompositePkEntity<Zona, ZonaPk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected Zona embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "zon_idf_cod",
			foreignKey = @ForeignKey(name = "rges_zon_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest

	
	@Builder
	public ZonaEntity(
			ZonaPk pk,
			Zona embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Zona embedded) {
		this.embedded = embedded;
	}

}
