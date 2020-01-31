/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
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

import es.limit.cecocloud.fact.logic.api.dto.OficinaBancaria;
import es.limit.cecocloud.fact.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tges_ofb", indexes = { @Index(name = "iges_ofb_idf_fk", columnList = "ofb_idf_cod"),
		@Index(name = "irges_ofb_pk", columnList = "ofb_idf_cod,ofb_cod", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ofb_idf_cod", length = 4)),
		@AttributeOverride(name = "id.bancCodi", column = @Column(name = "ofb_ban_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "ofb_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "ofb_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.telefon", column = @Column(name = "ofb_tel", length = 60)),
		@AttributeOverride(name = "embedded.domicili", column = @Column(name = "ofb_dom", length = 60)),
		@AttributeOverride(name = "embedded.fax", column = @Column(name = "ofb_fax", length = 60)),
		@AttributeOverride(name = "embedded.contacte", column = @Column(name = "ofb_con", length = 60)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "ofb_obs", length = 1000)),
		@AttributeOverride(name = "createdBy", column = @Column(name = "ofb_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "ofb_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ofb_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ofb_datmod")) 
})

@AssociationOverrides({ 
		@AssociationOverride(
					name = "identificador", 
					joinColumns = {
							@JoinColumn(name = "ofb_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_ofb_idf_fk"))
})

public class OficinaBancariaEntity extends AbstractWithIdentificadorEntity<OficinaBancaria, OficinaBancariaPk> {

	@Embedded
	protected OficinaBancaria embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ofb_idf_cod", referencedColumnName = "ban_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ofb_ban_cod", referencedColumnName = "ban_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "ofb_ban_cod_fk"))
	private BancEntity banc;
	@Column(name = "ofb_ban_cod", length = 4, insertable = false, updatable = false)
	private Integer bancCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ofb_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ofb_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "ofb_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "ofb_cpo_cod", length = 4, nullable = false)
	private String codiPostalCodi;

	@Builder
	public OficinaBancariaEntity(
			OficinaBancariaPk pk, 
			OficinaBancaria embedded, 
			IdentificadorEntity identificador,
			BancEntity banc,
			CodiPostalEntity codiPostal) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		updateBanc(banc);
		updateCodiPostal(codiPostal);
	}

	@Override
	public void update(OficinaBancaria embedded) {
		this.embedded = embedded;
	}

	public void updateBanc(BancEntity banc) {
		this.banc = banc;
		if (banc != null) {
			this.bancCodi = banc.getId().getCodi();
		}
	}

	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}

}
