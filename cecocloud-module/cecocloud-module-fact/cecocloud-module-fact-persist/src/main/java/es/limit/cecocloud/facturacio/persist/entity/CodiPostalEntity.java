/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.CodiPostal;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un codi postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_cpo",
		indexes = {
				@Index(name = "iges_cpo_idf_fk", columnList = "cpo_idf_cod"),
				@Index(name = "irges_cpo_pk", columnList = "cpo_idf_cod,cpo_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cpo_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "cpo_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "cpo_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.poblacio", column = @Column(name = "cpo_pob", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.municipi", column = @Column(name = "cpo_mun", length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "cpo_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "cpo_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cpo_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cpo_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "cpo_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cpo_idf_fk"))
})
public class CodiPostalEntity extends AbstractWithIdentificadorEntity<CodiPostal, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected CodiPostal embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	/*@JoinColumnsOrFormulas(
			value = {
					@JoinColumnOrFormula(formula = @JoinFormula(value = "cpo_idf_cod", referencedColumnName = "pas_idf_cod")),
					@JoinColumnOrFormula(column = @JoinColumn(name = "cpo_pas_cod", referencedColumnName = "pas_cod"))
			})
//			foreignKey = @ForeignKey(name = "rges_cpo_pas_fk"))*/
	@JoinColumns(
			value = {
				@JoinColumn(name = "cpo_idf_cod", referencedColumnName = "pas_idf_cod", insertable = false, updatable = false),
				@JoinColumn(name = "cpo_pas_cod", referencedColumnName = "pas_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cpo_pas_fk"))
	protected PaisEntity pais;
	@Column(name = "cpo_pas_cod", length = 4, nullable = false)
	private String paisCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
				@JoinColumn(name = "cpo_idf_cod", referencedColumnName = "prv_idf_cod", insertable = false, updatable = false),
				@JoinColumn(name = "cpo_pas_cod", referencedColumnName = "prv_pas_cod", insertable = false, updatable = false),
				@JoinColumn(name = "cpo_prv_cod", referencedColumnName = "prv_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_cpo_prv_fk"))
	protected ProvinciaEntity provincia;
	@Column(name = "cpo_prv_cod", length = 4, nullable = false)
	private String provinciaCodi;

	@Builder
	public CodiPostalEntity(
			WithIdentificadorAndCodiPk<String> pk,
			CodiPostal embedded,
			IdentificadorEntity identificador,
			PaisEntity pais,
			ProvinciaEntity provincia) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.pais = pais;
		this.provincia = provincia;
		
//		this.setEmbeddedCodis();
		this.paisCodi = pais.getEmbedded().getCodi();	
		this.provinciaCodi = provincia.getEmbedded().getCodi();	
	}

	@Override
	public void update(CodiPostal embedded) {
		this.embedded = embedded;
//		this.setEmbeddedCodis();
	}
	
	public void updatePais (PaisEntity pais) {
		this.paisCodi = pais.getEmbedded().getCodi();		
	}
	
	public void updateProvincia (ProvinciaEntity provincia) {
		this.provinciaCodi = provincia.getEmbedded().getCodi();		
	}
	
//	private void setEmbeddedCodis () {		
//		
//		// Referencies sobre camps obligatoris
//		this.paisCodi = embedded.getPais().getPk().getCodi();
//		this.provinciaCodi = embedded.getProvincia().getPk().getCodi();		
//	}

}
