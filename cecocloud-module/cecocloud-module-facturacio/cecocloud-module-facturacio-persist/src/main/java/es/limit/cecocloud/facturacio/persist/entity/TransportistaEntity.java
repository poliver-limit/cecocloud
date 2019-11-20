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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.Transportista;
import es.limit.cecocloud.facturacio.logic.api.dto.Transportista.TransportistaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un transportista
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_tra",
		indexes = { @Index(name = "iges_tra_idf_fk", columnList = "tra_idf_cod"),
					@Index(name = "irges_tra_pk", columnList = "tra_idf_cod,tra_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tra_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tra_cod", length = 4)),	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tra_cod", length = 4, insertable = false, updatable = false)),
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class TransportistaEntity)
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tra_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "tra_nif", length = 12, nullable = false)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "tra_dom")),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "tra_tel")),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "tra_fax")),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "tra_eml")),
	@AttributeOverride(name = "embedded.adresaWeb", column = @Column(name = "tra_www")),
	@AttributeOverride(name = "embedded.contacte", column = @Column(name = "tra_con")),
	@AttributeOverride(name = "embedded.formaPagament", column = @Column(name = "tra_fpa")),
	@AttributeOverride(name = "embedded.horaRepartiment", column = @Column(name = "tra_hri")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tra_obs")),
	@AttributeOverride(name = "embedded.vehicleEmpresa", column = @Column(name = "tra_vehemp")),
	
	// Join Columns
	@AttributeOverride(name = "embedded.codiPostalCodi", column = @Column(name = "tra_cpo_cod", length = 8, nullable = false)),
	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "tra_div_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.proveidorCodi", column = @Column(name = "tra_pro_cod")),	
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "tra_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tra_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tra_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tra_datmod"))
})
public class TransportistaEntity extends AbstractAuditableCompositePkEntity<Transportista, TransportistaPk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected Transportista embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tra_idf_cod",
			foreignKey = @ForeignKey(name = "rges_tra_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "tra_idf_cod",
				referencedColumnName = "cpo_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "tra_cpo_cod",
				referencedColumnName = "cpo_cod",
				insertable = false,
				updatable = false)
	})
	private CodiPostalEntity codiPostal;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "tra_idf_cod",
				referencedColumnName = "div_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "tra_div_cod",
				referencedColumnName = "div_cod",
				insertable = false,
				updatable = false)
	})
	private DivisaEntity divisa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "tra_idf_cod",
				referencedColumnName = "pro_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "tra_pro_cod",
				referencedColumnName = "pro_cod",
				insertable = false,
				updatable = false)
	})
	private ProveidorEntity proveidor;

	
	@Builder
	public TransportistaEntity(
			TransportistaPk pk,
			Transportista embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa,
			ProveidorEntity proveidor
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.codiPostal = codiPostal;
		this.divisa = divisa;
		this.proveidor = proveidor;
	}

	@Override
	public void update(Transportista embedded) {
		this.embedded = embedded;
	}

}
