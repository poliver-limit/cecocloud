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
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Transportista;
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
@Table(
		name = "tges_tra",
		indexes = {
				@Index(name = "iges_tra_idf_fk", columnList = "tra_idf_cod"),
				@Index(name = "irges_tra_pk", columnList = "tra_idf_cod,tra_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tra_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tra_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tra_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tra_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "tra_nif", length = 12, nullable = false)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "tra_dom")),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "tra_tel")),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "tra_fax")),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "tra_eml")),
	@AttributeOverride(name = "embedded.adresaWeb", column = @Column(name = "tra_www")),
	@AttributeOverride(name = "embedded.contacte", column = @Column(name = "tra_con")),
	@AttributeOverride(name = "embedded.formaPagament", column = @Column(name = "tra_fpa")),
	@AttributeOverride(name = "embedded.horariRepartiment", column = @Column(name = "tra_hri")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tra_obs")),
	@AttributeOverride(name = "embedded.vehicleEmpresa", column = @Column(name = "tra_vehemp")),
	@AttributeOverride(name = "embedded.codiPostalCodi", column = @Column(name = "tra_cpo_cod", length = 8, nullable = false)),
	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "tra_div_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.proveidorCodi", column = @Column(name = "tra_pro_cod")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tra_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tra_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tra_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tra_datmod"))
})
public class TransportistaEntity extends AbstractAuditableCompositePkEntity<Transportista, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Transportista embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tra_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_tra_idf_fk"))
	protected IdentificadorEntity identificador;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tra_cpo_fk"))
	private CodiPostalEntity codiPostal;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tra_div_fk"))
	private DivisaEntity divisa;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "pro_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_pro_cod", referencedColumnName = "pro_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tra_pro_fk"))
	private ProveidorEntity proveidor;

	@Builder
	public TransportistaEntity(
			AmbIdentificadorICodiPk<String> pk,
			Transportista embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa,
			ProveidorEntity proveidor) {
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
