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

import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una familia cost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_fct",
		indexes = {
				@Index(name = "iges_fct_idf_fk", columnList = "fct_idf_cod"),
				@Index(name = "irges_fct_pk", columnList = "fct_idf_cod,fct_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fct_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "fct_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "fct_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "fct_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "fct_obs", length = 1000)),
//	@AttributeOverride(name = "embedded.articleFamiliaCodi", column = @Column(name = "fct_far_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "fct_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "fct_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fct_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fct_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "fct_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_fct_idf_fk"))
})
public class FamiliaCostEntity extends AbstractWithIdentificadorEntity<FamiliaCost, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected FamiliaCost embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
			@JoinColumn(
					name = "fct_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
			@JoinColumn( name = "fct_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_fct_far_fk"))
	protected ArticleFamiliaEntity articleFamilia;
	@Column(name = "fct_far_cod")
	private String articleFamiliaCodi;

	@Builder
	public FamiliaCostEntity(
			WithIdentificadorAndCodiPk<String> pk,
			FamiliaCost embedded,
			IdentificadorEntity identificador,
			ArticleFamiliaEntity articleFamilia) {
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.articleFamilia = articleFamilia;
		
//		this.setEmbeddedCodis();
		if (articleFamilia != null) {
			this.articleFamiliaCodi = articleFamilia.getEmbedded().getCodi();
		}
	}

	@Override
	public void update(FamiliaCost embedded) {
		this.embedded = embedded;
//		this.setEmbeddedCodis();
	}
	
	public void updateArticleFamilia(ArticleFamiliaEntity articleFamilia) {
		if (articleFamilia != null) {
			this.articleFamiliaCodi = articleFamilia.getEmbedded().getCodi();
		}
	}
	
//	private void setEmbeddedCodis () {	
//		
//		// Referencies sobre camps no obligastoris		
//		if (embedded.getArticleFamilia() != null) {
//			this.articleFamiliaCodi = embedded.getArticleFamilia().getPk().getCodi();
//		}
//		
//	}

}
