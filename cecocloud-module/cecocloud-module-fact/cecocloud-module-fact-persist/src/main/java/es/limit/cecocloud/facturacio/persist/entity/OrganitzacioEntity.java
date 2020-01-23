package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Organitzacio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació sobre el tipus d'una organització.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_org",
		indexes = {
				@Index(name = "iges_org_idf_fk", columnList = "org_idf_cod"),
				@Index(name = "irges_org_pk", columnList = "org_idf_cod,org_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "org_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "org_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "org_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "org_nom", nullable = false, length = 30)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "org_dom", length = 60)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "org_tel", length = 60)),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "org_fax", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "org_eml", length = 60)),
	@AttributeOverride(name = "embedded.adresaWeb", column = @Column(name = "org_www", length = 60)),
	@AttributeOverride(name = "embedded.gerent", column = @Column(name = "org_ger", length = 30)),
	@AttributeOverride(name = "embedded.contacte", column = @Column(name = "org_con", length = 30)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "org_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "org_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "org_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "org_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "org_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "org_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_org_idf_fk"))
})

public class OrganitzacioEntity extends AbstractWithIdentificadorEntity<Organitzacio, WithIdentificadorAndCodiPk<String>> {
	
	@Embedded
	protected Organitzacio embedded;
	
	@ManyToOne(optional = true)
	@JoinColumns({
		@JoinColumn(
				name = "org_idf_cod",
				referencedColumnName = "cpo_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "org_cpo_cod",
				referencedColumnName = "cpo_cod",
				insertable = false,
				updatable = false)
	})
	private CodiPostalEntity codiPostal;
	@Column(name = "org_cpo_cod", length = 4, nullable = false)
	private String codiPostalCodi;

	@Builder
	public OrganitzacioEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Organitzacio embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostal) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		updateCodiPostal(codiPostal);
	}

	@Override
	public void update(Organitzacio embedded) {
		this.embedded = embedded;
	}
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}

}

